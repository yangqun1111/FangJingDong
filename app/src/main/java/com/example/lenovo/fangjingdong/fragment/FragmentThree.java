package com.example.lenovo.fangjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.fangjingdong.R;

/**
 *
 */

public class FragmentThree extends Fragment {
//    private ExpandableListView mElv;
//    private CheckBox mCheckbox2;
//    private TextView mPriceTv;
//    private TextView mNumTv;
//    private GouWuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView tv=new TextView(getActivity());
        View view = View.inflate(getActivity(), R.layout.fragment_three, null);
//        //注册EventBus
//        EventBus.getDefault().register(this);
//        initView();
//
//        new ShopPresenter(this).getShop();
//        mCheckbox2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapter.changeAllListCbState(mCheckbox2.isChecked());
//            }
//        });

        return view;
    }

//
//    private void initView() {
//        mElv = (ExpandableListView) getView().findViewById(R.id.elv);
//        mCheckbox2 = (CheckBox) getView().findViewById(R.id.checkbox2);
//        mPriceTv = (TextView) getView().findViewById(R.id.tv_price);
//        mNumTv = (TextView) getView().findViewById(R.id.tv_num);
//
//    }
//    @Subscribe
//    public void onMessageEvent(MessageEvent event){
//        mCheckbox2.setChecked(event.isChecked());
//    }
//    @Subscribe
//    public void onMessageEvent(PriceAndCountEvent event){
//        mNumTv.setText("结算("+event.getCount()+")");
//        mPriceTv.setText(event.getPrice() + "");
//    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
//    @Override
//    public void showList(List<ShopBean2.DataBean> groupList, List<List<ShopBean2.DataBean.ListBean>> childList) {
//        adapter=new GouWuAdapter(getActivity(),groupList,childList);
//        mElv.setAdapter(adapter);
//        mElv.setGroupIndicator(null);
//        for(int i=0;i<groupList.size();i++){
//            mElv.expandGroup(i);
//        }
//    }
}
