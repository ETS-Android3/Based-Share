package com.nyanjuimarvin.basedshare.fragments;

import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_GAME_NODE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nyanjuimarvin.basedshare.databinding.FragmentGameDetailBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;
import com.nyanjuimarvin.basedshare.firebase.database.Database;
import com.nyanjuimarvin.basedshare.models.game.Genre;
import com.nyanjuimarvin.basedshare.models.game.Result;
import com.nyanjuimarvin.basedshare.models.game.Store;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;


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

    private Result mResult;
    private FragmentGameDetailBinding gameDetailBinding;
    private FirebaseDatabase firebaseDb;
    private DatabaseReference firebaseRef;
    private FirebaseUser user;

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
    public static GameDetailFragment newInstance(Result result) {
        GameDetailFragment fragment = new GameDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("game", Parcels.wrap(result));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        assert getArguments() != null;
        mResult = Parcels.unwrap(getArguments().getParcelable("game"));

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

        Log.d("stores",String.valueOf(mResult.getGenres().size()));
        for(Store store : mResult.getStores()){
            stores.add(store.getStore().getName());
        }

        for (Genre genre : mResult.getGenres()){
            genres.add(genre.getName());
        }

        Log.d("image",mResult.getBackgroundImage());
        Log.d("name",mResult.getName());
        Log.d("rating",mResult.getMetacritic().toString());
        Log.d("genres",genres.toString());
        Log.d("stores",stores.toString());
        Picasso.get().load(mResult.getBackgroundImage()).into(gameDetailBinding.gameDetailImage);
        gameDetailBinding.gameNameDetail.setText(mResult.getName());
        gameDetailBinding.ratingDetail.setText(String.valueOf(mResult.getMetacritic()));
        gameDetailBinding.genreDetail.setText(genres.toString());
        gameDetailBinding.storeDetail.setText(stores.toString());
        gameDetailBinding.saveGameBtn.setOnClickListener(view1 -> {
            user = Authentication.getAuth().getCurrentUser();
            assert user != null;
            String userId = user.getUid();
            firebaseDb = Database.getDatabase();
            firebaseRef = firebaseDb.getReference(FIREBASE_GAME_NODE).child(userId);
            DatabaseReference pushRef = firebaseRef.push();
            String pushId = pushRef.getKey();
            mResult.setPushId(pushId);
            pushRef.setValue(mResult).addOnFailureListener(e -> {
                Log.d("save failed",e.getLocalizedMessage());
            });
        });
    }
}