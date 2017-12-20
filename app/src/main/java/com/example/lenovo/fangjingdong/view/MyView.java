package com.example.lenovo.fangjingdong.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;

/**
 * Created by 杨群 on 2017/12/19.
 */

public class MyView extends LinearLayout {
    private ImageView mDelIv;
    private TextView mNumTv;
    private ImageView mAddIv;

    public MyView(Context context) {
        super(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context)
                .inflate(R.layout.myview, this);
        initView(view);
    }

    private void initView(@NonNull final View itemView) {
        mDelIv = (ImageView) itemView.findViewById(R.id.iv_del);
        mNumTv = (TextView) itemView.findViewById(R.id.tv_num);
        mAddIv = (ImageView) itemView.findViewById(R.id.iv_add);
    }
    public void setAddClickListener(OnClickListener onClickListener){
        mAddIv.setOnClickListener(onClickListener);
    }
    public void setDelClickListener(OnClickListener onClickListener){
        mDelIv.setOnClickListener(onClickListener);
    }
    public void setNum(String num) {
        mNumTv.setText(num);
    }
    public int getNum() {
        String num = mNumTv.getText().toString();
        return Integer.parseInt(num);
    }
}
