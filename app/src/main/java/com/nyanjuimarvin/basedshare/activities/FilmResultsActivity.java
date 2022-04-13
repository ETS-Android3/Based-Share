package com.nyanjuimarvin.basedshare.activities;

import static com.nyanjuimarvin.basedshare.constants.Constants.MOVIE_DB_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FilmRecyclerAdapter;
import com.nyanjuimarvin.basedshare.constants.Constants;
import com.nyanjuimarvin.basedshare.databinding.ActivityFilmResultsBinding;
import com.nyanjuimarvin.basedshare.databinding.FragmentMovieCardBinding;
import com.nyanjuimarvin.basedshare.endpoints.FilmEndpoint;
import com.nyanjuimarvin.basedshare.models.film.FilmResponse;
import com.nyanjuimarvin.basedshare.models.film.Result;
import com.nyanjuimarvin.basedshare.retrofit.FilmClient;

import org.parceler.Parcels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmResultsActivity extends AppCompatActivity {

    private ActivityFilmResultsBinding filmResultsBinding;
    private FragmentMovieCardBinding fragmentMovieCardBinding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmResultsBinding = ActivityFilmResultsBinding.inflate(getLayoutInflater());
        View view = filmResultsBinding.getRoot();
        setContentView(view);

        View decorView = getWindow().getDecorView();
        int options = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(options);

        FilmEndpoint filmEndpoint = FilmClient.getFilmClient();
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        Call<FilmResponse> call = filmEndpoint.getFilms(MOVIE_DB_KEY,query);

        call.enqueue(new Callback<FilmResponse>(){

            @Override
            public void onResponse(@NonNull Call<FilmResponse> call, @NonNull Response<FilmResponse> response) {

                if(response.isSuccessful()) {
                    hideProgressBar();
                    Log.i("response", response.raw().toString());
                    List<Result> films = response.body().getResults();
                    Log.d(this.getClass().getSimpleName(), String.valueOf(response.body().getResults().size()));
                    FilmRecyclerAdapter filmRecyclerAdapter = new FilmRecyclerAdapter(getApplicationContext(), films, new FilmRecyclerAdapter.FilmOnClickListener() {
                        @Override
                        public void onItemClick(Result result) {
                            Intent intent = new Intent(getApplicationContext(),FilmDetailActivity.class);
                            intent.putExtra("films", Parcels.wrap(films));
                            startActivity(intent);
                        }
                    });
                    recyclerView = filmResultsBinding.filmsRecycler;
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(filmRecyclerAdapter);
                }
            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {
                Log.e("error",t.toString());
            }

            private void hideProgressBar(){
                filmResultsBinding.filmProgressBar.setVisibility(View.GONE);
                filmResultsBinding.filmsRecycler.setVisibility(View.VISIBLE);
            }

        });
    }
}