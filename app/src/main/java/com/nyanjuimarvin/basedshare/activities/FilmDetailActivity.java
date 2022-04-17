package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FilmDetailAdapter;
import com.nyanjuimarvin.basedshare.adapters.GameDetailAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityFilmDetailBinding;
import com.nyanjuimarvin.basedshare.models.film.Result;

import org.parceler.Parcels;

import java.util.List;

public class FilmDetailActivity extends AppCompatActivity {

    private ActivityFilmDetailBinding filmDetailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmDetailBinding = ActivityFilmDetailBinding.inflate(getLayoutInflater());
        View view = filmDetailBinding.getRoot();
        setContentView(view);
        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Result> filmResults = Parcels.unwrap(getIntent().getParcelableExtra("films"));
        FilmDetailAdapter adapter = new FilmDetailAdapter(fragmentManager,getLifecycle(),filmResults);
        filmDetailBinding.filmDetailViewPager.setAdapter(adapter);
        filmDetailBinding.filmDetailViewPager.setCurrentItem(getIntent().getIntExtra("position",0));
    }
}