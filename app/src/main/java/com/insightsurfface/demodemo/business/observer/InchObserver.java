package com.insightsurfface.demodemo.business.observer;

import android.widget.EditText;

import com.insightsurfface.demodemo.utils.NumberUtil;

import java.util.Observable;
import java.util.Observer;

public class InchObserver implements Observer {
    private EditText mEditText;
    public double multiple = 25.4d;

    public InchObserver(EditText editText) {
        this.mEditText = editText;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((ObserverBean) arg).getObserverEt() == mEditText) {
            return;
        }
        mEditText.setText(NumberUtil.cutNum(((ObserverBean) arg).getNum() / multiple));
    }
}
