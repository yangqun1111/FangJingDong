package com.example.lenovo.fangjingdong.net;

import com.example.lenovo.fangjingdong.bean.ShopBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/12/13.
 */

public interface GetRequest_In {
    @GET("searchProducts?page=1")
    Call<ShopBean> getCall(@Query("keywords") String name);
}
