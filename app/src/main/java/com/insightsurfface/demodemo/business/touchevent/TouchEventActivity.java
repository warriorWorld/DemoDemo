package com.insightsurfface.demodemo.business.touchevent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.listener.TouchListener;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class TouchEventActivity extends BaseActivity implements View.OnClickListener {
    private TouchLayout touchLayout;
    private TouchButton testBtn;
    private TextView logTv;
    private TouchRl touchSv;
    private View cleanV;
    private TextView stateTv;
    private TouchViewModel mTouchViewModel;

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
        } else if (v == cleanV) {
            logTv.setText("");
        }
    }

    @Override
    protected void initUI() {
        touchLayout = (TouchLayout) findViewById(R.id.touch_layout);
        logTv = findViewById(R.id.log_tv);
        touchSv = findViewById(R.id.touch_sv);
        cleanV = findViewById(R.id.clean_iv);
        stateTv = findViewById(R.id.state_tv);
        touchSv.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n最底层   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n最底层   onInterceptTouchEvent:  " + event.getAction());
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n最底层   onTouchEvent:  " + event.getAction());
            }
        });
        touchLayout.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层   onInterceptTouchEvent:  " + event.getAction());
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层   onTouchEvent:  " + event.getAction());
            }
        });
        testBtn = findViewById(R.id.test_btn);
        testBtn.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n最下层   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n最下层   onTouchEvent:  " + event.getAction());
            }
        });
//        testBtn.setOnClickListener(this);
        cleanV.setOnClickListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVM();
    }

    private void initVM() {
        mTouchViewModel = ViewModelProviders.of(this).get(TouchViewModel.class);
        mTouchViewModel.getIsDispatch0().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsDispatch1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsDispatch2().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsIntercept0().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsIntercept1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsHandleDownEvent0().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsHandleDownEvent1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
        mTouchViewModel.getIsHandleDownEvent2().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });
    }

    private void refreshState() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }
}
