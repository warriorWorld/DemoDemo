package com.insightsurfface.demodemo.business.touchevent;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.listener.TouchListener;

public class TouchEventActivity extends BaseActivity implements View.OnClickListener {
    private TouchLayout touchLayout;
    private TouchButton testBtn;
    private TextView logTv;
    private TouchScroll touchSv;
    private View cleanV;

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
        touchSv.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchSv   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchSv   onInterceptTouchEvent:  " + event.getAction());
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchSv   onTouchEvent:  " + event.getAction());
            }
        });
        touchLayout.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchLayout   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchLayout   onInterceptTouchEvent:  " + event.getAction());
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntouchLayout   onTouchEvent:  " + event.getAction());
            }
        });
        testBtn = findViewById(R.id.test_btn);
        testBtn.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntestBtn   dispatchTouchEvent:  " + event.getAction());
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\ntestBtn   onTouchEvent:  " + event.getAction());
            }
        });
//        testBtn.setOnClickListener(this);
        cleanV.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }
}
