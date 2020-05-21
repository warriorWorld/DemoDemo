package com.insightsurfface.demodemo.widget.dialog;/**
 * Created by Administrator on 2016/11/4.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.business.touchevent.TouchViewModel;
import com.insightsurfface.demodemo.listener.OnDialogClickListener;


/**
 * 作者：苏航 on 2016/11/4 11:08
 * 邮箱：772192594@qq.com
 */
public class TouchSettingsDialog extends Dialog {
    private Context context;
    private CheckBox isDispatchCb0;
    private CheckBox isInterceptCb0;
    private CheckBox isHandleDownEventCb0;
    private CheckBox isDispatchCb1;
    private CheckBox isInterceptCb1;
    private CheckBox isHandleDownEventCb1;
    private CheckBox isDispatchCb2;
    private CheckBox isHandleDownEventCb2;
    private TouchViewModel mTouchViewModel;
    private OnDialogClickListener mOnDialogClickListener;

    public TouchSettingsDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        init();

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        WindowManager wm = ((Activity) context).getWindowManager();
        Display d = wm.getDefaultDisplay();
        // lp.height = (int) (d.getHeight() * 0.4);
        lp.width = (int) (d.getWidth() * 0.9);
        // window.setGravity(Gravity.LEFT | Gravity.TOP);
        window.setGravity(Gravity.CENTER);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        // lp.x = 100;
        // lp.y = 100;
        // lp.height = 30;
        // lp.width = 20;
        window.setAttributes(lp);
    }

    protected int getLayoutId() {
        return R.layout.dialog_touch;
    }

    private void init() {
        isDispatchCb0 = (CheckBox) findViewById(R.id.is_dispatch_cb0);
        isInterceptCb0 = (CheckBox) findViewById(R.id.is_intercept_cb0);
        isHandleDownEventCb0 = (CheckBox) findViewById(R.id.is_handleDownEvent_cb0);
        isDispatchCb1 = (CheckBox) findViewById(R.id.is_dispatch_cb1);
        isInterceptCb1 = (CheckBox) findViewById(R.id.is_intercept_cb1);
        isHandleDownEventCb1 = (CheckBox) findViewById(R.id.is_handleDownEvent_cb1);
        isDispatchCb2 = (CheckBox) findViewById(R.id.is_dispatch_cb2);
        isHandleDownEventCb2 = (CheckBox) findViewById(R.id.is_handleDownEvent_cb2);
        setupListener();
    }

    @Override
    public void show() {
        super.show();
    }

    private void setupListener() {
        isDispatchCb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsDispatch0(isChecked);
            }
        });
        isInterceptCb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsIntercept0(isChecked);
            }
        });
        isHandleDownEventCb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsHandleDownEvent0(isChecked);
            }
        });
        isDispatchCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsDispatch1(isChecked);
            }
        });
        isInterceptCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsIntercept1(isChecked);
            }
        });
        isHandleDownEventCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsHandleDownEvent1(isChecked);
            }
        });
        isDispatchCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsDispatch2(isChecked);
            }
        });
        isHandleDownEventCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTouchViewModel.setIsHandleDownEvent2(isChecked);
            }
        });
    }

    public void setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        mOnDialogClickListener = onDialogClickListener;
    }

    public void setTouchViewModel(TouchViewModel touchViewModel) {
        mTouchViewModel = touchViewModel;
    }
}
