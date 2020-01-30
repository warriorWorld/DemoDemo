package com.insightsurfface.demodemo.business.responsibilitychain;

import android.content.Context;

public class ConsolationPrize extends Reward {
    public ConsolationPrize(Context context) {
        super(context);
    }

    @Override
    public int limit() {
        return 9;
    }

    @Override
    public void giveReward() {
        mToast.showToast("钥匙链任选一个");
    }
}
