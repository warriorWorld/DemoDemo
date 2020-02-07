package com.insightsurfface.demodemo.business.bridge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class BridgeActivity extends BaseActivity implements View.OnClickListener {
    private Button bigCupBtn;
    private Button veryBigCupBtn;
    private Button addSugarBtn;
    private Button noSugarBtn;
    private TextView resultTv;
    private LargeCoffee mLargeCoffee;
    private VeryLargeCoffee mVeryLargeCoffee;
    private Sugar mSugar;
    private Original mOriginal;
    private Coffee mCoffee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLargeCoffee = new LargeCoffee();
        mVeryLargeCoffee = new VeryLargeCoffee();
        mSugar = new Sugar();
        mOriginal = new Original();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-07 11:14:56 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == bigCupBtn) {
            // Handle clicks for bigCupBtn
            mCoffee = mLargeCoffee;
        } else if (v == veryBigCupBtn) {
            // Handle clicks for veryBigCupBtn
            mCoffee = mVeryLargeCoffee;
        } else if (v == addSugarBtn) {
            // Handle clicks for addSugarBtn
            mCoffee.setImpl(mSugar);
            resultTv.setText(mCoffee.makeCoffee());
        } else if (v == noSugarBtn) {
            // Handle clicks for noSugarBtn
            mCoffee.setImpl(mOriginal);
            resultTv.setText(mCoffee.makeCoffee());
        }
    }

    @Override
    protected void initUI() {
        bigCupBtn = (Button) findViewById(R.id.big_cup_btn);
        veryBigCupBtn = (Button) findViewById(R.id.very_big_cup_btn);
        addSugarBtn = (Button) findViewById(R.id.add_sugar_btn);
        noSugarBtn = (Button) findViewById(R.id.no_sugar_btn);
        resultTv = (TextView) findViewById(R.id.result_tv);

        bigCupBtn.setOnClickListener(this);
        veryBigCupBtn.setOnClickListener(this);
        addSugarBtn.setOnClickListener(this);
        noSugarBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bridge;
    }
}
