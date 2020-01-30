package com.insightsurfface.demodemo.business.responsibilitychain;

import android.content.Context;

public class SecondPrize extends Reward {
    public SecondPrize(Context context) {
        super(context);
    }

    @Override
    public int limit() {
        return 14;
    }

    @Override
    public void giveReward() {
        mToast.showToast("奖励沙漠之鹰1把");
    }
}
