package com.insightsurfface.demodemo.business.state;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class HammerState implements WeaponState {
    private Context mContext;
    private EasyToast mToast;

    public HammerState(Context context) {
        this.mContext = context;
        mToast = new EasyToast(context);
    }

    @Override
    public void q() {
        mToast.showToast("苍穹之跃");
    }

    @Override
    public void w() {
        mToast.showToast("闪电领域");
    }

    @Override
    public void e() {
        mToast.showToast("雷霆一击");
    }
}
