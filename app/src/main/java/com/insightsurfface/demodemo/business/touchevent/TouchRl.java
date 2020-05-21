package com.insightsurfface.demodemo.business.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.utils.Logger;

public class TouchRl extends RelativeLayout {
    private final String TAG = "最外层";
    private TouchListener mTouchListener;
    private boolean isDispatch, isIntercept, isHandleDownEvent;

    public TouchRl(Context context) {
        super(context);
    }

    public TouchRl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchRl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d(TAG + "  dispatchTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.dispatchTouchEvent(ev);
        }
        return isDispatch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d(TAG + "  onInterceptTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.onInterceptTouchEvent(ev);
        }
        return isIntercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d(TAG + "  onTouchEvent:  " + event.getAction());
        if (null != mTouchListener) {
            mTouchListener.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return isHandleDownEvent;
            case MotionEvent.ACTION_MOVE:
                return false;
            case MotionEvent.ACTION_UP:
                return false;
            default:
                return true;
        }
    }

    public void setTouchListener(TouchListener touchListener) {
        mTouchListener = touchListener;
    }

    public boolean isDispatch() {
        return isDispatch;
    }

    public void setDispatch(boolean dispatch) {
        isDispatch = dispatch;
    }

    public boolean isIntercept() {
        return isIntercept;
    }

    public void setIntercept(boolean intercept) {
        isIntercept = intercept;
    }

    public boolean isHandleDownEvent() {
        return isHandleDownEvent;
    }

    public void setHandleDownEvent(boolean handleDownEvent) {
        isHandleDownEvent = handleDownEvent;
    }
}
