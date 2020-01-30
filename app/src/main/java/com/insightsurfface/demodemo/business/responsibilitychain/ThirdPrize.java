package com.insightsurfface.demodemo.business.responsibilitychain;

import android.content.Context;

public class ThirdPrize extends Reward {
    public ThirdPrize(Context context) {
        super(context);
    }

    @Override
    public int limit() {
        return 12;
    }

    @Override
    public void giveReward() {
        mToast.showToast("奖励遥控车1个");
    }
}
