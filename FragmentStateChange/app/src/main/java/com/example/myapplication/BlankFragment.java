package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {
public static final String TAG="Fragment";
public MediaPlayer player;
    public static Fragment Instance() {
        return new BlankFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView: ");
        player=new MediaPlayer();
        player=MediaPlayer.create(getContext(),R.raw.yeulaccuoi);
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        player.start();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player!=null){
            player.stop();
            player.release();
        }
        Log.i(TAG, "onDestroy: ");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", player.getCurrentPosition());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            player.seekTo(savedInstanceState.getInt("position"));
        }
    }
}