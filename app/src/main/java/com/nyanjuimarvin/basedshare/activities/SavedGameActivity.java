package com.nyanjuimarvin.basedshare.activities;

import static com.nyanjuimarvin.basedshare.constants.Constants.FIREBASE_GAME_NODE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.nyanjuimarvin.basedshare.adapters.FirebaseGamesAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivitySavedGameBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;
import com.nyanjuimarvin.basedshare.firebase.database.Database;
import com.nyanjuimarvin.basedshare.gestures.ItemTouchCallback;
import com.nyanjuimarvin.basedshare.gestures.ItemTouchHelperCallback;
import com.nyanjuimarvin.basedshare.models.game.Result;

import java.util.ArrayList;
import java.util.List;

public class SavedGameActivity extends AppCompatActivity implements ItemTouchCallback {

    private ActivitySavedGameBinding savedGameBinding;
    private FirebaseGamesAdapter gameAdapter;
    private DatabaseReference dbRef;
    private FirebaseUser user;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedGameBinding = ActivitySavedGameBinding.inflate(getLayoutInflater());
        View view = savedGameBinding.getRoot();
        setContentView(view);

         results = new ArrayList<>();
        user = Authentication.getAuth().getCurrentUser();
        dbRef = Database.getDatabase().getReference(FIREBASE_GAME_NODE).child(user.getUid());

        gameAdapter = new FirebaseGamesAdapter(results, getApplicationContext(), (result, position) -> Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show());

        savedGameBinding.savedGameRecycler.setHasFixedSize(true);
        savedGameBinding.savedGameRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        savedGameBinding.savedGameRecycler.setAdapter(gameAdapter);


        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(this);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(savedGameBinding.savedGameRecycler);

        dbRef.addValueEventListener(new ValueEventListener(){

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //getChildren is an iterable
                for(DataSnapshot gameSnapshot :snapshot.getChildren()){
                    Result result = gameSnapshot.getValue(Result.class);
                    results.add(result);

                    Log.d("saved Games", String.valueOf(results.size()));
                }

                gameAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onMoveItem(int oldPosition, int newPosition) {
        results.add(newPosition, results.remove(oldPosition));
        gameAdapter.notifyItemMoved(oldPosition,newPosition);
    }

    @Override
    public void onItemSwipe(RecyclerView.ViewHolder viewHolder, int position) {
        gameAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}