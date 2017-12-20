package com.example.lenovo.fangjingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fangjingdong.MainActivity;
import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.bean.Loginbean;
import com.example.lenovo.fangjingdong.presenter.LoginPresenter;
import com.example.lenovo.fangjingdong.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_reg)
    TextView loginReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        boolean islogin = sharedPreferences.getBoolean("is_login", false);
        if(islogin){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
    }

    @Override
    public void createPresenter() {
        presenter=new LoginPresenter(this,this);
    }

    private void initData() {

        loginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showlogin();
            }
        });
    }

    @Override
    public String getname() {
        return loginUsername.getText().toString();
    }

    @Override
    public String getpass() {
        return loginPassword.getText().toString();
    }

    @Override
    public void getData(Loginbean bean) {
        if(bean.getCode().equals("0")){
            presenter.showTouXinag();
            editor.putBoolean("is_login",true);
            editor.commit();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
