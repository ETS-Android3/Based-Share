package com.nyanjuimarvin.basedshare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentMovieCardBinding;
import com.nyanjuimarvin.basedshare.models.film.Result;

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

    }

    @Override
    public int getItemCount() {
        return filmResults.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
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
