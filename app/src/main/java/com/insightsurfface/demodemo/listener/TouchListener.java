package com.insightsurfface.demodemo.listener;

import android.view.MotionEvent;

public interface TouchListener {
    void dispatchTouchEvent(MotionEvent event);

    void onInterceptTouchEvent(MotionEvent event);

    void onTouchEvent(MotionEvent event);
}
