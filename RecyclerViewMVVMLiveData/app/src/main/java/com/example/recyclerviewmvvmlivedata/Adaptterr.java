package com.example.recyclerviewmvvmlivedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptterr extends ListAdapter<User, Adaptterr.ViewHolder> {
  private MoiveClickInterface moiveClickInterface;

    protected Adaptterr(@NonNull DiffUtil.ItemCallback<User> diffCallback,MoiveClickInterface moiveClickInterface) {
        super(diffCallback);
         this.moiveClickInterface=moiveClickInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = getItem(position);
        holder.bind(user);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten, diachi, tuoi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.item_ten);
            diachi = itemView.findViewById(R.id.item_diachi);
            tuoi = itemView.findViewById(R.id.item_tuoi);
        }

        public void bind(User user) {
            ten.setText(user.getTen());
            diachi.setText(user.getDiachi());
            tuoi.setText(user.getTuoi()+"");
        }
    }
    interface MoiveClickInterface{
        public void ondelete(int position);
    }
}
