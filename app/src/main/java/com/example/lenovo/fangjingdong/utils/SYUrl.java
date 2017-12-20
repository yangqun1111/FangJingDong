package com.example.lenovo.fangjingdong.utils;


import com.example.lenovo.fangjingdong.bean.Sy_bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by len on 2017/12/9.
 */

public interface SYUrl {
    //首页
    @GET("v5/newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255")
    Observable<Sy_bean> getSy();
}
