package com.example.lenovo.fangjingdong.presenter;

import android.util.Log;


import com.example.lenovo.fangjingdong.bean.Four_querycarbean;
import com.example.lenovo.fangjingdong.model.FourModel;
import com.example.lenovo.fangjingdong.model.IFourModel;
import com.example.lenovo.fangjingdong.view.IFourView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FourPresenter implements IPresenter<IFourView> {
    List<Four_querycarbean.DataBean.ListBean> list=new ArrayList<>();
    SoftReference<IFourView> reference;
    IFourModel model;
    public FourPresenter(IFourView view){
        attch(view);
        model=new FourModel();
    }

    public void showQuerycarts(){
        int uid=672;
        model.setquerycartsdata().getqueryCarts(uid).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Four_querycarbean>() {
              @Override
              public void onCompleted() {

              }

              @Override
              public void onError(Throwable throwable) {
                  Log.i("-----query-----", "onError: "+throwable.getMessage());
              }

              @Override
              public void onNext(Four_querycarbean four_querycar) {
                  for (int i = 0; i < four_querycar.getData().size(); i++) {
                      for (int j = 0; j <four_querycar.getData().get(i).getList().size() ; j++) {
                          list.add(four_querycar.getData().get(i).getList().get(j));
                      }

                  }
                  Log.i("-----query-----", "onError: "+list.size());

                  reference.get().getquerycartsData(list);
              }
          });
    }

    @Override
    public void attch(IFourView view) {
        reference=new SoftReference<IFourView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
