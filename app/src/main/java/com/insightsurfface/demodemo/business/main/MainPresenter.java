package com.insightsurfface.demodemo.business.main;

import android.content.Context;

public class MainPresenter implements MainContract.Persenter {
    private Context mContext;
    private MainContract.View mView;

    public MainPresenter(Context context, MainContract.View view) {
        this.mContext = context;
        this.mView = view;
    }

    @Override
    public void getDemoList() {
        mView.displayList(new String[]{"冒泡排序", "建造者模式","触摸事件传递","策略模式","状态模式"});
    }

    @Override
    public void onDestroy() {
        mView = null;
        mContext = null;
    }
}
