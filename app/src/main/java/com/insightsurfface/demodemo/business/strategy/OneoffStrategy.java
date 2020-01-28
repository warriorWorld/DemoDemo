package com.insightsurfface.demodemo.business.strategy;

import android.text.TextUtils;

public class OneoffStrategy implements CalculateStrategy {

    @Override
    public double calculate(double investAmount, int period, double rate) {
        return investAmount * period * rate / 365 / 100;
    }
}
