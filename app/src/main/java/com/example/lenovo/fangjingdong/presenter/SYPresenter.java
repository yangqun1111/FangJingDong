package com.example.lenovo.fangjingdong.presenter;

import android.util.Log;

import com.example.lenovo.fangjingdong.bean.Sy_bean;
import com.example.lenovo.fangjingdong.model.SYDataModel;
import com.example.lenovo.fangjingdong.view.ISYDataView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by len on 2017/12/9.
 */
//首页
public class SYPresenter {
    SYDataModel model;
    ISYDataView view;
    List<Sy_bean.GoodsListBean> sylist=new ArrayList<>();

    public SYPresenter(ISYDataView view) {
        this.view = view;
        model=new SYDataModel();
    }
    public void spData(){
        model.getSYData(new Observer<Sy_bean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.i("111111p","onError");
            }

            @Override
            public void onNext(Sy_bean sy_bean) {
                Log.d("TAG3", "onNext: "+sy_bean.getGoods_list());
                sylist.addAll(sy_bean.getGoods_list());
                view.showSYData(sylist);
            }
        });
    }
}
