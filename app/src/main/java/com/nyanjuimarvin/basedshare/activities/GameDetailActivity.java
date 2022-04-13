package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.GameDetailAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityGameDetailBinding;
import com.nyanjuimarvin.basedshare.fragments.GameDetailFragment;
import com.nyanjuimarvin.basedshare.models.game.Game;
import com.nyanjuimarvin.basedshare.models.game.Result;

import org.parceler.Parcels;

import java.util.List;

public class GameDetailActivity extends AppCompatActivity {

    private ActivityGameDetailBinding gameDetailBinding;
    private Game mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameDetailBinding = ActivityGameDetailBinding.inflate(getLayoutInflater());
        View view = gameDetailBinding.getRoot();
        setContentView(view);

        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Result> results = Parcels.unwrap(getIntent().getParcelableExtra("results"));
        GameDetailAdapter adapter = new GameDetailAdapter(fragmentManager,getLifecycle(),results);
        gameDetailBinding.gameDetailViewPager.setAdapter(adapter);
    }
}