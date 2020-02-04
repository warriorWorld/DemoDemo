package com.insightsurfface.demodemo.business.template;

import android.content.Context;
import android.text.TextUtils;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

/**
 * 装饰器模式 在不改变原有结构的情况下增加新功能
 */
public class MakeTeaDecorator {
    private MakeTeaAbstract mMakeTea;
    private EasyToast mToast;

    public MakeTeaDecorator(Context context, MakeTeaAbstract makeTea) {
        mToast = new EasyToast(context);
        mMakeTea = makeTea;
    }

    protected String packageTea() {
        return "打包封盖";
    }

    public void makeTea() {
        mMakeTea.makeTea();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7500);
                    mToast.showToast(packageTea());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
