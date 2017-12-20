package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.LoginNet;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;
public class LoginModel implements ILoginModel {
    @Override
    public LoginNet setloginData() {
        OkHttpClient client=new OkHttpClient.Builder().build();
        LoginNet setcreate = RetrofitManager.getinstantce(Base.BASELOGINANDREGURL, client).setcreate(LoginNet.class);

        return setcreate;
    }

    @Override
    public LoginNet setloginTouData() {
        OkHttpClient client=new OkHttpClient.Builder().build();
        LoginNet setcreate = RetrofitManager.getinstantce(Base.BASETOUURL, client).setcreate(LoginNet.class);

        return setcreate;
    }

}
