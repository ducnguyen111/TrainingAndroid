package com.example.fragmentlifecycle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {
    public static final String TAG="Fragment1";
    Button button;
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(getContext(),R.raw.yeulaccuoi);
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }
}