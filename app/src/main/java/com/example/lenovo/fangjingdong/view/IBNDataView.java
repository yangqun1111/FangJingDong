package com.example.lenovo.fangjingdong.view;

import com.example.lenovo.fangjingdong.bean.Bn_Bean;

import java.util.List;


/**
 * Created by len on 2017/12/9.
 */
//详情View层接口
public interface IBNDataView {
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist);
    public String getBnId();
}
