package com.example.lenovo.fangjingdong.view;


import com.example.lenovo.fangjingdong.bean.OneBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Xiangbean;

import java.util.List;

public interface IOneView {
    public void setonebean(List<OneBean.DataBean> list);
    public void setonemsbean(List<OneBean.MiaoshaBean.ListBeanX> list);
    public void setonetjbean(List<OneBean.TuijianBean.ListBean> list);
    public void getVpData(List<Two_Lv_LeftBean.DataBean> bean);
    public void getxiangData(Xiangbean bean);
}
