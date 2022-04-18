package com.nyanjuimarvin.basedshare.activities;

import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_FILM_NODE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FirebaseFilmsAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivitySavedFilmBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;
import com.nyanjuimarvin.basedshare.firebase.database.Database;
import com.nyanjuimarvin.basedshare.models.film.Result;

import java.util.ArrayList;
import java.util.List;

public class SavedFilmActivity extends AppCompatActivity {

    private ActivitySavedFilmBinding savedFilmBinding;
    private FirebaseFilmsAdapter adapter;
    private FirebaseUser user;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedFilmBinding = ActivitySavedFilmBinding.inflate(getLayoutInflater());
        View view = savedFilmBinding.getRoot();
        setContentView(view);

        List<Result> results = new ArrayList<>();
        user = Authentication.getAuth().getCurrentUser();
        dbRef = Database.getDatabase().getReference(FIREBASE_FILM_NODE).child(user.getUid());

        adapter = new FirebaseFilmsAdapter(results, getApplicationContext(), (result, position) -> {
            Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
        });

        savedFilmBinding.savedFilmRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
        savedFilmBinding.savedFilmRecycler.setAdapter(adapter);

        dbRef.addValueEventListener(new ValueEventListener(){

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot filmSnapshot : snapshot.getChildren()){
                    Result result = filmSnapshot.getValue(Result.class);
                    results.add(result);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}