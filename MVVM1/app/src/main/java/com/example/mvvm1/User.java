package com.example.mvvm1;

import android.text.style.AlignmentSpan;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private String ten;
    private String diachia;


    public User(String ten, String diachia) {
        this.id= UUID.randomUUID().toString();
        this.ten = ten;
        this.diachia = diachia;

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", diachia='" + diachia + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachia() {
        return diachia;
    }

    public void setDiachia(String diachia) {
        this.diachia = diachia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && ten.equals(user.ten) && diachia.equals(user.diachia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, diachia);
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
