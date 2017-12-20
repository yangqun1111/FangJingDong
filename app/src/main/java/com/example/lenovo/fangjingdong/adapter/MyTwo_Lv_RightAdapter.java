package com.example.lenovo.fangjingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;
import com.example.lenovo.fangjingdong.bean.Two_Lv_rightBean;

import java.util.List;

public class MyTwo_Lv_RightAdapter extends BaseAdapter {
    //适配器里面有一个标题和一个gridview
    List<Two_Lv_rightBean.DataBean> list;
    Context context;

    public MyTwo_Lv_RightAdapter(List<Two_Lv_rightBean.DataBean> list, Context context) {
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
            convertView=View.inflate(context, R.layout.fragment_two_lv_right,null);
            hodler=new ViewHodler();
            hodler.gv=convertView.findViewById(R.id.lv_right_gv);
            hodler.tv=convertView.findViewById(R.id.lv_right_tv);
            convertView.setTag(hodler);
        }else{
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.tv.setText(list.get(position).getName());
        list.get(position).getList();
        MyTwo_Lv_Right_GvAdapter adapter=new MyTwo_Lv_Right_GvAdapter(list.get(position).getList(),context);
        hodler.gv.setAdapter(adapter);
        return convertView;
    }
    class ViewHodler{
        GridView gv;
        TextView tv;
    }
}
