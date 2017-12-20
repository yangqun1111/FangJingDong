package com.example.lenovo.fangjingdong.model;

import rx.Observer;

/**
 * Created by 杨群 on 2017/12/18.
 */

public interface IBNDataModel {
    //详情页
    public void getBNData(String good_id, Observer observer);

}
