package com.nyanjuimarvin.basedshare.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmRecyclerAdapter extends RecyclerView.Adapter<FilmRecyclerAdapter.FilmViewHolder>{
    @NonNull
    @Override
    public FilmRecyclerAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmRecyclerAdapter.FilmViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
