package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.FourAPI;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;
import okhttp3.OkHttpClient;

public class FourModel implements IFourModel{

    @Override
    public FourAPI setquerycartsdata() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        FourAPI setcreate = RetrofitManager.getinstantce(Base.BASETOUURL, client).setcreate(FourAPI.class);
        return setcreate;
    }
}
