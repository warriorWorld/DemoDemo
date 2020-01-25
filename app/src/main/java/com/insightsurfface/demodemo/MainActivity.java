package com.insightsurfface.demodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.insightsurfface.demodemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
