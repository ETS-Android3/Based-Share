package com.nyanjuimarvin.basedshare.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.activities.GameResultsActivity;
import com.nyanjuimarvin.basedshare.activities.SavedGameActivity;
import com.nyanjuimarvin.basedshare.databinding.FragmentGetGameBinding;
import com.nyanjuimarvin.basedshare.endpoints.GameEndpoint;
import com.nyanjuimarvin.basedshare.models.game.GamesResponse;
import com.nyanjuimarvin.basedshare.retrofit.GameClient;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetGameFragment extends Fragment {

    private FragmentGetGameBinding getGameBinding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GetGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GetGameFragment newInstance(String param1, String param2) {
        GetGameFragment fragment = new GetGameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getGameBinding = FragmentGetGameBinding.inflate(getLayoutInflater());
        View view = getGameBinding.getRoot();

        getGameBinding.gamesButton.setOnClickListener(view12 -> {
            Intent intent = new Intent(getContext(), GameResultsActivity.class);
            startActivity(intent);
        });

        getGameBinding.savedGamesBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), SavedGameActivity.class);
            startActivity(intent);
        });
        return view;
    }
}