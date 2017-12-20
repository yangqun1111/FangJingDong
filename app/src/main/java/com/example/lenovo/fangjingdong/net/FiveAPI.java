package com.example.lenovo.fangjingdong.net;


import com.example.lenovo.fangjingdong.bean.Five_toubean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface FiveAPI {
    @GET("user/getUserInfo?")
    Observable<Five_toubean> getFiveimg(@Query("uid") int uid);
}
