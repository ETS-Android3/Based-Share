package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nyanjuimarvin.basedshare.databinding.ActivityMainBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;


public class MainActivity extends AppCompatActivity {

     private ActivityMainBinding mainBinding;
    private FirebaseAuth.AuthStateListener listener;
    private FirebaseAuth newUserAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        mainBinding.detailViewButton.bringToFront();
        createAuthStateListener();
        mainBinding.detailViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Hey There",Toast.LENGTH_LONG).show();
                Log.d(MainActivity.class.getSimpleName(),"Button Clicked");
            }
        });
    }

    private void createAuthStateListener() {
        listener = firebaseAuth -> {
            final FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        newUserAuth = Authentication.getAuth();
        newUserAuth.addAuthStateListener(listener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (listener != null) {
            newUserAuth = Authentication.getAuth();
            newUserAuth.removeAuthStateListener(listener);
        }
    }
}