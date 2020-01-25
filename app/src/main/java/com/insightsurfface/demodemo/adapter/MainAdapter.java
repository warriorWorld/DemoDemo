package com.insightsurfface.demodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.listener.OnRecycleItemClickListener;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Administrator on 2017/11/15.
 * 还款页的还款计划
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private String[] list = null;
    private OnRecycleItemClickListener onRecycleItemClickListener;

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        NormalViewHolder vh = new NormalViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        final String item = list[position];
        ((NormalViewHolder) viewHolder).demoTv.setText(item);
        ((NormalViewHolder) viewHolder).mainRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onRecycleItemClickListener) {
                    onRecycleItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public String[] getList() {
        return list;
    }

    @Override
    public int getItemCount() {
        if (null == list) {
            return 0;
        } else {
            return list.length;
        }
    }

    public void setOnRecycleItemClickListener(OnRecycleItemClickListener onRecycleItemClickListener) {
        this.onRecycleItemClickListener = onRecycleItemClickListener;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mainRl;
        public TextView demoTv;

        public NormalViewHolder(View view) {
            super(view);
            mainRl = (RelativeLayout) view.findViewById(R.id.main_rl);
            demoTv = (TextView) view.findViewById(R.id.demo_tv);
        }
    }
}
