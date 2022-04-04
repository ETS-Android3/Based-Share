package com.nyanjuimarvin.basedshare.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentGameCardBinding;
import com.nyanjuimarvin.basedshare.models.game.Result;

import java.util.List;

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>{

    private Context context;
    private List<Result> gameResults;
    private GameClickListener listener;
    private FragmentGameCardBinding gameCardBinding;

    public interface GameClickListener{
        void onItemClick(Result result);
    }

    public GameRecyclerAdapter(Context context, List<Result> gameResults, GameClickListener listener) {
        this.context = context;
        this.gameResults = gameResults;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GameRecyclerAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_game_card,parent,false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameRecyclerAdapter.GameViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return gameResults.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindView(final Result result,final GameClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(result);
                }
            });
        }
    }
}
