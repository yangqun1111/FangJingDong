package com.example.lenovo.fangjingdong.presenter;

import android.support.v4.app.Fragment;

import com.example.lenovo.fangjingdong.model.IMainVpModel;
import com.example.lenovo.fangjingdong.model.MainVpModel;
import com.example.lenovo.fangjingdong.view.IMainVpView;

import java.lang.ref.SoftReference;
import java.util.List;

public class MainVpPrensenter implements IPresenter<IMainVpView> {
    SoftReference<IMainVpView> reference;
    IMainVpModel model;
    public MainVpPrensenter(IMainVpView view) {
        attch(view);
        model=new MainVpModel();
    }
    public void showFragmentVp(){
        model.setFragment(new IMainVpModel.BackVP() {
            @Override
            public void getRgVp(List<Fragment> list) {
                reference.get().getFragment(list);
            }
        });
    }
    @Override
    public void attch(IMainVpView view) {
        reference=new SoftReference<IMainVpView>(view);

    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
