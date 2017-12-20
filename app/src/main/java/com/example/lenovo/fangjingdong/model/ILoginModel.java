package com.example.lenovo.fangjingdong.model;


import com.example.lenovo.fangjingdong.net.LoginNet;

public interface ILoginModel {
//    public void setloginData(String name, String pass, OkUiCallback okUiCallback);
    public LoginNet setloginData();
    public LoginNet setloginTouData();
}
