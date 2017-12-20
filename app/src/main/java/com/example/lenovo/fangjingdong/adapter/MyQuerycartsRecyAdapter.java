package com.example.lenovo.fangjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.fangjingdong.R;

import com.example.lenovo.fangjingdong.bean.Four_querycarbean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyQuerycartsRecyAdapter extends RecyclerView.Adapter<MyQuerycartsRecyAdapter.ViewHolder> {
    OnItemClickListener listener;
    Context context;
    List<Four_querycarbean.DataBean.ListBean> list;


    public MyQuerycartsRecyAdapter(Context context) {
        this.context = context;
    }
    public void setquerycartsData(List<Four_querycarbean.DataBean.ListBean> list){
        this.list=list;

    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_four_cartsitem, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String split=list.get(position).getImages();
        String[] images=split.split("\\|");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(images[0])
                .build();
        holder.sdv.setController(controller);
        holder.tvs.setText(list.get(position).getTitle());
        holder.tvs2.setText("￥"+list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.eckboxnum)
        CheckBox eckboxnum;
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tvs)
        TextView tvs;
        @BindView(R.id.tvs2)
        TextView tvs2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        public void OnItemClick(int position);
    }
}
