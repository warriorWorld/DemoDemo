package com.insightsurfface.demodemo.business.test;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

/**
 * Created by acorn on 2020/7/11.
 */
public class TestActivity extends BaseActivity {
    private ImageView headIv1;
    private ImageView headIv2;
    private ImageView headIv3;
    private ImageView headIv4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAnim();
    }

    @Override
    protected void initUI() {
        headIv1 = (ImageView) findViewById(R.id.head_iv1);
        headIv2 = (ImageView) findViewById(R.id.head_iv2);
        headIv3 = (ImageView) findViewById(R.id.head_iv3);
        headIv4 = (ImageView) findViewById(R.id.head_iv4);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    private void initAnim() {
        long delay = 1000;
        ObjectAnimator translationY1 = getTranslationYAnim(headIv1, 0);
        ObjectAnimator alpha1 = getAlphaAnim(headIv1, 0);
        ObjectAnimator translationY2 = getTranslationYAnim(headIv2, delay);
        ObjectAnimator alpha2 = getAlphaAnim(headIv2, delay);
        ObjectAnimator translationY3 = getTranslationYAnim(headIv3, delay * 2);
        ObjectAnimator alpha3 = getAlphaAnim(headIv3, delay * 2);
        ObjectAnimator translationY4 = getTranslationYAnim(headIv4, delay * 3);
        ObjectAnimator alpha4 = getAlphaAnim(headIv4, delay * 3);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationY1, translationY2, translationY3, translationY4, alpha1,
                alpha2, alpha3, alpha4);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    private ObjectAnimator getTranslationYAnim(ImageView iv, long delay) {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(iv, "translationY", 0f, -20f, 0f, -10f);
        translationY.setStartDelay(delay);
        translationY.setDuration(1500);
//        translationY.setRepeatCount(ValueAnimator.INFINITE);
//        translationY.setRepeatMode(ValueAnimator.RESTART);
        return translationY;
    }

    private ObjectAnimator getAlphaAnim(ImageView iv, long delay) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(iv, "alpha", 0f, 1f, 0f);
        alpha.setStartDelay(delay);
        alpha.setDuration(1500);
//        alpha.setRepeatCount(ValueAnimator.INFINITE);
//        alpha.setRepeatMode(ValueAnimator.RESTART);
        return alpha;
    }
}
