package com.insightsurfface.demodemo.business.test;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.utils.DisplayUtil;

import androidx.annotation.Nullable;

/**
 * Created by acorn on 2020/7/11.
 */
public class TestActivity1 extends BaseActivity {
    private ImageView watchHandIv;
    private ObjectAnimator rotation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAnim();
    }

    @Override
    protected void initUI() {
        watchHandIv = findViewById(R.id.watch_hand_iv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waiting;
    }

    private void initAnim() {
        //表针的宽高 因为是固定值直接写死
        watchHandIv.setPivotX(DisplayUtil.dip2px(this,8));
        watchHandIv.setPivotY(DisplayUtil.dip2px(this,29.7f));
        rotation = ObjectAnimator.ofFloat(watchHandIv, "rotation", 0f, 360f);
        rotation.setRepeatCount(ValueAnimator.INFINITE);
        rotation.setRepeatMode(ValueAnimator.RESTART);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setDuration(800);
        rotation.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rotation.cancel();
    }
}
