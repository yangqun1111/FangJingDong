package com.example.lenovo.fangjingdong.model;
import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.OneAPI;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;


public class OneModel implements IOneModel {

    @Override
    public OneAPI setOneData() {
        OkHttpClient client=new OkHttpClient.Builder().build();
        OneAPI setcreate = RetrofitManager.getinstantce(Base.BASETWO_ONERL, client).setcreate(OneAPI.class);
        return setcreate;
    }

    @Override
    public OneAPI setOnevpData() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        OneAPI setcreate = RetrofitManager.getinstantce(Base.BASETWO_LV_LEFTURL, client).setcreate(OneAPI.class);
        return setcreate;
    }



}
