package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.RegNet;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;


public class RegModel implements IRegModel {
    @Override
    public RegNet setRegData() {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RegNet setcreate = RetrofitManager.getinstantce(Base.BASELOGINANDREGURL, client).setcreate(RegNet.class);
        return setcreate;
    }
}
