package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding startBinding;
    private Animation imageAnimation;
    private Animation textAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = startBinding.getRoot();

        //Hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(view);

        //Load animation
        imageAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.imageanim);
        textAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textanim);

        startBinding.splashImage.setAnimation(imageAnimation);
        startBinding.splashText.setAnimation(textAnimation);

        //Move to next activity
        new Handler().postDelayed(() -> {
            Intent intent  = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        },6500);
    }
}