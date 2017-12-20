package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fangjingdong.R;

import com.example.lenovo.fangjingdong.bean.OneBean;
import com.example.lenovo.fangjingdong.bean.Two_Lv_LeftBean;
import com.example.lenovo.fangjingdong.bean.Xiangbean;
import com.example.lenovo.fangjingdong.presenter.OnePresenter;
import com.example.lenovo.fangjingdong.utils.MyPop;
import com.example.lenovo.fangjingdong.view.IOneView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangqingActivity extends BaseActivity<OnePresenter> implements IOneView {
    int id;
    @BindView(R.id.one_xiang_sdv)
    SimpleDraweeView oneXiangSdv;
    @BindView(R.id.one_xiang_tv)
    TextView oneXiangTv;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.one_xiang_tv_subhead)
    TextView oneXiangTvSubhead;
    @BindView(R.id.one_xiang_tv_time)
    TextView oneXiangTvTime;
    @BindView(R.id.one_xiang_tv_price)
    TextView oneXiangTvPrice;
    @BindView(R.id.one_xiang_ivkf)
    ImageView oneXiangIvkf;
    @BindView(R.id.one_xiang_ivguan)
    ImageView oneXiangIvguan;
    @BindView(R.id.one_xiang_btnli)
    Button oneXiangBtnli;
    @BindView(R.id.one_xiang_btnadd)
    Button oneXiangBtnadd;
    Xiangbean ba;
    MyPop pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.i("---id-------", "onCreate: " + id);
        initData();
        initClick();
    }

    private void initClick() {
        oneXiangBtnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop=new MyPop(XiangqingActivity.this,ba);
                pop.showpop();
            }
        });
        oneXiangBtnli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop=new MyPop(XiangqingActivity.this,ba);
                pop.showpop();
            }
        });
    }

    private void initData() {
        presenter.showoneXiang(id);
    }

    @Override
    public void createPresenter() {
        presenter = new OnePresenter(this, this);
    }

    @Override
    public void setonebean(List<OneBean.DataBean> list) {

    }

    @Override
    public void setonemsbean(List<OneBean.MiaoshaBean.ListBeanX> list) {

    }

    @Override
    public void setonetjbean(List<OneBean.TuijianBean.ListBean> list) {

    }

    @Override
    public void getVpData(List<Two_Lv_LeftBean.DataBean> bean) {

    }

    @Override
    public void getxiangData(Xiangbean bean) {
        ba=bean;
        String images = bean.getData().getImages();
        String[] split = images.split("\\|");
        DraweeController con = Fresco.newDraweeControllerBuilder()
                .setUri(split[0])
                .build();
        oneXiangSdv.setController(con);
        tvName.setText(bean.getData().getTitle());
        oneXiangTvSubhead.setText(bean.getData().getSubhead());
        oneXiangTvTime.setText(bean.getData().getCreatetime());
        oneXiangTvPrice.setText("￥" + bean.getData().getPrice());
        oneXiangIvkf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("tel:10086"));
                startActivity(in);
            }
        });
        oneXiangIvguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(XiangqingActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
