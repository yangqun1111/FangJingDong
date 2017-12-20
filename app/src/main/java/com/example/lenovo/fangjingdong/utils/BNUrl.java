package com.example.lenovo.fangjingdong.utils;


import com.example.lenovo.fangjingdong.bean.Bn_Bean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by len on 2017/12/9.
 */

public interface BNUrl {
    //详情页
    @GET("v5/goods/{goods_id}?pdduid=3470667255")
    Observable<Bn_Bean> getPj(@Path("goods_id") String goods_id);
}
