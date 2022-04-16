package com.nyanjuimarvin.basedshare.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentGameDetailBinding;
import com.nyanjuimarvin.basedshare.models.game.Game;
import com.nyanjuimarvin.basedshare.models.game.Genre;
import com.nyanjuimarvin.basedshare.models.game.Store;
import com.nyanjuimarvin.basedshare.models.game.Store__1;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Game mGame;
    private FragmentGameDetailBinding gameDetailBinding;

    public GameDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GameDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameDetailFragment newInstance(Game game) {
        GameDetailFragment fragment = new GameDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("game", Parcels.wrap(game));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        assert bundle != null;
        mGame = Parcels.unwrap(getArguments().getParcelable("game"));

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        gameDetailBinding = FragmentGameDetailBinding.inflate(inflater,container,false);
        return gameDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> stores = new ArrayList<>();
        List<String> genres = new ArrayList<>();

        Log.d("stores",String.valueOf(mGame.getGenres().size()));
        for(Store store : mGame.getStores()){
            stores.add(store.getStore().getName());
        }

        for (Genre genre : mGame.getGenres()){
            genres.add(genre.getName());
        }

        Log.d("image",mGame.getImageUrl());
        Log.d("name",mGame.getName());
        Log.d("rating",mGame.getMetacritic());
        Log.d("genres",genres.toString());
        Picasso.get().load(mGame.getImageUrl()).into(gameDetailBinding.gameDetailImage);
        gameDetailBinding.gameNameDetail.setText(mGame.getName());
        gameDetailBinding.ratingDetail.setText(String.valueOf(mGame.getMetacritic()));
        gameDetailBinding.genreDetail.setText(genres.toString());
        gameDetailBinding.storeDetail.setText(stores.toString());
    }
}