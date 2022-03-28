package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.adapters.FeedViewAdapter;
import com.nyanjuimarvin.basedshare.databinding.ActivityFeedBinding;
import com.nyanjuimarvin.basedshare.models.GeneralFeed;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;;
    private List<GeneralFeed> generalFeedsList;
    private ActivityFeedBinding feedBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feedBinding = ActivityFeedBinding.inflate(getLayoutInflater());
        View view = feedBinding.getRoot();
        setContentView(view);
        recyclerView = feedBinding.recyclerCards;

        generalFeedsList = new ArrayList<>();
        generalFeedsList.add(new GeneralFeed("Nvidia RTX 3090 prices just dipped","Games","HackerSlasher3"));
        generalFeedsList.add(new GeneralFeed("I have proof as to why Ryan Gosling is literally me","Kino","Nitwit5"));
        generalFeedsList.add(new GeneralFeed("Doom Eternal Quick switching on Console made simpler","Game","Makyr Khan"));
        generalFeedsList.add(new GeneralFeed("Discover the song around by Floral Shop","Music","anonmiusicus"));
        generalFeedsList.add(new GeneralFeed("It had me saying \"Let's see Paul Allen's Card\"","Kino","ALtUser9"));
        generalFeedsList.add(new GeneralFeed("Obi-Wan is literally the master of the low ground","Kino","maulDarth"));
        generalFeedsList.add(new GeneralFeed("Here's to you is the greatest score from Sacco and Vanzetti","Music","kingHubris"));
        generalFeedsList.add(new GeneralFeed("Play Metal Gear Solid V on your birthdate to get a pleasant surprise","Game","Volgin43"));
        generalFeedsList.add(new GeneralFeed("If you save Roggvir in Solitude, he still get's a heart attack..Lmaoo","Game","RestfulDraugr"));

        //Initialize Adapter
        FeedViewAdapter feedAdapter = new FeedViewAdapter(this,generalFeedsList,new FeedViewAdapter.CustomOnItemClickListener(){
            @Override
            public void onItemClick(GeneralFeed feed) {
                Toast.makeText(getApplicationContext(),feed.getCategory(), Toast.LENGTH_LONG).show();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(feedAdapter);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

    }
}