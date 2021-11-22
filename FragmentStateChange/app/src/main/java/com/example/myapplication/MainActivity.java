package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedInstanceState == null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.container,BlankFragment.Instance())
                            .commit();
                }
            }
        });

    }
}