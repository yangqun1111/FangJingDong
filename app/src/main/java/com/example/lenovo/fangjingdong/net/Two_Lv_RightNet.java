package com.example.lenovo.fangjingdong.net;

import com.example.lenovo.fangjingdong.bean.Two_Lv_rightBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Two_Lv_RightNet {
    @GET("getProductCatagory?")
    Observable<Two_Lv_rightBean> getlv_Legft(@Query("cid") String cid);
}
