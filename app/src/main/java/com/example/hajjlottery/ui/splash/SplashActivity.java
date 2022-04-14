package com.example.hajjlottery.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hajjlottery.R;
import com.example.hajjlottery.ui.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        logo.startAnimation(animation);

        TextView slogan = findViewById(R.id.slogan);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
        slogan.startAnimation(anim);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}