package com.nyanjuimarvin.basedshare.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.MovieFragment;

public class FilmActivityAdapter extends FragmentStateAdapter {
    public FilmActivityAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    //Adding post later
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new MovieFragment();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
