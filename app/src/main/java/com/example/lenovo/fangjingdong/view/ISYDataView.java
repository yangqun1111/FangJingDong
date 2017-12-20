package com.example.lenovo.fangjingdong.view;

import com.example.lenovo.fangjingdong.bean.Sy_bean;

import java.util.List;


/**
 * Created by len on 2017/12/9.
 */
//首页View层接口
public interface ISYDataView {
    public void showSYData(List<Sy_bean.GoodsListBean> sylist);
}
