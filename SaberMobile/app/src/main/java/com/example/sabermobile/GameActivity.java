package com.example.sabermobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(this, Song1.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Song2.class);
            startActivity(intent);
        });
        button3.setOnClickListener(viev -> {
            Intent intent = new Intent(this, Song3.class);
            startActivity(intent);
        });
    }
}
