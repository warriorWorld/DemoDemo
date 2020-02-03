package com.insightsurfface.demodemo.business.agency;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class Vi implements Skill {
    private EasyToast mToast;

    public Vi(Context context) {
        mToast = new EasyToast(context);
    }

    @Override
    public void q() {
        mToast.showToast("强能冲拳");
    }

    @Override
    public void w() {
        mToast.showToast("爆弹重拳");
    }

    @Override
    public void e() {

    }

    @Override
    public void r() {
        mToast.showToast("天霸横空轰烈");
    }
}
