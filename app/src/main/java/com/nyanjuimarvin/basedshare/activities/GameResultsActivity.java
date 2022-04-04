package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameResultsBinding;
import com.nyanjuimarvin.basedshare.endpoints.GameEndpoint;
import com.nyanjuimarvin.basedshare.models.game.GamesResponse;
import com.nyanjuimarvin.basedshare.retrofit.GameClient;

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

        //Retrofit Api call
        GameEndpoint gameEndpoint = GameClient.getGameClient();
        Intent intent = getIntent();
        String search = intent.getStringExtra("term");
        Call<GamesResponse> call = gameEndpoint.getGames(search);

        call.enqueue(new Callback<GamesResponse>(){

            @Override
            public void onResponse(Call<GamesResponse> call, Response<GamesResponse> response) {

            }

            @Override
            public void onFailure(Call<GamesResponse> call, Throwable t) {

            }
        });
    }
}