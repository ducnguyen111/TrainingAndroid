package com.example.mvvm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.mvvm1.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Adapterr adapterr;
    private ViewModelRecyler viewModelRecyler;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.listItem.setLayoutManager(new LinearLayoutManager(this));
        adapterr = new Adapterr(User.itemCallback);
        viewModelRecyler = new ViewModelProvider(this).get(ViewModelRecyler.class);
        viewModelRecyler.getLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapterr.submitList(users);
                binding.listItem.setAdapter(adapterr);
            }
        });
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = binding.edTen.getText().toString();
                String b = binding.edDiachi.getText().toString();
                User user = new User(a, b);
                viewModelRecyler.addUser(user);
                adapterr.notifyDataSetChanged();
                binding.edTen.setText("");
                binding.edDiachi.setText("");
            }
        });
    }
}