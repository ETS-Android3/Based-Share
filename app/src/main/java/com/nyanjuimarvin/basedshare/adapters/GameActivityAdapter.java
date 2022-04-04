package com.nyanjuimarvin.basedshare.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nyanjuimarvin.basedshare.fragments.GetGameFragment;

public class GameActivityAdapter extends FragmentStateAdapter {
    public GameActivityAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    //Adding post fragment later
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new GetGameFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
