package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.adapter.Myadapter;
import com.example.lenovo.fangjingdong.bean.ShopBean;
import com.example.lenovo.fangjingdong.presenter.Persenter;
import com.example.lenovo.fangjingdong.view.Iview;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/12/13.
 */

public class SousuoActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.sxrv)
    RecyclerView rv;
    Persenter pp;
    Myadapter rvadapter;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.ll2)
    LinearLayout ll2;

    List<ShopBean.DataBean> listtj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_sousuo);
        ButterKnife.bind(this);
        pp = new Persenter(this, this);
        listtj=new ArrayList<>();
    }

    @Override
    public void ShowView(ShopBean bean) {
        listtj=bean.getData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rvadapter = new Myadapter(this, bean);
        rv.setAdapter(rvadapter);
        rvadapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(SousuoActivity.this, "dd", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SousuoActivity.this, XiangqingActivity.class);
                intent.putExtra("id", listtj.get(position).getPid());
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.btn)
    public void onClick() {
        String s = et.getText().toString();
        if(!TextUtils.isEmpty(s)){
            pp.getData(s);
        }else{
            Toast.makeText(this, "请输入东西", Toast.LENGTH_SHORT).show();
        }
    }
}
