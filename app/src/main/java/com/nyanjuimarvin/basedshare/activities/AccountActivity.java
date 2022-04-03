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
import com.nyanjuimarvin.basedshare.databinding.ActivityAccountBinding;

public class AccountActivity extends AppCompatActivity {

    private ActivityAccountBinding accountBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountBinding = ActivityAccountBinding.inflate(getLayoutInflater());
        View view = accountBinding.getRoot();
        setContentView(view);

        accountBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(),MusicActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.account:
                        return true;

                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(),FilmActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Game:
                        startActivity(new Intent(getApplicationContext(),GameActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}