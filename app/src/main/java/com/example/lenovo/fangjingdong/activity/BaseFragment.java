package com.example.lenovo.fangjingdong.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.fangjingdong.presenter.IPresenter;

public abstract class BaseFragment<T extends IPresenter> extends Fragment {
    public T presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public abstract void createPresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettch();
    }
}
