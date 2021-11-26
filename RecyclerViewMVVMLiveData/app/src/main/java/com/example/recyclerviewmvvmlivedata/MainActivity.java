package com.example.recyclerviewmvvmlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.DatabaseUtils;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewmvvmlivedata.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Adaptterr.MoiveClickInterface {
    private UserViewMolder molder;
    private Adaptterr adaptterr;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.listItem.setLayoutManager(new LinearLayoutManager(this));
        adaptterr=new Adaptterr(User.itemCallback,this);
        molder = new ViewModelProvider(this).get(UserViewMolder.class);
        molder.getLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> list) {
                adaptterr.submitList(list);
                activityMainBinding.listItem.setAdapter( adaptterr);
            }
        });
        activityMainBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }
    private void click() {
        User user=new User("dd","ss",10);
        molder.addUser(user);
    }

    @Override
    public void ondelete(int position) {

    }
}