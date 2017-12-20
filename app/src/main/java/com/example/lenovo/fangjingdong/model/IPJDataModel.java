package com.example.lenovo.fangjingdong.model;

import rx.Observer;

/**
 * Created by 杨群 on 2017/12/18.
 */

public interface IPJDataModel {

    //评价
    public void getPJData(String id, Observer observer);
}
