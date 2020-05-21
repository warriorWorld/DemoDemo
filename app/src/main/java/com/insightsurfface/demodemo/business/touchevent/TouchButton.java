package com.insightsurfface.demodemo.business.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.utils.Logger;

public class TouchButton extends Button {
    private final String TAG = "最内层";
    private TouchListener mTouchListener;
    private boolean isDispatch, isHandleDownEvent;

    public TouchButton(Context context) {
        super(context);
    }

    public TouchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d(TAG + "  onTouchEvent:  " + event.getAction());
        if (null != mTouchListener) {
            mTouchListener.onTouchEvent(event);
        }
//        return super.onTouchEvent(event);
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

    public boolean isHandleDownEvent() {
        return isHandleDownEvent;
    }

    public void setHandleDownEvent(boolean handleDownEvent) {
        isHandleDownEvent = handleDownEvent;
    }
}
