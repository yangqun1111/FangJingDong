package com.example.lenovo.fangjingdong.presenter;

import android.util.Log;

import com.example.lenovo.fangjingdong.bean.Pj_Bean;
import com.example.lenovo.fangjingdong.model.PJDataModel;
import com.example.lenovo.fangjingdong.view.IPJDataView;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;

/**
 * Created by len on 2017/12/9.
 */
//评价页面
public class PJPresenter {
    PJDataModel model;
    IPJDataView view;
    List<Pj_Bean.DataBean> pjlist=new ArrayList<>();

    public PJPresenter(IPJDataView view) {
        this.view = view;
        model=new PJDataModel();
    }
    public void ppData(){
        String id=view.getId();
        model.getPJData(id,new Observer<Pj_Bean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("111111p","onError");
            }

            @Override
            public void onNext(Pj_Bean pj_bean) {
                pjlist.addAll(pj_bean.getData());
                view.pjShowData(pjlist);
            }
        });
    }
}
