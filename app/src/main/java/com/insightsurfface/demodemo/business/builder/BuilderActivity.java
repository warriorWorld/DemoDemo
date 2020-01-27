package com.insightsurfface.demodemo.business.builder;

import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

public class BuilderActivity extends BaseActivity implements View.OnClickListener {
    private Button dialogBtn;
    private Button dialogBtn1;
    private Button dialogBtn2;

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-27 14:48:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == dialogBtn) {
            // Handle clicks for dialogBtn
            new NormalDialogBuilder(this).setTitle("第一种").setMessage("内容\n换行").
                    setCancelText("否").setOkText("确定").create().show();
        } else if (v == dialogBtn1) {
            // Handle clicks for dialogBtn1
            new NormalDialogBuilder(this).setTitle("第二种").setMessage("内容\n换行").
                    setCancelText("取消").setOkText("确定").setTitleSize(30).setTitleBold(true).
                    setOnDialogClickListener(new NormalDialog.OnDialogClickListener() {
                        @Override
                        public void onOkClick() {
                            baseToast.showToast("确定");
                        }

                        @Override
                        public void onCancelClick() {
                            baseToast.showToast("取消");
                        }
                    }).create().show();
        } else if (v == dialogBtn2) {
            // Handle clicks for dialogBtn2
            new NormalDialogBuilder(this).setTitle("第三种").setMessage("内容不换行").setOkText("确定").setMessageSize(30).create().show();
        }
    }

    @Override
    protected void initUI() {
        dialogBtn = (Button) findViewById(R.id.dialog_btn);
        dialogBtn1 = (Button) findViewById(R.id.dialog_btn1);
        dialogBtn2 = (Button) findViewById(R.id.dialog_btn2);

        dialogBtn.setOnClickListener(this);
        dialogBtn1.setOnClickListener(this);
        dialogBtn2.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_builder;
    }
}
