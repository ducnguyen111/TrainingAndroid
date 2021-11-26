package com.example.demokotlin

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.databinding.ItemBinding


class Adapter(val list: List<User>) : RecyclerView.Adapter<Adapter.ViewHolde1r>() {
    class ViewHolde1r(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindingData(user: User) {
            binding.itemTen.text = "ten" + user.hoten
            binding.itemTuoi.text = "tuoi" + user.tuoi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolde1r {
        return ViewHolde1r(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolde1r, position: Int) {
        val user: User = list[position];
        holder.bindingData(user)
    }

    override fun getItemCount() = list.size

}