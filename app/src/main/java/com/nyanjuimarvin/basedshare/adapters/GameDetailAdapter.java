package com.nyanjuimarvin.basedshare.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GameDetailFragment;
import com.nyanjuimarvin.basedshare.models.game.Game;
import com.nyanjuimarvin.basedshare.models.game.Result;

import java.util.ArrayList;
import java.util.List;

public class GameDetailAdapter extends FragmentStateAdapter {
    private final List<Result> gameResults;
    public GameDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Result> results) {
        super(fragmentManager, lifecycle);
        this.gameResults = results;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d("pos",String.valueOf(position));
//        Result result = gameResults.get(position);
        List<Game> games = new ArrayList<>();
        for(Result result:gameResults) {
            games.add(new Game(result.getName(), result.getParentPlatforms(), result.getStores(), result.getBackgroundImage(), result.getGenres(), result.getReleased(), String.valueOf(result.getMetacritic())));
        }
        Log.d("games",String.valueOf(games.size()));
        return GameDetailFragment.newInstance(games.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("size",String.valueOf(gameResults.size()));
        return gameResults.size();
    }

}
