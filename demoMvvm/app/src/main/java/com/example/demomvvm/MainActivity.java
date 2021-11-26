package com.example.demomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.demomvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
       LoginViewModel loginViewModel=new LoginViewModel();
       activityMainBinding.setLoginViewModel(loginViewModel);




    }
}