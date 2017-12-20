package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.utils.RetrofitManager;
import com.example.lenovo.fangjingdong.utils.SYUrl;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨群 on 2017/12/18.
 */

public class SYDataModel implements ISYDataModel {
    @Override
    public void getSYData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getinstantce("http://apiv3.yangkeduo.com/",client)
                .setcreate(SYUrl.class).getSy()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);

    }
}
