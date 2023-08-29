package com.insightsurfface.demodemo.business.test;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;


import androidx.annotation.Nullable;

/**
 * Created by acorn on 2020/7/11.
 */
public class TestActivity1 extends BaseActivity {
    private static String TAG = "TestActivity1";
    private TextView default_prompt;
    private ImageView waiting_iv;
    private boolean ret;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        default_prompt.setText(ret + "");
    }

    @Override
    protected void initUI() {
        default_prompt = findViewById(R.id.default_prompt);
        waiting_iv = findViewById(R.id.waiting_iv);
    }


    public static String getExtractCmd(String archivePath, String outPath) {
        return String.format("7z x '%s' '-o%s' -aoa", archivePath, outPath);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waiting;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
