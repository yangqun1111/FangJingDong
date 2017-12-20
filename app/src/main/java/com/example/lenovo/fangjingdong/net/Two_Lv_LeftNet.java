package com.example.lenovo.fangjingdong.net;

import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;

import retrofit2.http.GET;
import rx.Observable;

public interface Two_Lv_LeftNet {
    @GET("getCatagory")
    Observable<Two_Lv_LeftBean> getlv_Legft();
}
