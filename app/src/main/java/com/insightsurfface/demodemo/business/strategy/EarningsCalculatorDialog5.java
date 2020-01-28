package com.insightsurfface.demodemo.business.strategy;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.widget.toast.EasyToast;


public class EarningsCalculatorDialog5 extends EarningsCalculatorDialog1 {
    private Context mContext;
    private Button oneOffBtn;
    private Button averageCapitalBtn;
    private RelativeLayout investPeriodRl, investPeriodRl1;
    private RepayType mRepayType = RepayType.ONE_OFF;
    private int selectedTerm = -1;
    private EditText investPeriodEt1;

    public EarningsCalculatorDialog5(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_earnings_calculator5;
    }

    @Override
    protected void init() {
        super.init();
        oneOffBtn = (Button) findViewById(R.id.one_off_btn);
        averageCapitalBtn = (Button) findViewById(R.id.average_capital_btn);
        investPeriodRl = (RelativeLayout) findViewById(R.id.invest_period_rl);
        investPeriodEt1 = (EditText) findViewById(R.id.invest_period_et1);
        investPeriodRl1 = (RelativeLayout) findViewById(R.id.invest_period_rl1);

        oneOffBtn.setOnClickListener(this);
        averageCapitalBtn.setOnClickListener(this);
        investPeriodRl.setOnClickListener(this);
    }

    @Override
    protected boolean checkData() {
        switch (mRepayType) {
            case AVERAGE_CAPITAL:
                EasyToast baseToast = new EasyToast(context);
                if (TextUtils.isEmpty(investMoneyEt.getText().toString())) {
                    baseToast.showToast("请输入出借金额");
                    return false;
                }
                if (TextUtils.isEmpty(interestRateEt.getText().toString())) {
                    baseToast.showToast("请输入协议约定利率");
                    return false;
                }
                return true;
            case ONE_OFF:
                return super.checkData();
            default:
                return false;
        }
    }

    private void toggleRepayType() {
        investPeriodRl.setVisibility(View.GONE);
        investPeriodRl1.setVisibility(View.GONE);
        oneOffBtn.setTextColor(mContext.getResources().getColor(R.color.main_text_color));
        averageCapitalBtn.setTextColor(mContext.getResources().getColor(R.color.main_text_color));
        oneOffBtn.setBackgroundResource(R.drawable.peanut_btn_bg_gray_round);
        averageCapitalBtn.setBackgroundResource(R.drawable.peanut_btn_bg_gray_round);
        switch (mRepayType) {
            case ONE_OFF:
                investPeriodRl1.setVisibility(View.VISIBLE);
                oneOffBtn.setTextColor(mContext.getResources().getColor(R.color.main_text_color_blue));
                oneOffBtn.setBackgroundResource(R.drawable.blue_round_empty_gray);
                break;
            case AVERAGE_CAPITAL:
                investPeriodRl.setVisibility(View.VISIBLE);
                averageCapitalBtn.setTextColor(mContext.getResources().getColor(R.color.main_text_color_blue));
                averageCapitalBtn.setBackgroundResource(R.drawable.blue_round_empty_gray);
                break;
        }
    }

    @Override
    protected void calculateEarning() {
        switch (mRepayType) {
            case ONE_OFF:
                super.calculateEarning();
                break;
            case AVERAGE_CAPITAL:
                float couponRate = 0f;
                if (!TextUtils.isEmpty(raiseInterestEt.getText().toString().trim())) {
                    couponRate = getEtFloat(raiseInterestEt);
                }
                selectedTerm = Integer.valueOf(investPeriodEt1.getText().toString());
                earning = (getEtFloat(investMoneyEt) * (selectedTerm + 1) / 2) * ((getEtFloat(interestRateEt) + couponRate) / 100f) * 30f / 365f;
                if (TextUtils.isEmpty(raiseInterestEt.getText().toString())) {
                    raiseInterestEt.setText("0.00");
                }
                break;
        }
    }

    @Override
    protected void reset() {
        super.reset();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-03-27 11:21:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == oneOffBtn) {
            mRepayType = RepayType.ONE_OFF;
            toggleRepayType();
            reset();
        } else if (v == averageCapitalBtn) {
            mRepayType = RepayType.AVERAGE_CAPITAL;
            toggleRepayType();
            reset();
        } else if (v == investPeriodRl) {
        }
    }
}
