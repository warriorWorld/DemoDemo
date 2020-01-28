package com.insightsurfface.demodemo.business.strategy;

import android.text.TextUtils;

public class AverageCapitalStrategy implements CalculateStrategy {
    @Override
    public double calculate(double investAmount, int period, double rate) {
        return (investAmount * (period + 1) / 2) * (rate / 100f) * 30f / 365f;
    }
}
