package com.insightsurfface.demodemo.business.strategy;

public class EarningCalculator {
    private CalculateStrategy mStrategy;

    public double calculate(double investAmount, int period, double rate) {
        return mStrategy.calculate(investAmount, period, rate);
    }

    public void setStrategy(CalculateStrategy strategy) {
        mStrategy = strategy;
    }
}
