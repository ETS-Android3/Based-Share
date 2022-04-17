package com.nyanjuimarvin.basedshare.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.FilmDetailFragment;
import com.nyanjuimarvin.basedshare.models.film.Result;

import java.util.List;

public class FilmDetailAdapter extends FragmentStateAdapter {

    private List<Result> results;
    public FilmDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Result> results) {
        super(fragmentManager, lifecycle);
        this.results = results;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FilmDetailFragment.newInstance(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
