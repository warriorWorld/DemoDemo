package com.insightsurfface.demodemo.business.doodle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import com.insightsurfface.demodemo.R;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

/**
 * Created by chengyijun on 2019/7/8.
 */

public class DoodleView extends View {
    private Context mContext;
    private static final String TAG = DoodleView.class.getSimpleName();
    private Canvas mCanvas;
    private Paint mPaint;
    private String[] mAllLayerRes;
    private Bitmap mCurrentOriginalBitmap;
    private Bitmap mCurrentDoodleBitmap;
    private PorterDuffXfermode mDuffXMode;
    private boolean isInit = false;
    private boolean isClear = false;
    private Canvas mKeepCanvas;
    private Bitmap mKeepBitmap;
    private BitmapFactory.Options options;
    private Matrix matrix;
    private String mLastRes = "";
    private Map<Bitmap, String> mLayersBitmapMap = new HashMap<>();//如果图片过多不建议使用该方式
    private boolean mIsSave = false;
    private OnLayerClickListener mLayerClickListener;
    private OnDrawLayersListener mDrawLayersListener;
    private boolean isStartDrawing = false;

    public DoodleView(Context context) {
        this(context, null);
    }

    public DoodleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setDrawingCacheEnabled(true);
        createPaint();
        isClear = false;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAllLayerRes != null) {
            if (getDrawingCache() == null || !isInit) {
                Log.d(TAG, "drawing cache is null!");
                isInit = true;
                drawAllLayer(mAllLayerRes, canvas);
            } else if (isClear) {
                clearAllLayers(canvas);
            } else {
                if (mKeepBitmap != null) {
                    mPaint.setXfermode(null);
                    canvas.drawBitmap(mKeepBitmap, 0, 0, mPaint);
                }
            }

            if (!mIsSave && mCurrentOriginalBitmap != null && mCurrentDoodleBitmap != null && mKeepCanvas != null) {
                int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
                int keepSc = mKeepCanvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
                canvas.drawBitmap(mCurrentOriginalBitmap, 0, 0, mPaint);
                mKeepCanvas.drawBitmap(mCurrentOriginalBitmap, 0, 0, mPaint);
                mPaint.setXfermode(mDuffXMode);
                canvas.drawBitmap(mCurrentDoodleBitmap, 0, 0, mPaint);
                mKeepCanvas.drawBitmap(mCurrentDoodleBitmap, 0, 0, mPaint);
                mPaint.setXfermode(null);
                canvas.restoreToCount(sc);
                mKeepCanvas.restoreToCount(keepSc);
            }
        }
    }

    private void initKeepBitmap(Bitmap bitmap) {
        if (mKeepCanvas == null) {
            if (mKeepBitmap == null) {
                mKeepBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            }
            mKeepCanvas = new Canvas(mKeepBitmap);
        }

        mKeepCanvas.drawBitmap(bitmap, 0, 0, null);
    }

    public void setAllLayerRes(String[] layerRes) {
        mLayersBitmapMap.clear();
        mAllLayerRes = layerRes;
        isStartDrawing = false;
        invalidate();
    }

    private void drawAllLayer(String[] layerRes, Canvas canvas) {
        if (layerRes == null || layerRes.length < 1) {
            mDrawLayersListener.onDrawCompleted();
            return;
        }

        for (String res : layerRes) {
            Bitmap compressBitmap;
            try {
                compressBitmap = getScaleBitmap(getWidth(), getHeight(), res);
            } catch (Exception e) {
                compressBitmap = null;
            }

            if (compressBitmap != null) {
                mLayersBitmapMap.put(compressBitmap, res);
                canvas.drawBitmap(compressBitmap, 0, 0, null);
                initKeepBitmap(compressBitmap);
            }
        }
        mDrawLayersListener.onDrawCompleted();
    }

    public void changeDisposeLayer(int x, int y) {
        isClear = false;

        if (mAllLayerRes == null || mAllLayerRes.length < 1) {
            return;
        }
        mCurrentOriginalBitmap = null;
        mCurrentDoodleBitmap = null;

        if (checkTouchLayer(x, y)) {
            isStartDrawing = true;
            if (mCanvas == null) {
                mCanvas = new Canvas();
            }
            mCanvas.setBitmap(mCurrentDoodleBitmap);

            invalidate();
        }
    }

    public boolean isStartDrawing() {
        return isStartDrawing;
    }

    private boolean checkTouchLayer(int x, int y) {
        if (mLayersBitmapMap.size() <= 0) {
            return false;
        }

        for (Bitmap bitmap : mLayersBitmapMap.keySet()) {
            try {
                int pixel = bitmap.getPixel(x, y);
                if (pixel == Color.WHITE) {//获取首个有内容Layer
                    mLastRes = mLayersBitmapMap.get(bitmap);
                    mCurrentOriginalBitmap = bitmap;
                    mCurrentDoodleBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    Log.d(TAG, "current res : " + mLastRes);
                    if (mLayerClickListener != null) {
                        mLayerClickListener.onLayerClick(mLastRes);
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }

    public void disposeDoodleInLayer(float lastX, float lastY, float x, float y) {
        if (mAllLayerRes == null || mAllLayerRes.length < 1 || mCurrentOriginalBitmap == null) {
            return;
        }

        if (mCanvas != null) {
            mCanvas.drawLine(lastX, lastY, x, y, mPaint);
        }

        invalidate();
    }

    private Bitmap getScaleBitmap(int width, int height, String res) {
        if (options == null) {
            options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(res, options);
        float scaleWidth = (float) width / bitmap.getWidth();
        float scaleHeight = (float) height / bitmap.getHeight();
        if (matrix == null) {
            matrix = new Matrix();
            matrix.postScale(0.8f, 0.8f);
        }
        Bitmap scaleBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return scaleBitmap;
    }

    private void createPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth((float) 50.0);

        mDuffXMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public void changePaintColor(String color) {
        if (mPaint != null && !TextUtils.isEmpty(color)) {
            mPaint.setColor(Color.parseColor(color));
        }
    }

    public void changePaintSize(int size) {
        if (mPaint != null) {
            mPaint.setStrokeWidth(size);
        }
    }

    public void saveCurrentView(boolean isSave) {
        mIsSave = isSave;
    }

    public void setOnLayerClickListener(OnLayerClickListener listener) {
        mLayerClickListener = listener;
    }

    public void clearAll() {
        mCurrentOriginalBitmap = null;
        mCurrentDoodleBitmap = null;

        isClear = true;
        invalidate();
    }

    private void clearAllLayers(Canvas canvas) {
        if (canvas != null && mLayersBitmapMap.size() > 0) {
            for (Bitmap bitmap : mLayersBitmapMap.keySet()) {
                canvas.drawBitmap(bitmap, 0, 0, null);
                initKeepBitmap(bitmap);
            }
        }
    }

    public Bitmap getCurrentBitmap() {
        if (mKeepBitmap == null || !isStartDrawing) {
            return null;
        }
        Bitmap submitBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(submitBitmap);
        canvas.drawColor(mContext.getResources().getColor(R.color.doodle_layout_background));
        canvas.drawBitmap(mKeepBitmap, 0, 0, null);

        return submitBitmap;
    }

    public void setOnDrawLayersListener(OnDrawLayersListener listener) {
        mDrawLayersListener = listener;
    }

    public void release() {
        Log.d(TAG, "release");
        if (mKeepBitmap != null) {
            mKeepBitmap.recycle();
            mKeepBitmap = null;
        }
        if (mCurrentOriginalBitmap != null) {
            mCurrentOriginalBitmap.recycle();
            mCurrentOriginalBitmap = null;
        }
        if (mCurrentDoodleBitmap != null) {
            mCurrentDoodleBitmap.recycle();
            mCurrentDoodleBitmap = null;
        }
        if (mLayersBitmapMap != null) {
            mLayersBitmapMap.clear();
        }
    }
}
