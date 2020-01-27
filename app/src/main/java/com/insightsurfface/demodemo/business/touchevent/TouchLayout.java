package com.insightsurfface.demodemo.business.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.utils.Logger;

public class TouchLayout extends LinearLayout {
    private TouchListener mTouchListener;

    public TouchLayout(Context context) {
        super(context);
    }

    public TouchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d("TouchLayout  dispatchTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d("TouchLayout  onInterceptTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.onInterceptTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("TouchLayout  onTouchEvent:  " + event.getAction());
        if (null != mTouchListener) {
            mTouchListener.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public void setTouchListener(TouchListener touchListener) {
        mTouchListener = touchListener;
    }
}
