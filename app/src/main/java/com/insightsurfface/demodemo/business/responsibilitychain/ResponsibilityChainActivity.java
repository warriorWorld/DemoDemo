package com.insightsurfface.demodemo.business.responsibilitychain;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import java.util.Random;

import androidx.annotation.Nullable;

public class ResponsibilityChainActivity extends BaseActivity implements View.OnClickListener {
    private Button luckyDrawBtn;
    private FirstPrize firstPrize;
    private SecondPrize secondPrize;
    private ThirdPrize thirdPrize;
    private ConsolationPrize consolationPrize;
    private int result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstPrize = new FirstPrize(this);
        secondPrize = new SecondPrize(this);
        thirdPrize = new ThirdPrize(this);
        consolationPrize = new ConsolationPrize(this);
        consolationPrize.nextHandler = thirdPrize;
        thirdPrize.nextHandler = secondPrize;
        secondPrize.nextHandler = firstPrize;
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-30 14:10:33 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == luckyDrawBtn) {
            // Handle clicks for luckyDrawBtn
            Random random = new Random();
            result =random.nextInt(18);
            baseToast.showToast("成功打破" + result + "个气球");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            consolationPrize.handleReward(result);
                        }
                    });
                }
            }, 2000);
        }
    }

    @Override
    protected void initUI() {
        luckyDrawBtn = (Button) findViewById(R.id.lucky_draw_btn);

        luckyDrawBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chain;
    }
}
