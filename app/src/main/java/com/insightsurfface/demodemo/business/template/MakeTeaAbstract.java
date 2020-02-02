package com.insightsurfface.demodemo.business.template;

import android.content.Context;
import android.text.TextUtils;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public abstract class MakeTeaAbstract {
    private EasyToast mToast;

    public MakeTeaAbstract(Context context) {
        mToast = new EasyToast(context);
    }

    protected abstract String addTea();

    protected abstract String addLiquid();

    protected abstract String addFlavour();

    public final void makeTea() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mToast.showToast(addTea());
                    Thread.sleep(2500);
                    mToast.showToast(addLiquid());
                    Thread.sleep(2500);
                    if (!TextUtils.isEmpty(addFlavour())) {
                        mToast.showToast(addFlavour());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
