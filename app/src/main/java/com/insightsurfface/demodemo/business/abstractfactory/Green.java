package com.insightsurfface.demodemo.business.abstractfactory;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class Green implements Color {
    private EasyToast mToast;

    public Green(Context context) {
        mToast = new EasyToast(context);
    }

    @Override
    public void fill() {
        mToast.showToast("填充绿色");
    }
}
