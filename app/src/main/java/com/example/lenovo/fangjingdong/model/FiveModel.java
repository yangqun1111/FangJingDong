package com.example.lenovo.fangjingdong.model;


import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.FiveAPI;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;



public class FiveModel implements IFiveModel {
    @Override
    public FiveAPI setFivetoudata() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        FiveAPI setcreate = RetrofitManager.getinstantce(Base.BASETOUURL, client).setcreate(FiveAPI.class);
        return setcreate;
    }
}
