package com.example.aventu.cuentosapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.aventu.cuentosapp.R;

/**
 * Created by Santiago on 10/25/17.
 */

public class SplashActivity extends AppCompatActivity {

    private LinearLayout lySplash;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        lySplash = (LinearLayout) findViewById(R.id.lySplash);
        lySplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, StoryListActivity.class));
            }
        });
    }
}
