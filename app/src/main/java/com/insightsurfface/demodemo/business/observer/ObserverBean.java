package com.insightsurfface.demodemo.business.observer;

import android.widget.EditText;

public class ObserverBean {
    private EditText observerEt;
    private double num;

    public EditText getObserverEt() {
        return observerEt;
    }

    public void setObserverEt(EditText observerEt) {
        this.observerEt = observerEt;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
