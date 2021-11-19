package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Student> list;
    Adapterr adapterr;
    Button btt1,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list1);
        btt1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        list = new ArrayList<>();

        adapterr=new Adapterr(MainActivity.this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            }
        });
        adapterr.setList(getListlist());
        recyclerView.setAdapter(adapterr);


    }
    public List<Student> getListlist(){
        List<Student> list=new ArrayList<>();
        list.add(new Student("Nguyen van A","18","Ha Noi"));
        list.add(new Student("Nguyen van Ab","18","Ha Noi"));
        list.add(new Student("Nguyen van Ac","18","Ha Noi"));
        list.add(new Student("Nguyen van Ad","18","Ha Noi"));
        list.add(new Student("Nguyen van Adc","18","Ha Noi"));
        return  list;
    }
}