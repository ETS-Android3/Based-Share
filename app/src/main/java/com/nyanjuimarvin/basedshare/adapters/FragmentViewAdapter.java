package com.nyanjuimarvin.basedshare.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GameFragment;
import com.nyanjuimarvin.basedshare.fragments.MovieFragment;
import com.nyanjuimarvin.basedshare.fragments.MusicFragment;


public class FragmentViewAdapter extends FragmentStateAdapter {

    private final Fragment [] mFragments;

    public FragmentViewAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Fragment[] mFragments) {
        super(fragmentManager, lifecycle);
        this.mFragments = mFragments;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:
              return new GameFragment();
          case 1:
              return new MusicFragment();
          case 2:
              return new MovieFragment();
      }
      return new MusicFragment();
    }

    @Override
    public int getItemCount() {
        return mFragments.length;
    }
}
