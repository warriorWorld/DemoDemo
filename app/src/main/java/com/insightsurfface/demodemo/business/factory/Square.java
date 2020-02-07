package com.insightsurfface.demodemo.business.factory;

import android.content.Context;

public class Square extends Shape {
    public Square(Context context) {
        super(context);
    }

    @Override
    public void draw() {
        mToast.showToast("绘制矩形");
    }
}
