package com.nyanjuimarvin.basedshare.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.GameActivityAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding gameBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameBinding = ActivityGameBinding.inflate(getLayoutInflater());
        FragmentManager fm = getSupportFragmentManager();
        GameActivityAdapter gameActivityAdapter = new GameActivityAdapter(fm,getLifecycle());
        gameBinding.gameViewPager.setAdapter(gameActivityAdapter);
        View view = gameBinding.getRoot();
        setContentView(view);

        //Set Game view selected
        gameBinding.bottomNavigation.setSelectedItemId(R.id.Game);

        //Bottom Navigation
        gameBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(),FilmActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Game:
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

        if(id == R.id.deleteOption){
            deleteAccount();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut(){
        Authentication.getAuth().signOut();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void deleteAccount(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete().addOnCompleteListener( task -> {
            if(task.isSuccessful()){
                Log.d("deleted","Account deleted successfully");
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }else{
                Log.d("deleted", task.getException().getLocalizedMessage());
            }
        });

    }

}