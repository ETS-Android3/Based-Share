package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityFilmResultsBinding;
import com.nyanjuimarvin.basedshare.endpoints.FilmEndpoint;
import com.nyanjuimarvin.basedshare.models.film.FilmResponse;
import com.nyanjuimarvin.basedshare.retrofit.FilmClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmResultsActivity extends AppCompatActivity {

    private ActivityFilmResultsBinding filmResultsBinding;

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
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {

            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {

            }
        });
    }
}