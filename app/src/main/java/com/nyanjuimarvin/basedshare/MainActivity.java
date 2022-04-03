package com.nyanjuimarvin.basedshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.activities.DetailActivity;
import com.nyanjuimarvin.basedshare.databinding.ActivityMainBinding;
import com.nyanjuimarvin.basedshare.oauth.SpotifyOauth;


public class MainActivity extends AppCompatActivity {

     private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        mainBinding.detailViewButton.bringToFront();
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
}