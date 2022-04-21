package com.nyanjuimarvin.basedshare.activities;

import static android.view.View.GONE;
import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_FILM_NODE;
import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_INDEX;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FirebaseFilmsAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivitySavedFilmBinding;
import com.nyanjuimarvin.basedshare.databinding.FragmentFilmDetailBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;
import com.nyanjuimarvin.basedshare.firebase.database.Database;
import com.nyanjuimarvin.basedshare.gestures.ItemTouchCallback;
import com.nyanjuimarvin.basedshare.gestures.ItemTouchHelperCallback;
import com.nyanjuimarvin.basedshare.models.film.Result;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class SavedFilmActivity extends AppCompatActivity implements ItemTouchCallback {

    private ActivitySavedFilmBinding savedFilmBinding;
    private FirebaseFilmsAdapter adapter;
    private FirebaseUser user;
    private DatabaseReference dbRef;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedFilmBinding = ActivitySavedFilmBinding.inflate(getLayoutInflater());
        View view = savedFilmBinding.getRoot();
        setContentView(view);

        results = new ArrayList<>();
        user = Authentication.getAuth().getCurrentUser();
        dbRef = Database.getDatabase().getReference(FIREBASE_FILM_NODE).child(user.getUid());

        adapter = new FirebaseFilmsAdapter(results, getApplicationContext(), (result, position) -> {
            FragmentFilmDetailBinding filmDetailBinding = FragmentFilmDetailBinding.inflate(getLayoutInflater());
            filmDetailBinding.saveFilmBtn.setVisibility(GONE);
            Intent intent = new Intent(getApplicationContext(),FilmDetailActivity.class);
            intent.putExtra("position",position);
            intent.putExtra("films", Parcels.wrap(results));
            startActivity(intent);
        });

        savedFilmBinding.savedFilmRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
        savedFilmBinding.savedFilmRecycler.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(this);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(savedFilmBinding.savedFilmRecycler);

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

    @Override
    public void onMoveItem(int oldPosition, int newPosition) {
        results.add(newPosition,results.remove(oldPosition));
        adapter.notifyItemMoved(oldPosition,newPosition);
    }

    @Override
    public void onItemSwipe(RecyclerView.ViewHolder viewHolder, int position) {
        adapter.removeItem(viewHolder.getAdapterPosition());
        FirebaseUser newUser = Authentication.getAuth().getCurrentUser();

        assert newUser != null;
        String userId = newUser.getUid();

        DatabaseReference ref = Database.getDatabase().getReference(FIREBASE_FILM_NODE).child(userId);

        ref.addChildEventListener(new ChildEventListener(){

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}