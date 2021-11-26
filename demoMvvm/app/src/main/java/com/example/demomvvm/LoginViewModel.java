package com.example.demomvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String pass;
    public ObservableField<String> messager = new ObservableField<>();
    public ObservableField<Boolean> isShowMessger = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(BR.pass);
    }

    public void onclick() {
        User user = new User(getEmail(), getPass());
        isShowMessger.set(true);
        if (user.isVaidEmail() && user.isVaidPass()) {
            messager.set("Login success");
            isSuccess.set(true);
        } else {
            messager.set("Email Pass invail");
            isSuccess.set(false);
        }
    }
}
