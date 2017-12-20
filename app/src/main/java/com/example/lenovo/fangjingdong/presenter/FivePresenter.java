package com.example.lenovo.fangjingdong.presenter;

import android.util.Log;

import com.example.lenovo.fangjingdong.bean.Five_toubean;
import com.example.lenovo.fangjingdong.model.FiveModel;
import com.example.lenovo.fangjingdong.model.IFiveModel;
import com.example.lenovo.fangjingdong.view.IFiveView;

import java.lang.ref.SoftReference;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FivePresenter implements IPresenter<IFiveView> {
    SoftReference<IFiveView> reference;
    IFiveModel model;
    public FivePresenter(IFiveView view){
        attch(view);
        model=new FiveModel();
    }

    public void showTouimg(){
        int uid=672;
        model.setFivetoudata().getFiveimg(uid).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Five_toubean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                Log.i("-----touonError-----", "onError: "+throwable.getMessage());
            }

            @Override
            public void onNext(Five_toubean five_toubean) {
                Log.i("-----touonNext-----", "onError: "+five_toubean);
                reference.get().getImageData(five_toubean);
            }
        });
    }
    @Override
    public void attch(IFiveView view) {
        reference=new SoftReference<IFiveView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
