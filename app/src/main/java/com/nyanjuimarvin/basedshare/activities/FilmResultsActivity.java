package com.nyanjuimarvin.basedshare.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FilmRecyclerAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityFilmResultsBinding;
import com.nyanjuimarvin.basedshare.endpoints.FilmEndpoint;
import com.nyanjuimarvin.basedshare.models.film.FilmResponse;
import com.nyanjuimarvin.basedshare.models.film.Result;
import com.nyanjuimarvin.basedshare.retrofit.FilmClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmResultsActivity extends AppCompatActivity {

    private ActivityFilmResultsBinding filmResultsBinding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmResultsBinding = ActivityFilmResultsBinding.inflate(getLayoutInflater());
        View view = filmResultsBinding.getRoot();
        setContentView(view);


        FilmEndpoint filmEndpoint = FilmClient.getFilmClient();
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        Call<FilmResponse> call = filmEndpoint.getFilms(query);

        call.enqueue(new Callback<FilmResponse>(){

            @Override
            public void onResponse(@NonNull Call<FilmResponse> call, @NonNull Response<FilmResponse> response) {

                if(response.isSuccessful()){

                    recyclerView = filmResultsBinding.filmsRecycler;

                    List<Result> films = response.body().getResults();
                    FilmRecyclerAdapter filmRecyclerAdapter = new FilmRecyclerAdapter(getApplicationContext(), films, new FilmRecyclerAdapter.FilmOnClickListener() {
                        @Override
                        public void onItemClick(Result result) {
                            Toast.makeText(getApplicationContext(),"CLicked", Toast.LENGTH_LONG).show();
                        }
                    });

                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(filmRecyclerAdapter);
                }




            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}