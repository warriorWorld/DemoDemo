package com.insightsurfface.demodemo.business.state;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class StateActivity extends BaseActivity implements View.OnClickListener {
    private Button qBtn;
    private Button wBtn;
    private Button eBtn;
    private Button rBtn;
    private WeaponControllerImpl mWeaponController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeaponController = new WeaponControllerImpl(this);
        mWeaponController.turnCannon();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-29 16:00:29 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == qBtn) {
            // Handle clicks for qBtn
            mWeaponController.q();
        } else if (v == wBtn) {
            // Handle clicks for wBtn
            mWeaponController.w();
        } else if (v == eBtn) {
            // Handle clicks for eBtn
            mWeaponController.e();
        } else if (v == rBtn) {
            // Handle clicks for rBtn
            mWeaponController.transform();
        }
    }

    @Override
    protected void initUI() {
        qBtn = (Button) findViewById(R.id.q_btn);
        wBtn = (Button) findViewById(R.id.w_btn);
        eBtn = (Button) findViewById(R.id.e_btn);
        rBtn = (Button) findViewById(R.id.r_btn);

        qBtn.setOnClickListener(this);
        wBtn.setOnClickListener(this);
        eBtn.setOnClickListener(this);
        rBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_state;
    }
}
