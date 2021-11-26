package com.example.recyclerviewmvvmlivedata;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private String ten;
    private String diachi;
    private int tuoi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String ten, String diachi, int tuoi) {
        this.id = UUID.randomUUID().toString();
        this.ten = ten;
        this.diachi = diachi;
        this.tuoi = tuoi;
    }



    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return tuoi == user.tuoi && id.equals(user.id) && ten.equals(user.ten) && diachi.equals(user.diachi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, diachi, tuoi);
    }

    public static DiffUtil.ItemCallback<User> itemCallback=new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };
}
