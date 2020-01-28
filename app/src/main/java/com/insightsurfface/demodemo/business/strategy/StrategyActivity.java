package com.insightsurfface.demodemo.business.strategy;

import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

public class StrategyActivity extends BaseActivity implements View.OnClickListener {
    private Button strategyBtn;

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-28 15:37:27 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == strategyBtn) {
            // Handle clicks for strategyBtn
            EarningsCalculatorDialog5 dialog5=new EarningsCalculatorDialog5(this);
            dialog5.show();
        }
    }

    @Override
    protected void initUI() {
        strategyBtn = (Button) findViewById(R.id.strategy_btn);

        strategyBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_strategy;
    }
}
