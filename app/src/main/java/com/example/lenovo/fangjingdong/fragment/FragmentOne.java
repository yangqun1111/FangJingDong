package com.example.lenovo.fangjingdong.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.activity.BaseFragment;
import com.example.lenovo.fangjingdong.activity.SousuoActivity;
import com.example.lenovo.fangjingdong.activity.XiangqingActivity;
import com.example.lenovo.fangjingdong.adapter.MyOneGvAdapter1;
import com.example.lenovo.fangjingdong.adapter.MyOneGvAdapter2;
import com.example.lenovo.fangjingdong.adapter.MyOneVpAdapter;
import com.example.lenovo.fangjingdong.adapter.MyRecyMsAdapter;
import com.example.lenovo.fangjingdong.adapter.MyRecyTjAdapter;
import com.example.lenovo.fangjingdong.bean.OneBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Xiangbean;
import com.example.lenovo.fangjingdong.presenter.OnePresenter;
import com.example.lenovo.fangjingdong.utils.Imagebanner;
import com.example.lenovo.fangjingdong.view.IOneView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentOne extends BaseFragment<OnePresenter> implements IOneView {
    @BindView(R.id.one_bn)
    Banner oneBn;
    @BindView(R.id.one_sdv)
    SimpleDraweeView oneSdv;
    @BindView(R.id.one_vp)
    ViewPager onevp;
    @BindView(R.id.one_tv_hour)
    TextView oneTvHour;
    @BindView(R.id.one_tv_minute)
    TextView oneTvMinute;
    @BindView(R.id.one_tv_second)
    TextView oneTvSecond;
    @BindView(R.id.one_xsqg)
    LinearLayout oneXsqg;
    @BindView(R.id.one_ms_recy)
    RecyclerView oneMsRecy;
    @BindView(R.id.one_tj_recy)
    RecyclerView oneTjRecy;
    Unbinder unbinder;
    List<GridView> listgv;
    GridView gv1;
    GridView gv2;
    MyOneVpAdapter vpadapter;
    MyRecyMsAdapter msAdapter;
    MyRecyTjAdapter tjAdapter;
    @BindView(R.id.one_vf)
    ViewFlipper oneVf;
    List<OneBean.MiaoshaBean.ListBeanX> listms;
    List<OneBean.TuijianBean.ListBean> listtj;
    @BindView(R.id.sou_in_head_et)
    EditText souInHeadEt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.fragment_one, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initgif();
        initVP();
        //实现跑马灯
        initVF();
        initClick();
        return view;
    }

    private void initClick() {

    }
     //实现跑马灯
    private void initVF() {
        oneVf.addView(View.inflate(getActivity(), R.layout.fragment_one_vf_item, null));
        oneVf.addView(View.inflate(getActivity(), R.layout.fragment_one_vf_item1, null));
        oneVf.addView(View.inflate(getActivity(), R.layout.fragment_one_vf_item2, null));

    }
   //显示京东超市的viewpager的页面
    private void initVP() {
        listgv = new ArrayList<>();
        gv1 = new GridView(getActivity());
        gv1.setNumColumns(5);
        gv2 = new GridView(getActivity());
        gv2.setNumColumns(5);
        listgv.add(gv1);
        listgv.add(gv2);
        vpadapter = new MyOneVpAdapter(listgv, getActivity());
        onevp.setAdapter(vpadapter);
        onevp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        presenter.showoneGV();
    }

    private void initgif() {

        DraweeController con = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res://" + getActivity().getPackageName() + "/" + R.mipmap.gif))
                .setAutoPlayAnimations(true)
                .build();
        oneSdv.setController(con);
    }

    private void initData() {
        listms = new ArrayList<>();
        listtj = new ArrayList<>();
        presenter.showoneBanner();
        presenter.showoneGV();
    }

    @Override
    public void createPresenter() {
        presenter = new OnePresenter(this, getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setonebean(List<OneBean.DataBean> list) {
        List<String> array = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            array.add(list.get(i).getIcon());
        }
        oneBn.setImageLoader(new Imagebanner());
        oneBn.setImages(array);
        oneBn.start();
    }

    @Override
    public void setonemsbean(List<OneBean.MiaoshaBean.ListBeanX> list) {
        listms = list;
        LinearLayoutManager mgr = new LinearLayoutManager(getActivity());
        mgr.setOrientation(LinearLayoutManager.HORIZONTAL);
        oneMsRecy.setLayoutManager(mgr);
        msAdapter = new MyRecyMsAdapter(list, getActivity());
        oneMsRecy.setAdapter(msAdapter);
        msAdapter.setOnMsItemClickListener(new MyRecyMsAdapter.OnMsItemClickListener() {
            @Override
            public void OnMsItemClick(int position) {
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("id", listms.get(position).getPid());
                startActivity(intent);
            }
        });

    }

    @Override
    public void setonetjbean(List<OneBean.TuijianBean.ListBean> list) {
        listtj = list;
        GridLayoutManager mgr = new GridLayoutManager(getActivity(), 2);
        oneTjRecy.setLayoutManager(mgr);
        tjAdapter = new MyRecyTjAdapter(list, getActivity());
        oneTjRecy.setAdapter(tjAdapter);
        tjAdapter.setOnTjItemClickListener(new MyRecyTjAdapter.OnTjItemClickListener() {
            @Override
            public void OnTJItemClick(int position) {
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("id", listtj.get(position).getPid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getVpData(List<Two_Lv_LeftBean.DataBean> bean) {
        MyOneGvAdapter1 adapter1 = new MyOneGvAdapter1(bean, getActivity());
        gv1.setAdapter(adapter1);
        MyOneGvAdapter2 adapter2 = new MyOneGvAdapter2(bean, getActivity());
        gv2.setAdapter(adapter2);
    }

    @Override
    public void getxiangData(Xiangbean bean) {

    }

    @OnClick(R.id.sou_in_head_et)
    public void onClick() {
        Intent intent = new Intent(getActivity(), SousuoActivity.class);
        startActivity(intent);
    }
}
