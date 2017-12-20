package com.example.lenovo.fangjingdong.net;
import com.example.lenovo.fangjingdong.bean.Regbean;

import java.util.HashMap;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RegNet {
    @POST("reg")
    @FormUrlEncoded
    Observable<Regbean> getreg(@FieldMap HashMap<String, Object> map);
}
