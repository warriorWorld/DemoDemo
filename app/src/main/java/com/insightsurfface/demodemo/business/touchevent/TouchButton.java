package com.insightsurfface.demodemo.business.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.utils.Logger;

public class TouchButton extends Button {
    private TouchListener mTouchListener;

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
        Logger.d("TouchLayout  dispatchTouchEvent:  " + ev.getAction());
        if (null != mTouchListener) {
            mTouchListener.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("TouchButton  onTouchEvent:  " + event.getAction());
        if (null != mTouchListener) {
            mTouchListener.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public void setTouchListener(TouchListener touchListener) {
        mTouchListener = touchListener;
    }
}
