package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.bean.Regbean;
import com.example.lenovo.fangjingdong.presenter.RegPresenter;
import com.example.lenovo.fangjingdong.view.IRegView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends BaseActivity<RegPresenter> implements IRegView {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.reg_username)
    EditText regUsername;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.reg_password)
    EditText regPassword;
    @BindView(R.id.reg_btn)
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.regData();
            }
        });

    }

    @Override
    public void createPresenter() {
        presenter=new RegPresenter(this);
    }

    @Override
    public String getname() {
       return regUsername.getText().toString();
    }

    @Override
    public String getpass() {
        return regPassword.getText().toString();
    }

    @Override
    public void getData(Regbean bean) {
//        Log.i("----", "onSuccess: "+bean.getCode());
        if(bean.getCode().equals("0")){
//            Log.i("----", "onSuccess: "+"尽力啊");
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(RegActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
