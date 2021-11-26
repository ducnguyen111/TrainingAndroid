package com.example.mvvm1;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModelRecyler extends ViewModel {
    private MutableLiveData<List<User>> liveData;
    private List<User> list;

    public ViewModelRecyler() {
        liveData=new MutableLiveData<>();
        data();
    }

    private void data() {
        list=new ArrayList<>();
        list.add(new User("duc","tuoi"));
        list.add(new User("duc1","hanoi"));
        list.add(new User("duc2","ha noi1"));
        liveData.setValue(list);

    }

    public MutableLiveData<List<User>> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<List<User>> liveData) {
        this.liveData = liveData;
    }
    public void addUser(User user){
        list.add(user);
        liveData.setValue(list);
    }
}
