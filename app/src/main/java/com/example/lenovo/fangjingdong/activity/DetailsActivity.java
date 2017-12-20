package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.adapter.PJAdapter;
import com.example.lenovo.fangjingdong.bean.Bn_Bean;
import com.example.lenovo.fangjingdong.bean.Pj_Bean;
import com.example.lenovo.fangjingdong.presenter.BNPresenter;
import com.example.lenovo.fangjingdong.presenter.PJPresenter;
import com.example.lenovo.fangjingdong.utils.BnImageLoader;
import com.example.lenovo.fangjingdong.view.IBNDataView;
import com.example.lenovo.fangjingdong.view.IPJDataView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements IPJDataView,IBNDataView {

    private Banner mbanner;
    private TextView mPriceName,more;
    private ListView d_pj_lv;
    PJPresenter pjPresenter;
    String name;
    List<Pj_Bean.DataBean> pjlist=new ArrayList<>();
    List<Bn_Bean.SkuBean> bnlist=new ArrayList<>();
    String pic;
    String price;
    String id;
    PJAdapter pjAdapter;
    BNPresenter bnPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        Intent intent=getIntent();
        name =intent.getStringExtra("name");
        pic=intent.getStringExtra("pic");
        price=intent.getStringExtra("price");
        id=intent.getStringExtra("id");
        initData();
        pjPresenter=new PJPresenter(this);
        pjShowData(pjlist);
        pjPresenter.ppData();
        bnPresenter=new BNPresenter(this);
        bnShowData(bnlist);
        bnPresenter.ppData();
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DetailsActivity.this,PingJiaActivity.class);
                intent2.putExtra("id",id);
                startActivity(intent2);
            }
        });
    }

    private void initData() {

        mPriceName.setText(price+"\r\n"+name);
    }

    private void initView() {
        mbanner = (Banner) findViewById(R.id.mbanner);
        mPriceName = (TextView) findViewById(R.id.price_name);
        d_pj_lv = (ListView) findViewById(R.id.d_pj_lv);
        more=findViewById(R.id.more);
    }

    @Override
    public void pjShowData(List<Pj_Bean.DataBean> pjlist) {
        pjAdapter=new PJAdapter(this,pjlist);
        d_pj_lv.setAdapter(pjAdapter);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist) {

        ArrayList<String> pic=new ArrayList<>();
        for(int i=0;i<bnlist.size();i++){
            pic.add(bnlist.get(i).getThumb_url());
            Log.i("111111b",""+bnlist.get(i).getThumb_url());
        }
        mbanner.setImageLoader(new BnImageLoader());
        mbanner.setImages(pic);
        mbanner.start();
    }

    @Override
    public String getBnId() {
        return id;
    }
}
