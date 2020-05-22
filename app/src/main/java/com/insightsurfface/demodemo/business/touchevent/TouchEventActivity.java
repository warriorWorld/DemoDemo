package com.insightsurfface.demodemo.business.touchevent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.listener.OnDialogClickListener;
import com.insightsurfface.demodemo.listener.TouchListener;
import com.insightsurfface.demodemo.widget.dialog.TouchSettingsDialog;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
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
    private TouchSettingsDialog mSettingsDialog;
    private boolean isHandleTouchEvent;

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-27 19:44:36 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == stateTv) {
            showSettingsDialog();
        } else if (v == cleanV) {
            logTv.setText("");
        }
    }

    private void showSettingsDialog() {
        if (null == mSettingsDialog) {
            mSettingsDialog = new TouchSettingsDialog(this);
            mSettingsDialog.setTouchViewModel(mTouchViewModel);
        }
        mSettingsDialog.show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        logTv.setText(logTv.getText() + "\nActivity:   dispatchTouchEvent:  " + action2String(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        logTv.setText(logTv.getText() + "\nActivity:   onTouchEvent:  " + action2String(event.getAction()));
        return isHandleTouchEvent;
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
                logTv.setText(logTv.getText() + "\n底层GROUP:   dispatchTouchEvent:  " + action2String(event.getAction()));
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n底层GROUP:   onInterceptTouchEvent:  " + action2String(event.getAction()));
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n底层GROUP:   onTouchEvent:  " + action2String(event.getAction()));
            }
        });
        touchLayout.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层GROUP:   dispatchTouchEvent:  " + action2String(event.getAction()));
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层GROUP:   onInterceptTouchEvent:  " + action2String(event.getAction()));
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\n中层GROUP:   onTouchEvent:  " + action2String(event.getAction()));
            }
        });
        testBtn = findViewById(R.id.test_btn);
        testBtn.setTouchListener(new TouchListener() {
            @Override
            public void dispatchTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\nView:   dispatchTouchEvent:  " + action2String(event.getAction()));
            }

            @Override
            public void onInterceptTouchEvent(MotionEvent event) {
            }

            @Override
            public void onTouchEvent(MotionEvent event) {
                logTv.setText(logTv.getText() + "\nView:   onTouchEvent:  " + action2String(event.getAction()));
            }
        });
//        testBtn.setOnClickListener(this);
        cleanV.setOnClickListener(this);
        stateTv.setOnClickListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVM();
        mTouchViewModel.init();
    }

    private void initVM() {
        mTouchViewModel = ViewModelProviders.of(this).get(TouchViewModel.class);
//        mTouchViewModel.getIsDispatch0().observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                touchSv.setDispatch(aBoolean);
//                refreshState();
//            }
//        });
//        mTouchViewModel.getIsDispatch1().observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                touchLayout.setDispatch(aBoolean);
//                refreshState();
//            }
//        });
//        mTouchViewModel.getIsDispatch2().observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                testBtn.setDispatch(aBoolean);
//                refreshState();
//            }
//        });
        mTouchViewModel.getIsIntercept0().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                touchSv.setIntercept(aBoolean);
                refreshState();
            }
        });
        mTouchViewModel.getIsIntercept1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                touchLayout.setIntercept(aBoolean);
                refreshState();
            }
        });
        mTouchViewModel.getIsHandleDownEvent0().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                touchSv.setHandleDownEvent(aBoolean);
                refreshState();
            }
        });
        mTouchViewModel.getIsHandleDownEvent1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                touchLayout.setHandleDownEvent(aBoolean);
                refreshState();
            }
        });
        mTouchViewModel.getIsHandleDownEvent2().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                testBtn.setHandleDownEvent(aBoolean);
                refreshState();
            }
        });
        mTouchViewModel.getIsHandleDownEvent3().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                isHandleTouchEvent = aBoolean;
                refreshState();
            }
        });
    }

    private String action2String(int action) {
        switch (action) {
            case 0:
                return "ACTION_DOWN";
            case 1:
                return "ACTION_UP";
            case 2:
                return "ACTION_MOVE";
            case 3:
                return "ACTION_CANCEL";
            case 4:
                return "ACTION_OUTSIDE";
            case 5:
                return "ACTION_POINTER_DOWN";
            case 6:
                return "ACTION_POINTER_UP";
            case 7:
                return "ACTION_HOVER_MOVE";
            case 8:
                return "ACTION_SCROLL";
            case 9:
                return "ACTION_HOVER_ENTER";
            case 10:
                return "ACTION_HOVER_EXIT";
            case 11:
                return "ACTION_BUTTON_PRESS";
            case 12:
                return "ACTION_BUTTON_RELEASE";
            default:
                return action + "";
        }
    }

    private void refreshState() {
        String result =
//                "最底层 isDispatch: " + boolean2String(mTouchViewModel.getIsDispatch0()) + "\n" +
                "ACTIVITY isHandleDownEvent: " + isHandleTouchEvent + "\n" +
                        "最底层 isIntercept: " + boolean2String(mTouchViewModel.getIsIntercept0()) + "\n" +
                        "最底层 isHandleDownEvent: " + boolean2String(mTouchViewModel.getIsHandleDownEvent0()) + "\n" +
//                        "中层 isDispatch: " + boolean2String(mTouchViewModel.getIsDispatch1()) + "\n" +
                        "中层 isIntercept: " + boolean2String(mTouchViewModel.getIsIntercept1()) + "\n" +
                        "中层 isHandleDownEvent: " + boolean2String(mTouchViewModel.getIsHandleDownEvent1()) + "\n" +
//                        "最顶层 isDispatch: " + boolean2String(mTouchViewModel.getIsDispatch2()) + "\n" +
                        "最顶层 isHandleDownEvent: " + boolean2String(mTouchViewModel.getIsHandleDownEvent2());
        stateTv.setText(result);
    }

    private String boolean2String(LiveData<Boolean> ld) {
        return ld.getValue().toString();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }
}
