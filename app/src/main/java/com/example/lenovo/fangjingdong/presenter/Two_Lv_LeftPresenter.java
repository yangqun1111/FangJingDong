package com.example.lenovo.fangjingdong.presenter;

import android.util.Log;

import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_rightBean;
import com.example.lenovo.fangjingdong.model.ITwo_Lv_LeftModel;
import com.example.lenovo.fangjingdong.model.Two_Lv_LeftModel;
import com.example.lenovo.fangjingdong.net.Two_Lv_LeftNet;
import com.example.lenovo.fangjingdong.net.Two_Lv_RightNet;
import com.example.lenovo.fangjingdong.view.ITwo_Lv_LeftView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Two_Lv_LeftPresenter implements IPresenter<ITwo_Lv_LeftView> {
    List<Two_Lv_LeftBean.DataBean> list=new ArrayList<>();
    List<Two_Lv_rightBean.DataBean> list2=new ArrayList<>();
    SoftReference<ITwo_Lv_LeftView> reference;
    ITwo_Lv_LeftModel model;
    public Two_Lv_LeftPresenter(ITwo_Lv_LeftView view) {
        attch(view);
        model=new Two_Lv_LeftModel();
    }
    public void showLvLeft(){
        Two_Lv_LeftNet two_lv_leftNet = model.setListleftData();
        two_lv_leftNet.getlv_Legft().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Two_Lv_LeftBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                Log.i("----onError11-------", "onNext: "+throwable.getMessage());
            }

            @Override
            public void onNext(Two_Lv_LeftBean two_lv_leftBean) {
                for (int i = 0; i <two_lv_leftBean.getData().size() ; i++) {
                    list.add(two_lv_leftBean.getData().get(i));
                }
                    Log.i("----list111-------", "onNext: "+two_lv_leftBean);
                reference.get().getData(list);
            }
        });

    }

    public void showLvrigth(String id){
        Two_Lv_RightNet two_lv_rightNet = model.setListrightData();
        two_lv_rightNet.getlv_Legft(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Two_Lv_rightBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                Log.i("----onError222-------", "onNext: "+throwable.getMessage());
            }

            @Override
            public void onNext(Two_Lv_rightBean two_lv_rightBean) {
                for (int i = 0; i <two_lv_rightBean.getData().size() ; i++) {
                    list2.add(two_lv_rightBean.getData().get(i));
                }
                Log.i("----list222-------", "onNext: "+two_lv_rightBean);
                reference.get().getDataright(list2);
            }
        });
    }
    @Override
    public void attch(ITwo_Lv_LeftView view) {
        reference=new SoftReference<ITwo_Lv_LeftView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
