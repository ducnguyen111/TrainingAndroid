package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHoler> {
    private Context context;
    private List<Student> list;

    public void setList(List<Student> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public Adapterr(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Student student = list.get(position);
        holder.ten.setText("Ten:"+student.getTen());
        holder.tuoi.setText("Tuoi:"+student.getTuoi());
        holder.diachi.setText("Diachi:"+student.getDiachi());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView ten, tuoi, diachi;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.item_ten);
            tuoi = itemView.findViewById(R.id.item_tuoi);
            diachi = itemView.findViewById(R.id.item_diachi);
        }
    }
}
