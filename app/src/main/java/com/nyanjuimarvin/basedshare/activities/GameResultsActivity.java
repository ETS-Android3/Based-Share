package com.nyanjuimarvin.basedshare.activities;

import static com.nyanjuimarvin.basedshare.constants.Constants.RAWG_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.GameRecyclerAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameResultsBinding;
import com.nyanjuimarvin.basedshare.endpoints.GameEndpoint;
import com.nyanjuimarvin.basedshare.models.game.Game;
import com.nyanjuimarvin.basedshare.models.game.GamesResponse;
import com.nyanjuimarvin.basedshare.models.game.Result;
import com.nyanjuimarvin.basedshare.retrofit.GameClient;

import org.parceler.Parcels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameResultsActivity extends AppCompatActivity {

    private ActivityGameResultsBinding gameResultsBinding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameResultsBinding = ActivityGameResultsBinding.inflate(getLayoutInflater());
        View view = gameResultsBinding.getRoot();
        setContentView(view);
        fetchGames("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.searchWidget);
        SearchView searchview = (SearchView) menuItem.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String games) {
                fetchGames(games);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                fetchGames(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void fetchGames(String term){
        GameEndpoint gameEndpoint = GameClient.getGameClient();
        Call<GamesResponse> call = gameEndpoint.getGames(RAWG_KEY,term);
        call.enqueue(new Callback<GamesResponse>(){

            @Override
            public void onResponse(Call<GamesResponse> call, Response<GamesResponse> response) {

                if(!response.isSuccessful()) {
                    gameResultsBinding.errorText.setText(response.message());
                }

                hideProgressBar();
                List<Result> gamesList = response.body().getResults();
                GameRecyclerAdapter gameRecyclerAdapter = new GameRecyclerAdapter(getApplicationContext(), gamesList, new GameRecyclerAdapter.GameClickListener() {
                    @Override
                    public void onItemClick(Result result) {
                        Intent intent = new Intent(getApplicationContext(),GameDetailActivity.class);
                        intent.putExtra("results", Parcels.wrap(gamesList));
                        startActivity(intent);
                    }
                });

                recyclerView = gameResultsBinding.gamesRecycler;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(gameRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<GamesResponse> call, Throwable t) {
            }

            private void hideProgressBar(){
                gameResultsBinding.gamesProgressBar.setVisibility(View.GONE);
                gameResultsBinding.gamesRecycler.setVisibility(View.VISIBLE);
            }

            private void showError(){
                gameResultsBinding.errorText.setVisibility(View.VISIBLE);
            }

        });
    }
}