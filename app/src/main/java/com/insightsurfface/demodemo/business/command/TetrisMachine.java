package com.insightsurfface.demodemo.business.command;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class TetrisMachine {
    private EasyToast mToast;

    public TetrisMachine(Context context) {
        mToast = new EasyToast(context);
    }

    public void toLeft() {
        mToast.showToast("向左");
    }

    public void toRight() {
        mToast.showToast("向右");
    }

    public void rotate() {
        mToast.showToast("旋转");
    }
}
