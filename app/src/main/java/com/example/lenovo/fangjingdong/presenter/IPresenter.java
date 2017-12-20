package com.example.lenovo.fangjingdong.presenter;

/**
 * Created by 郭金龙 on 2017/11/15.
 */

public interface IPresenter<T> {
    public void attch(T view);
    public void dettch();
}
