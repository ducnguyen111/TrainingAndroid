package com.example.recyclerviewmvvmlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewMolder extends ViewModel {
    private List<User> list;
    private MutableLiveData<List<User>> liveData;


    public UserViewMolder() {
        liveData =new MutableLiveData<>();
        initData();
    }
    private void initData() {
        list=new ArrayList<>();
        list.add(new User("duc","ha noi",20));
        list.add(new User("duc","ha noi",20));
        list.add(new User("duc","ha noi",20));
        list.add(new User("duc","ha noi",20));
        list.add(new User("duc","ha noi",20));
        list.add(new User("duc","ha noi",20));
        liveData.setValue(list);
    }

    public MutableLiveData<List<User>> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<List<User>> liveData ){
        this.liveData = liveData;

    }
    public void addUser(User user){
       list.add(user);
       liveData.setValue(list);
    }
}
