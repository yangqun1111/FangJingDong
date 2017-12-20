package com.example.lenovo.fangjingdong.net;


import com.example.lenovo.fangjingdong.bean.Four_querycarbean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 郭金龙 on 2017/11/19.
 */

public interface FourAPI {
    @POST("product/addCart")
    @FormUrlEncoded
    Call<Object> getaddCart(@FieldMap HashMap<String, Object> map);
    @GET("product/getCarts?")
    Observable<Four_querycarbean> getqueryCarts(@Query("uid") int uid);
}
