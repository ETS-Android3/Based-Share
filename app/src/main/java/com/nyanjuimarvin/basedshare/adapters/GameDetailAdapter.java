package com.nyanjuimarvin.basedshare.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GameDetailFragment;
import com.nyanjuimarvin.basedshare.models.game.Result;

import java.util.List;

public class GameDetailAdapter extends FragmentStateAdapter {
    private final List<Result> gameResults;
    public GameDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Result> gameResults) {
        super(fragmentManager, lifecycle);
        this.gameResults = gameResults;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return GameDetailFragment.newInstance(gameResults.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("size",String.valueOf(gameResults.size()));
        return gameResults.size();
    }

}
