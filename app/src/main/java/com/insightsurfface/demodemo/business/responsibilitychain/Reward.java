package com.insightsurfface.demodemo.business.responsibilitychain;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public abstract class Reward {
    protected Reward nextHandler;
    protected EasyToast mToast;

    public Reward(Context context) {
        mToast = new EasyToast(context);
    }

    public final void handleReward(int point) {
        if (point <= limit()) {
            giveReward();
        } else {
            if (null != nextHandler) {
                nextHandler.handleReward(point);
            } else {
                mToast.showToast("爆表了！");
            }
        }
    }

    public abstract int limit();

    public abstract void giveReward();
}
