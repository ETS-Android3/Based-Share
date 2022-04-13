package com.nyanjuimarvin.basedshare.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GameDetailFragment;
import com.nyanjuimarvin.basedshare.models.game.Game;
import com.nyanjuimarvin.basedshare.models.game.Result;

import java.util.List;

public class GameDetailAdapter extends FragmentStateAdapter {
    private List<Result> gameResults;
    public GameDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Result> results) {
        super(fragmentManager, lifecycle);
        this.gameResults = results;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Result result = gameResults.get(position);
        Game game = new Game(result.getName(),result.getParentPlatforms(),result.getStores(),result.getBackgroundImage(),result.getGenres(),result.getReleased(),result.getMetacritic());
        return GameDetailFragment.newInstance(game);
    }

    @Override
    public int getItemCount() {
        return gameResults.size();
    }

}
