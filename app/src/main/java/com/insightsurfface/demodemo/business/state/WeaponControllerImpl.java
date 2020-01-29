package com.insightsurfface.demodemo.business.state;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class WeaponControllerImpl implements WeaponController {
    private WeaponState mWeaponState;
    private Context mContext;
    private EasyToast mToast;

    public WeaponControllerImpl(Context context) {
        this.mContext = context;
        mToast = new EasyToast(context);
    }

    public void setWeaponState(WeaponState weaponState) {
        mWeaponState = weaponState;
    }

    @Override
    public void turnHammer() {
        setWeaponState(new HammerState(mContext));
        mToast.showToast("变形！墨丘利之锤！");
    }

    @Override
    public void turnCannon() {
        setWeaponState(new CannonState(mContext));
        mToast.showToast("变形！墨丘利之炮！");
    }

    @Override
    public void transform() {
        if (mWeaponState instanceof CannonState) {
            turnHammer();
        } else {
            turnCannon();
        }
    }

    public void q() {
        mWeaponState.q();
    }

    public void w() {
        mWeaponState.w();
    }

    public void e() {
        mWeaponState.e();
    }
}
