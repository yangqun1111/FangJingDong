package com.example.lenovo.fangjingdong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.lenovo.fangjingdong.MainActivity;
import com.example.lenovo.fangjingdong.R;

public class WelcomeActivity extends Activity {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },2000);
    }
}
