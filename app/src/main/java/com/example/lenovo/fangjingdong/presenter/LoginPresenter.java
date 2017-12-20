package com.example.lenovo.fangjingdong.presenter;

import android.content.Context;
import android.util.Log;

import com.example.lenovo.fangjingdong.bean.Loginbean;
import com.example.lenovo.fangjingdong.model.ILoginModel;
import com.example.lenovo.fangjingdong.model.LoginModel;
import com.example.lenovo.fangjingdong.net.LoginNet;
import com.example.lenovo.fangjingdong.view.ILoginView;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginPresenter implements IPresenter<ILoginView> {
    SoftReference<ILoginView> reference;
    ILoginModel model;
    Context context;
    public LoginPresenter(ILoginView view, Context context) {
        attch(view);
        this.context=context;
        model=new LoginModel();
    }
    public void showlogin(){
        String getname = reference.get().getname();
        String getpass = reference.get().getpass();
        LoginNet loginNet = model.setloginData();
        HashMap<String,Object> map=new HashMap<>();
        map.put("mobile",getname);
        map.put("password",getpass);
        loginNet.getlogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Loginbean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Loginbean regbean) {
                reference.get().getData(regbean);
            }
        });
    }
    public void showTouXinag(){
//        String path="res://" + context.getPackageName() + "/" + R.mipmap.k;
        String path="mnt/sdcard/DCIM/Camera/IMG_20171119_184136.jpg";
        File file=new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String token="4E2388C1DB8C507D9320BCE7D54E62EE";
        String uid="672";
        MultipartBody.Builder builder=new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        RequestBody imageBody=RequestBody.create(MediaType.parse("mulitpart/form-data"),file);
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("token",token);
        builder.addFormDataPart("file",file.getName(),imageBody);
        List<MultipartBody.Part> parts=builder.build().parts();
//        map.put("uid","672");
//        map.put("file",path);
//        map.put("token","4E2388C1DB8C507D9320BCE7D54E62EE");
       model.setloginTouData().loadTou(parts).enqueue(new Callback<Result<String>>() {
           @Override
           public void onResponse(Call<Result<String>> call, Response<Result<String>> response) {
               Log.i("----成功------", "onResponse: "+response.body().toString());
           }

           @Override
           public void onFailure(Call<Result<String>> call, Throwable t) {
               Log.i("----失败------", "Throwable: "+t.getMessage());
           }
       });
    }
    @Override
    public void attch(ILoginView view) {
        reference=new SoftReference<ILoginView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
