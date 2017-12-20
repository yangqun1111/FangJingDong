package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.utils.PJUrl;
import com.example.lenovo.fangjingdong.utils.RetrofitManager;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨群 on 2017/12/18.
 */

public class PJDataModel implements IPJDataModel {
    @Override
    public void getPJData(String id, Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getinstantce("http://apiv4.yangkeduo.com/",client)
                .setcreate(PJUrl.class)
                .getPj(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);

    }
}
