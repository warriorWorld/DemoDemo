package com.insightsurfface.demodemo.business.doodle;

import android.content.Context;
import android.view.View;

/**
 * Created by chengyijun on 2019/8/14.
 */

public abstract class AbsDisposer {
    public Context mViewContext;
    public boolean mViewIsAlive = true;

    public void initLayout(View layout) {
        initContext(layout);
    }

    public abstract void release();

    public void initContext(View view) {
        mViewContext = view.getContext();
    }

    public void viewIsAlive(boolean isAlive) {
        mViewIsAlive = isAlive;
    }
}
