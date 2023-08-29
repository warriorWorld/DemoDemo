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
        mView.displayList(new String[]{"冒泡排序", "建造者模式", "触摸事件传递", "策略模式",
                "状态模式", "责任链模式", "Fragment生命周期", "命令模式", "观察者模式/备忘录模式", "模板模式/装饰器模式",
                "访问者模式", "中介者模式", "代理模式", "组合模式", "桥接模式", "工厂模式", "抽象工厂模式", "RxJava",
                "volatile&synchronize","临时测试","Doodle"});
    }

    @Override
    public void onDestroy() {
        mView = null;
        mContext = null;
    }
}
