package com.example.lenovo.fangjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.activity.BaseFragment;
import com.example.lenovo.fangjingdong.adapter.MyQuerycartsRecyAdapter;
import com.example.lenovo.fangjingdong.bean.Four_querycarbean;
import com.example.lenovo.fangjingdong.presenter.FourPresenter;
import com.example.lenovo.fangjingdong.view.IFourView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentFour extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv=new TextView(getActivity());
        tv.setText("444");
        return tv;
    }
}


//    @Override
//    public void createPresenter() {
//        presenter = new FourPresenter(this);
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
//
//    @Override
//    public void getquerycartsData(List<Four_querycarbean.DataBean.ListBean> four_querycar) {
//        fourRcv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new MyQuerycartsRecyAdapter(getActivity());
//        adapter.setquerycartsData(four_querycar);
//        fourRcv.setAdapter(adapter);
//    }

