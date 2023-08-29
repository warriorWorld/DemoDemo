package com.insightsurfface.demodemo.business.doodle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import java.util.Map;

/**
 * Created by chengyijun on 2019/8/14.
 */

public class DoodleViewDisposer extends AbsDisposer implements View.OnTouchListener {
    private static final String TAG = DoodleViewDisposer.class.getSimpleName();
    private DoodleView mDoodleView;
    private float mLastX, mLastY;
    private Map<String, String> mLayersMap;
    private String mLastColor;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initLayout(View layout) {
        super.initLayout(layout);
        if (layout instanceof DoodleView) {
            mDoodleView = (DoodleView) layout;
            mDoodleView.setOnTouchListener(this);
        }
    }

    @Override
    public void release() {
        Log.d(TAG, "release");
        if (mLayersMap != null) {
            mLayersMap.clear();
        }
        if (mDoodleView != null) {
            mDoodleView.release();
        }
    }

    public void initDoodleViewLayers(Map<String, String> layersMap) {
        mLayersMap = layersMap;
        mDoodleView.setAllLayerRes(mLayersMap.values().toArray(new String[mLayersMap.size()]));
    }

    /**
     * 获取当前涂鸦结果
     *
     * @return
     */
    public Bitmap getCurrentBitmap() {
        if (mDoodleView != null) {
            return mDoodleView.getCurrentBitmap();
        }
        return null;
    }

    /**
     * 清空涂鸦内容恢复初始状态
     */
    public void clearAll() {
        if (mDoodleView.isStartDrawing()) {
            mDoodleView.clearAll();
        }
    }

    /**
     * 是否选择使用橡皮擦
     *
     * @param enable
     */
    public void enableEraser(boolean enable) {
        if (enable) {
            notifyPaintColor("#FFFFFF");
        } else {
            notifyPaintColor(mLastColor);
        }
    }

    /**
     * 更新画笔颜色
     *
     * @param color
     */
    public void notifyPaintColor(String color) {
        if (!"#FFFFFF".equals(color)) {
            mLastColor = color;
        }
        mDoodleView.changePaintColor(color);
    }

    /**
     * 更新画笔大小
     *
     * @param size
     */
    public void notifyPaintSize(int size) {
        mDoodleView.changePaintSize(size);
    }

    /**
     * 选择单词->对应图层需要做处理
     *
     * @param word
     */
    public void clickWordToLayer(String word) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                mDoodleView.saveCurrentView(false);
                mDoodleView.changeDisposeLayer((int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mDoodleView.disposeDoodleInLayer(mLastX, mLastY, event.getX(), event.getY());
                mLastX = event.getX();
                mLastY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (mDoodleView.isStartDrawing()) {
                    mDoodleView.saveCurrentView(true);
                    mDoodleView.invalidate();
                }
                break;
        }
        return true;
    }

    public void setOnLayerClickListener(OnLayerClickListener listener) {
        if (mDoodleView != null) {
            mDoodleView.setOnLayerClickListener(listener);
        }
    }

    public void setOnDrawLayersListener(OnDrawLayersListener listener) {
        if (mDoodleView != null) {
            mDoodleView.setOnDrawLayersListener(listener);
        }
    }

    public boolean isStartDrawing() {
        return mDoodleView != null && mDoodleView.isStartDrawing();
    }
}
