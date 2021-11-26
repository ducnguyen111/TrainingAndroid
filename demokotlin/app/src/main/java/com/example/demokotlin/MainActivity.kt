package com.example.demokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.demokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val list=listdata()
        binding.listItem.layoutManager=GridLayoutManager(this,2)
        binding.listItem.adapter = Adapter(list)

    }
    private fun listdata(): List<User> {
        val list = ArrayList<User>()
        list.add(User("duc1", "19"))
        list.add(User("duc2", "17"))
        list.add(User("duc3", "18"))
        list.add(User("duc4", "16"))
        list.add(User("duc5", "16"))
        list.add(User("duc6", "11"))
        list.add(User("duc7", "111"))
        list.add(User("duc8", "112"))
        return list
    }
}