package com.example.lenovo.fangjingdong.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 杨群 on 2017/12/19.
 */

public class HttpUtils {
    private static volatile HttpUtils httpUtils;
    private final OkHttpClient client;
    private HttpUtils(){
        client=new OkHttpClient.Builder().build();
    }
    public static HttpUtils getHttpUtils(){
        if(httpUtils == null){
            synchronized (HttpUtils.class){
                if(httpUtils == null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    public void doGet(String url, Callback callback){
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
