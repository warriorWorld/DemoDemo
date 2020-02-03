package com.insightsurfface.demodemo.business.observer;

import android.widget.EditText;

import java.util.Observable;
import java.util.Observer;

public class FeetObserver implements Observer {
    private EditText mEditText;
    public double multiple = 304.8d;

    public FeetObserver(EditText editText) {
        this.mEditText = editText;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((ObserverBean) arg).getObserverEt() == mEditText) {
            return;
        }
        mEditText.setText((((ObserverBean) arg).getNum() / multiple) + "");
    }
}
