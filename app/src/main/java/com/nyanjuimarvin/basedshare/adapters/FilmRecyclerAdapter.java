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

public class FilmRecyclerAdapter extends RecyclerView.Adapter<FilmRecyclerAdapter.FilmViewHolder>{

    private Context context;
    private List<Result> filmResults;
    private FilmOnClickListener listener;
    private FragmentMovieCardBinding movieCardBinding;


    public interface FilmOnClickListener{
        void onItemClick(Result result);
    }

    public FilmRecyclerAdapter(Context context, List<Result> filmResults, FilmOnClickListener listener) {
        this.context = context;
        this.filmResults = filmResults;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmRecyclerAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movie_card,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmRecyclerAdapter.FilmViewHolder holder, int position) {
        Result result = filmResults.get(position);
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
            holder.bindView(result, listener);
        }
    }

    @Override
    public int getItemCount() {
        return filmResults.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{

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

        //On item click
        public void bindView(final Result result,final FilmOnClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(result);
                }
            });
        }
    }
}
