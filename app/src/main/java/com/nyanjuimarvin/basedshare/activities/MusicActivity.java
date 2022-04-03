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
import com.nyanjuimarvin.basedshare.databinding.ActivityMainBinding;
import com.nyanjuimarvin.basedshare.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {

    private ActivityMusicBinding musicBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicBinding = ActivityMusicBinding.inflate(getLayoutInflater());
        View view = musicBinding.getRoot();
        setContentView(view);

        //Bottom Navigation
        musicBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Game:
                        startActivity(new Intent(getApplicationContext(), GameActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.music:
                        return true;

                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(), FilmActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });
    }
}