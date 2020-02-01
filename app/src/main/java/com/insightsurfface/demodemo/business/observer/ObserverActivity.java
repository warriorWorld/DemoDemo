package com.insightsurfface.demodemo.business.observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class ObserverActivity extends BaseActivity {
    private EditText meterEt;
    private EditText feetEt;
    private EditText inchEt;
    private NumberObservable mNumberObservable;
    private FeetObserver mFeetObserver;
    private InchObserver mInchObserver;
    private MeterObserver mMeterObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumberObservable = new NumberObservable();
        mFeetObserver = new FeetObserver(feetEt);
        mInchObserver = new InchObserver(inchEt);
        mMeterObserver = new MeterObserver(meterEt);
        mNumberObservable.addObserver(mFeetObserver);
        mNumberObservable.addObserver(mInchObserver);
        mNumberObservable.addObserver(mMeterObserver);
    }

    @Override
    protected void initUI() {
        meterEt = (EditText) findViewById(R.id.meter_et);
        meterEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    return;
                }
                if (!meterEt.isFocused()){
                    return;
                }
                ObserverBean item=new ObserverBean();
                item.setNum(Double.valueOf(s.toString()) * 1000d);
                item.setObserverEt(meterEt);
                mNumberObservable.numberChanged(item);
            }
        });
        feetEt = (EditText) findViewById(R.id.feet_et);
        feetEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    return;
                }
                if (!feetEt.isFocused()){
                    return;
                }
                ObserverBean item=new ObserverBean();
                item.setNum(Double.valueOf(s.toString()) * 304.8d);
                item.setObserverEt(feetEt);
                mNumberObservable.numberChanged(item);
            }
        });
        inchEt = (EditText) findViewById(R.id.inch_et);
        inchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    return;
                }
                if (!inchEt.isFocused()){
                    return;
                }
                ObserverBean item=new ObserverBean();
                item.setNum(Double.valueOf(s.toString()) * 25.4d);
                item.setObserverEt(inchEt);
                mNumberObservable.numberChanged(item);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_observer;
    }
}
