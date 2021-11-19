package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public static final String b = "ActivityA";
    public Intent intent;
    public MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(b, "onCreate");
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnA);
        onclick();
        mediaPlayer = MediaPlayer.create(this, R.raw.thaylong);

    }

    public void playSong() {
        // MediaPlayer.create(MainActivity.this,R.raw.thaylong).start();
//        mediaPlayer = new MediaPlayer();
        mediaPlayer.start();

    }

    private void onclick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        playSong();
        Log.e(b, "Onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(b, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(b, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.pause();
        Log.e(b, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        Log.e(b, "onDestroy");
    }
}