package com.nyanjuimarvin.basedshare.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GameDetailFragment;

public class FilmDetailAdapter extends FragmentStateAdapter {
    public FilmDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new GameDetailFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
