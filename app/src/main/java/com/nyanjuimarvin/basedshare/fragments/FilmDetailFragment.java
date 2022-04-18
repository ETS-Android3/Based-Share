package com.nyanjuimarvin.basedshare.fragments;

import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_FILM_NODE;
import static com.nyanjuimarvin.basedshare.constants.Constants.IMAGE_BASE_URL;

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
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.FragmentFilmDetailBinding;
import com.nyanjuimarvin.basedshare.databinding.FragmentGameDetailBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;
import com.nyanjuimarvin.basedshare.firebase.database.Database;
import com.nyanjuimarvin.basedshare.models.film.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Result mResult;
    private FragmentFilmDetailBinding filmDetailBinding;
    private FirebaseUser user;
    private FirebaseDatabase firebaseDb;
    private DatabaseReference dbRef;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment FilmDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmDetailFragment newInstance(Result result) {
        FilmDetailFragment fragment = new FilmDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("film", Parcels.wrap(result));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Bundle bundle = getArguments();
       assert getArguments() != null;
       mResult = Parcels.unwrap(getArguments().getParcelable("film"));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        filmDetailBinding =  FragmentFilmDetailBinding.inflate(inflater,container,false);
        return filmDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.get().load(IMAGE_BASE_URL + mResult.getPosterPath()).into(filmDetailBinding.imageView5);
        if(mResult.getOriginalTitle() != null){
            filmDetailBinding.filmNameDetail.setText(mResult.getOriginalTitle());
        }else{
            filmDetailBinding.filmNameDetail.setText(mResult.getOriginalName());
        }
        filmDetailBinding.overviewDetail.setText(mResult.getOverview());
        filmDetailBinding.voteDetail.setText(String.valueOf(mResult.getVoteAverage()));

        filmDetailBinding.saveFilmBtn.setOnClickListener(view1 -> {
            user = Authentication.getAuth().getCurrentUser();
            firebaseDb = Database.getDatabase();

            String userId = user.getUid();
            //New Database node for film and child node for userId
            dbRef = firebaseDb.getReference(FIREBASE_FILM_NODE).child(userId);
            //Reference for each film object
            DatabaseReference pushRef = dbRef.push();

            //Get Push Key
            String pushId = pushRef.getKey();
            mResult.setPushId(pushId);

            pushRef.setValue(mResult).addOnFailureListener(e -> {
                Log.d("save Failed",e.getLocalizedMessage());
            });
        });
    }
}