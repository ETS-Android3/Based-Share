package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameResultsBinding;

public class GameResultsActivity extends AppCompatActivity {

    private ActivityGameResultsBinding gameResultsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameResultsBinding = ActivityGameResultsBinding.inflate(getLayoutInflater());
        View view = gameResultsBinding.getRoot();
        setContentView(view);
    }
}