package com.nyanjuimarvin.basedshare.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FilmActivityAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityFilmBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;

public class FilmActivity extends AppCompatActivity {

    private ActivityFilmBinding filmBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmBinding = ActivityFilmBinding.inflate(getLayoutInflater());
        FragmentManager fm = getSupportFragmentManager();
        FilmActivityAdapter filmActivityAdapter = new FilmActivityAdapter(fm,getLifecycle());
        filmBinding.filmViewPager.setAdapter(filmActivityAdapter);
        View view = filmBinding.getRoot();
        setContentView(view);

        filmBinding.bottomNavigation.setSelectedItemId(R.id.movie);
        filmBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(), MusicActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.movie:
                        return true;

                    case R.id.Game:
                        startActivity(new Intent(getApplicationContext(), GameActivity.class));
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

    //Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logoutOption){
            logOut();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut(){
        Authentication.getAuth().signOut();
        Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}