package com.example.mvvm1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class Adapterr extends ListAdapter<User,Adapterr.ViewHolder> {
    protected Adapterr(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public Adapterr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterr.ViewHolder holder, int position) {
        User user=getItem(position);
        holder.bind(user);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten,diachi,tuoi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten=itemView.findViewById(R.id.item_ten);
            diachi=itemView.findViewById(R.id.item_diachi);

        }
        public void bind(User user){
            ten.setText(user.getTen());
            diachi.setText(user.getDiachia());
        }
    }
}
