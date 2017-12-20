package com.example.lenovo.fangjingdong.net;

import com.example.lenovo.fangjingdong.bean.Loginbean;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;


public interface LoginNet {
    @POST("login")
    @FormUrlEncoded
    Observable<Loginbean> getlogin(@FieldMap HashMap<String, Object> map);
    @Multipart
    @POST("file/upload")
    Call<Result<String>> loadTou(@Part List<MultipartBody.Part> partList);
}
