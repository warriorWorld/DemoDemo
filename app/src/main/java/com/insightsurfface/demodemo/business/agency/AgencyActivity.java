package com.insightsurfface.demodemo.business.agency;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class AgencyActivity extends BaseActivity implements View.OnClickListener {
    private Button leopardBtn;
    private Button viBtn;
    private GameControl mGameControl;
    private Leopard mLeopard;
    private Vi mVi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameControl = new GameControl(mLeopard);
        mLeopard = new Leopard(this);
        mVi = new Vi(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-03 15:17:07 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == leopardBtn) {
            // Handle clicks for leopardBtn
            mGameControl.setSkill(mLeopard);
            mGameControl.r();
        } else if (v == viBtn) {
            // Handle clicks for viBtn
            mGameControl.setSkill(mVi);
            mGameControl.r();
        }
    }

    @Override
    protected void initUI() {
        leopardBtn = (Button) findViewById(R.id.leopard_btn);
        viBtn = (Button) findViewById(R.id.vi_btn);

        leopardBtn.setOnClickListener(this);
        viBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_agency;
    }
}
