package com.insightsurfface.demodemo.business.touchevent;

import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

public class TouchEventActivity extends BaseActivity implements View.OnClickListener {
    private TouchLayout touchLayout;
    private Button testBtn;

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-27 19:44:36 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == testBtn) {
            // Handle clicks for testBtn
        }
    }

    @Override
    protected void initUI() {
        touchLayout = (TouchLayout) findViewById(R.id.touch_layout);
        testBtn = (Button) findViewById(R.id.test_btn);

        testBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }
}
