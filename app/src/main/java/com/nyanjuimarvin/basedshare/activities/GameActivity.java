package com.nyanjuimarvin.basedshare.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameBinding;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding gameBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameBinding = ActivityGameBinding.inflate(getLayoutInflater());
        View view = gameBinding.getRoot();
        setContentView(view);

        //Set Game view selected
        gameBinding.bottomNavigation.setSelectedItemId(R.id.Game);

        gameBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Game:
                        return true;

                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(),FilmActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(),MusicActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}