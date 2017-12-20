package com.example.lenovo.fangjingdong.net;

import com.example.lenovo.fangjingdong.bean.OneBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Xiangbean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface OneAPI {
    @GET("getAd")
    Observable<OneBean> getoneapi();
    @GET("getCatagory")
    Observable<Two_Lv_LeftBean> getone_vp();
    @GET("getProductDetail?")
    Observable<Xiangbean> getone_xiang(@Query("pid") int pid);
}
