package com.insightsurfface.demodemo.business.responsibilitychain;

import android.content.Context;

public class FirstPrize extends Reward {
    public FirstPrize(Context context) {
        super(context);
    }

    @Override
    public int limit() {
        return 15;
    }

    @Override
    public void giveReward() {
        mToast.showToast("奖励巴雷特狙击1把");
    }
}
