package com.insightsurfface.demodemo.business.factory;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public abstract class Shape {
    protected EasyToast mToast;

    public Shape(Context context) {
        mToast = new EasyToast(context);
    }

    public abstract void draw();
}
