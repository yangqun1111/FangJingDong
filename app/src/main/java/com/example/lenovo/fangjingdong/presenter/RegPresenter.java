package com.example.lenovo.fangjingdong.presenter;


import com.example.lenovo.fangjingdong.bean.Regbean;
import com.example.lenovo.fangjingdong.model.IRegModel;
import com.example.lenovo.fangjingdong.model.RegModel;
import com.example.lenovo.fangjingdong.net.RegNet;
import com.example.lenovo.fangjingdong.view.IRegView;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RegPresenter implements IPresenter<IRegView> {
    SoftReference<IRegView> reference;
    IRegModel model;

    public RegPresenter(IRegView view) {
        model=new RegModel();
        attch(view);
    }
    public void regData(){
        String getname = reference.get().getname();
        String getpass = reference.get().getpass();

        RegNet regNet=model.setRegData();
        HashMap<String,Object> map=new HashMap<>();
        map.put("mobile",getname);
        map.put("password",getpass);
        regNet.getreg(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Regbean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Regbean regbean) {
                reference.get().getData(regbean);
            }
        });

    }

    @Override
    public void attch(IRegView view) {
        reference=new SoftReference<IRegView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
