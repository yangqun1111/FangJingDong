package com.example.lenovo.fangjingdong.model;

import com.example.lenovo.fangjingdong.bean.ShopBean2;
import com.example.lenovo.fangjingdong.utils.OnNetListenter;


/**
 * Created by 杨群 on 2017/12/19.
 */

public interface IShopModel {
public void getShop(OnNetListenter<ShopBean2> onNetListenter);
}
