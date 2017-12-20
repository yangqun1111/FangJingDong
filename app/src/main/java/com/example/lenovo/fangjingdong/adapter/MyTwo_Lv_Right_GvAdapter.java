package com.example.lenovo.fangjingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.activity.FenLeiChildActivity;
import com.example.lenovo.fangjingdong.bean.Two_Lv_rightBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class MyTwo_Lv_Right_GvAdapter extends BaseAdapter {
    List<Two_Lv_rightBean.DataBean.ListBean> list;
    Context context;

    public MyTwo_Lv_Right_GvAdapter(List<Two_Lv_rightBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.fragment_two_lv_right_gv_item,null);
            hodler=new ViewHodler();
            hodler.sdv=convertView.findViewById(R.id.lv_right_gv_dwv);
            hodler.tv=convertView.findViewById(R.id.lv_right_gv_tv);
            hodler.ll=convertView.findViewById(R.id.classify_right_ev_child_item_ll);
            convertView.setTag(hodler);
        }else{
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.tv.setText(list.get(position).getName());
        Uri uri=Uri.parse(list.get(position).getIcon());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .build();
        hodler.sdv.setController(controller);
        hodler.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FenLeiChildActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHodler{
        SimpleDraweeView sdv;
        TextView tv;
        LinearLayout ll;
    }
}
