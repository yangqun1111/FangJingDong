package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.adapter.PJXAdapter;
import com.example.lenovo.fangjingdong.bean.Pj_Bean;
import com.example.lenovo.fangjingdong.presenter.PJPresenter;
import com.example.lenovo.fangjingdong.view.IPJDataView;

import java.util.ArrayList;
import java.util.List;

public class PingJiaActivity extends AppCompatActivity implements IPJDataView {
    PJXAdapter pjxAdapter;
    PJPresenter pjPresenter;
    String id;
    List<Pj_Bean.DataBean> pjlist = new ArrayList<>();
    private ListView mPjLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_jia);
        initView();
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        pjPresenter=new PJPresenter(this);
        pjPresenter.ppData();
    }

    private void initView() {
        mPjLv = (ListView) findViewById(R.id.pj_lv);
    }

    @Override
    public void pjShowData(List<Pj_Bean.DataBean> pjlist) {
        pjxAdapter=new PJXAdapter(this,pjlist);
        mPjLv.setAdapter(pjxAdapter);
    }

    @Override
    public String getId() {
        return id;
    }
}
