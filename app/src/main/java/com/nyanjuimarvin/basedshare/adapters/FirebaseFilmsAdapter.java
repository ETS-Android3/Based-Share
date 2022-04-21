package com.nyanjuimarvin.basedshare.adapters;

import static com.nyanjuimarvin.basedshare.constants.Constants.IMAGE_BASE_URL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentMovieCardBinding;
import com.nyanjuimarvin.basedshare.models.film.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FirebaseFilmsAdapter extends RecyclerView.Adapter<FirebaseFilmsAdapter.FilmViewHolder>{

    private List<Result> films;
    private Context context;
    private FilmListener listener;
    private FragmentMovieCardBinding movieCardBinding;


    public interface FilmListener{
        void filmClick(Result result, int position);
    }

    public FirebaseFilmsAdapter(List<Result> films, Context context, FilmListener listener) {
        this.films = films;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FirebaseFilmsAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movie_card, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirebaseFilmsAdapter.FilmViewHolder holder, int position) {
        Result result = films.get(position);
        if( result.getMediaType().equals("movie") || result.getMediaType().equals("tv") ) {
            if(result.getPosterPath() == null){
                Picasso.get().load("https://m.media-amazon.com/images/I/71DFOv71rNL._AC_SL1000_.jpg").into(holder.filmImage);
            }else{
                Picasso.get().load(IMAGE_BASE_URL + result.getPosterPath()).into(holder.filmImage);
            }
            if( result.getOriginalTitle() != null ) {
                holder.filmTitle.setText(result.getOriginalTitle());
            }else{
                holder.filmTitle.setText(result.getName());
            }
            holder.filmType.setText(result.getMediaType());
            holder.filmRating.setText(String.valueOf(result.getVoteAverage()));
            holder.bindView(result, listener, position);
        }
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        private ImageView filmImage;
        private TextView filmTitle;
        private TextView filmType;
        private TextView filmRating;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            filmImage = itemView.findViewById(R.id.filmImage);
            filmTitle = itemView.findViewById(R.id.filmNameText);
            filmType = itemView.findViewById(R.id.filmTypeText);
            filmRating = itemView.findViewById(R.id.ratingText);
        }

        public void bindView(final Result result, final FilmListener listener, final int position){
            itemView.setOnClickListener(view -> listener.filmClick(result, position));
        }
    }

    public void removeItem(int position){
        films.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Result result, int position){
        films.add(position,result);
        notifyItemInserted(position);
    }
}
