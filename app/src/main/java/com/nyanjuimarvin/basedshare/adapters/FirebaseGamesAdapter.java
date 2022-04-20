package com.nyanjuimarvin.basedshare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.models.game.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FirebaseGamesAdapter extends RecyclerView.Adapter<FirebaseGamesAdapter.GameViewHolder>{

    private List<Result> results;
    private Context context;
    private GameListener listener;

    public FirebaseGamesAdapter(List<Result> results, Context context, GameListener listener) {
        this.results = results;
        this.context = context;
        this.listener = listener;
    }

    public interface GameListener{
        void gameCLick(Result result, int position);
    }

    @NonNull
    @Override
    public FirebaseGamesAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_game_card, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirebaseGamesAdapter.GameViewHolder holder, int position) {
        String placeholder = "Custom";
        Result result = results.get(position);
        Picasso.get().load(result.getBackgroundImage()).into(holder.gameImage);
        holder.gameName.setText(result.getName());
        holder.gameRelease.setText(result.getReleased());
        holder.metacritic.setText(String.format("%s",result.getMetacritic()));
        holder.bindView(result,listener,position);
    }

    @Override
    public int getItemCount() {
        return results.size();
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

        public void bindView(final Result result, final GameListener listener, final int position){
            itemView.setOnClickListener(view -> listener.gameCLick(result,position));
        }
    }

    public void removeItem(int position){
        results.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Result result, int position){
        results.add(position,result);
        notifyItemInserted(position);
    }

}
