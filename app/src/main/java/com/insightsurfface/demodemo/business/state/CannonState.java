package com.insightsurfface.demodemo.business.state;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class CannonState implements WeaponState {
    private Context mContext;
    private EasyToast mToast;

    public CannonState(Context context) {
        this.mContext = context;
        mToast = new EasyToast(context);
    }

    @Override
    public void q() {
        mToast.showToast("电能震荡");
    }

    @Override
    public void w() {
        mToast.showToast("超能电荷");
    }

    @Override
    public void e() {
        mToast.showToast("加速之门");
    }
}
