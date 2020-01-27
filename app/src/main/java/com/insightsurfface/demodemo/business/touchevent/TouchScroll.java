package com.insightsurfface.demodemo.business.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.utils.Logger;

public class TouchScroll extends ScrollView {
    private TouchListener mTouchListener;

    public TouchScroll(Context context) {
        super(context);
    }

    public TouchScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d("TouchScroll  dispatchTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d("TouchScroll  onInterceptTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.onInterceptTouchEvent(ev);
        }
//        return super.onInterceptTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("TouchScroll  onTouchEvent:  " + event.getAction());
        if (null != mTouchListener) {
            mTouchListener.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public void setTouchListener(TouchListener touchListener) {
        mTouchListener = touchListener;
    }
}
