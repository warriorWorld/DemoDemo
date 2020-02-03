package com.insightsurfface.demodemo.business.agency;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class Leopard implements Skill {
    private EasyToast mToast;

    public Leopard(Context context) {
        mToast = new EasyToast(context);
    }

    @Override
    public void q() {
        mToast.showToast("标枪");
    }

    @Override
    public void w() {

    }

    @Override
    public void e() {

    }

    @Override
    public void r() {
        mToast.showToast("美洲狮");
    }
}
