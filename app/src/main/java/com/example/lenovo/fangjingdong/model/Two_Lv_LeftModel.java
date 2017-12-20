package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.constant.Base;
import com.example.lenovo.fangjingdong.net.Two_Lv_LeftNet;
import com.example.lenovo.fangjingdong.net.Two_Lv_RightNet;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;

public class Two_Lv_LeftModel implements ITwo_Lv_LeftModel {
    @Override
    public Two_Lv_LeftNet setListleftData() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        Two_Lv_LeftNet setcreate = RetrofitManager.getinstantce(Base.BASETWO_LV_LEFTURL, client).setcreate(Two_Lv_LeftNet.class);
        return setcreate;
    }

    @Override
    public Two_Lv_RightNet setListrightData() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        Two_Lv_RightNet setcreate = RetrofitManager.getinstantce(Base.BASETWO_LV_LEFTURL, client).setcreate(Two_Lv_RightNet.class);
        return setcreate;
    }
}
