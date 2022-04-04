package com.nyanjuimarvin.basedshare.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>{

    @NonNull
    @Override
    public GameRecyclerAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GameRecyclerAdapter.GameViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
