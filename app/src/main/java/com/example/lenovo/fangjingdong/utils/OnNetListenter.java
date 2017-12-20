package com.example.lenovo.fangjingdong.utils;

/**
 * Created by 杨群 on 2017/12/19.
 */

public interface OnNetListenter<T> {
public void onSueecss(T t);
public void onFailure(Exception e);
}
