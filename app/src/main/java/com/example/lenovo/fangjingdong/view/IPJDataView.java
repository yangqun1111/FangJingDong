package com.example.lenovo.fangjingdong.view;

import com.example.lenovo.fangjingdong.bean.Pj_Bean;

import java.util.List;


/**
 * Created by len on 2017/12/9.
 */
//评价View层接口
public interface IPJDataView {
    public void pjShowData(List<Pj_Bean.DataBean> pjlist);
    public String getId();
}
