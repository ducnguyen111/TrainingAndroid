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

public class MainActivity2 extends AppCompatActivity {
    public Button button;
    public static final String b = "ActivityB";
    public Intent intent;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(b, "Oncreate");
        button = findViewById(R.id.btnB);
        onclick();
    }
    private void onclick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
    public void playsong() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer=MediaPlayer.create(this,R.raw.yeulaccuoi);
        mediaPlayer.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
        playsong();
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
//        mediaPlayer.pause();
        Log.e(b, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        Log.e(b,"onDestroy" );
    }
}