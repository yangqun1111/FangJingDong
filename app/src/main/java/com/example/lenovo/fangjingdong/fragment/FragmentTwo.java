package com.example.lenovo.fangjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.activity.BaseFragment;
import com.example.lenovo.fangjingdong.adapter.MyTwo_Lv_LeftAdapter;
import com.example.lenovo.fangjingdong.adapter.MyTwo_Lv_RightAdapter;
import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_rightBean;
import com.example.lenovo.fangjingdong.presenter.Two_Lv_LeftPresenter;
import com.example.lenovo.fangjingdong.view.ITwo_Lv_LeftView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentTwo extends BaseFragment<Two_Lv_LeftPresenter> implements ITwo_Lv_LeftView {
    @BindView(R.id.two_lv_left)
    ListView twoLvLeft;
    @BindView(R.id.two_lv_right)
    ListView twoLvRight;
    Unbinder unbinder;
    MyTwo_Lv_LeftAdapter adapter;
    MyTwo_Lv_RightAdapter adapter2;
    List<Two_Lv_LeftBean.DataBean> list;
    List<Two_Lv_rightBean.DataBean> list2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.fragment_two, null);
        unbinder = ButterKnife.bind(this, view);
        list=new ArrayList<>();
        list2=new ArrayList<>();
        presenter.showLvLeft();
        presenter.showLvrigth(1+"");
        initData();
        return view;
    }

    private void initData() {
        twoLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list2.clear();
                presenter.showLvrigth(list.get(position).getCid()+"");
            }
        });
    }


    @Override
    public void createPresenter() {
        presenter=new Two_Lv_LeftPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getData(List<Two_Lv_LeftBean.DataBean> bean) {
        list=bean;
        adapter=new MyTwo_Lv_LeftAdapter(bean,getActivity());
        twoLvLeft.setAdapter(adapter);
    }

    @Override
    public void getDataright(List<Two_Lv_rightBean.DataBean> bean) {
        list2=bean;
        adapter2=new MyTwo_Lv_RightAdapter(list2,getActivity());
        twoLvRight.setAdapter(adapter2);
    }
}
