package com.insightsurfface.demodemo.business.fragmentlife;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentTransaction;

public class FragmentLifePeriodActivity extends BaseActivity implements View.OnClickListener {
    private LifePeriodFragment mFragment, mFragment1;
    /**
     * 当前选中页
     */
    private BaseFragment curFragment;
    private View mainV, userV;
    private ImageView mainIv, userIv;
    private TextView homepageBottomTv;
    private TextView userBottomTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragment = new LifePeriodFragment("壹");
        mFragment1 = new LifePeriodFragment("贰");
        switchContent(null, mFragment);
    }


    @Override
    protected void initUI() {
        mainV = findViewById(R.id.homepage_bottom_ll);
        userV = findViewById(R.id.user_bottom_ll);
        mainIv = (ImageView) findViewById(R.id.homepage_bottom_iv);
        userIv = (ImageView) findViewById(R.id.user_bottom_iv);
        homepageBottomTv = (TextView) findViewById(R.id.homepage_bottom_tv);
        userBottomTv = (TextView) findViewById(R.id.user_bottom_tv);
        mainV.setOnClickListener(this);
        userV.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_life_period;
    }

    public void switchContent(BaseFragment from, BaseFragment to) {
        if (curFragment != to) {
            curFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                if (null != from) {
                    transaction.hide(from);
                }
                transaction.add(R.id.container, to, to.getFragmentTag())
                        .addToBackStack(to.getTag()).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                if (null != from) {
                    transaction.hide(from);
                }
                transaction.show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
//        to.onHiddenChanged(false);
        toggleBottomBar(to);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void toggleBottomBar(BaseFragment bf) {
        userBottomTv.setTextColor(getResources().getColor(R.color.main_text_color_gray));
        homepageBottomTv.setTextColor(getResources().getColor(R.color.main_text_color_gray));
        if (bf.equals(mFragment)) {
            homepageBottomTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else if (bf instanceof LifePeriodFragment) {
            userBottomTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homepage_bottom_ll:
                switchContent(curFragment, mFragment);
                break;
            case R.id.user_bottom_ll:
                switchContent(curFragment, mFragment1);
                break;
        }
    }
}
