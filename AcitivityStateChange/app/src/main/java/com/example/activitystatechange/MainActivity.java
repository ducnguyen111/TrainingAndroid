package com.example.activitystatechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ACTIVITY";
    public MediaPlayer player;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = new MediaPlayer();
        player = MediaPlayer.create(this, R.raw.yeulaccuoi);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
        outState.putInt("nhac", player.getCurrentPosition());
        Log.e(TAG, "" + player.getCurrentPosition());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");


    }

    @Override
    protected void onStart() {
        super.onStart();
        player.start();
        Log.e(TAG, "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}