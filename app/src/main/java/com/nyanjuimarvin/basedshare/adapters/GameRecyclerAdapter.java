package com.nyanjuimarvin.basedshare.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentGameCardBinding;
import com.nyanjuimarvin.basedshare.models.game.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>{

    private Context context;
    private List<Result> gameResults;
    private GameClickListener listener;
    private FragmentGameCardBinding gameCardBinding;

    public interface GameClickListener{
        void onItemClick(Result result,int position);
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GameRecyclerAdapter.GameViewHolder holder, int position) {
        String placeholder = "Custom";
        Result result = gameResults.get(position);
        Picasso.get().load(result.getBackgroundImage()).into(holder.gameImage);
        holder.gameName.setText(result.getName());
        holder.gameRelease.setText(result.getReleased());
        holder.metacritic.setText(String.format("%s",result.getMetacritic()));
//        holder.gameRating.setText(String.format("%s / %s",Double.toString(result.getRating()),Double.toString(result.getRatingTop())));
        holder.bindView(result,listener,position);

    }

    @Override
    public int getItemCount() {
        return gameResults.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        private ImageView gameImage;
        private TextView gameName;
        private TextView gameRelease;
        private TextView gameRating;
        private TextView metacritic;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.gameImage);
            gameName = itemView.findViewById(R.id.gameNameText);
            gameRelease = itemView.findViewById(R.id.firstReleaseDateText);
            gameRating = itemView.findViewById(R.id.gameRatingText);
            metacritic = itemView.findViewById(R.id.metacriticText);
        }

        public void bindView(final Result result,final GameClickListener listener, final int position){
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(result,position);
                }
            });
        }
    }
}
