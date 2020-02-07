package com.insightsurfface.demodemo.business.factory;

import android.content.Context;

public class Circle extends Shape {
    public Circle(Context context) {
        super(context);
    }

    @Override
    public void draw() {
        mToast.showToast("绘制圆形");
    }
}
