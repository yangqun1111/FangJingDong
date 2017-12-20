package com.example.lenovo.fangjingdong.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.activity.BaseFragment;
import com.example.lenovo.fangjingdong.activity.LoginActivity;
import com.example.lenovo.fangjingdong.bean.Five_toubean;
import com.example.lenovo.fangjingdong.presenter.FivePresenter;
import com.example.lenovo.fangjingdong.view.IFiveView;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;
import static com.example.lenovo.fangjingdong.R.id.five_btn_dl;


public class FragmentFive extends BaseFragment<FivePresenter> implements IFiveView {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @BindView(R.id.five_imageView)
    SimpleDraweeView imageView;
    @BindView(five_btn_dl)
    TextView fiveBtnDl;
    @BindView(R.id.five_imageView2)
    ImageView fiveImageView2;
    @BindView(R.id.radioButton)
    RadioButton radioButton;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.fragment_five, null);
        unbinder = ButterKnife.bind(this, view);

        initData();
        return view;
    }


    @Override
    public void createPresenter() {
        presenter=new FivePresenter(this);
    }

    private void initData() {
        sharedPreferences=getActivity().getSharedPreferences("login",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        final boolean islogin = sharedPreferences.getBoolean("is_login", false);
        fiveBtnDl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(islogin){
                    presenter.showTouimg();
                    Toast.makeText(getActivity(), "已经登录过了", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    return;
                }

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getImageData(Five_toubean five_toubean) {
        fiveBtnDl.setText("用户名："+five_toubean.getData().getUsername());
//        Uri uri=Uri.parse(five_toubean.getData().getIcon());
//        DraweeController controller= Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .build();
//        imageView.setController(controller);
    }
}
