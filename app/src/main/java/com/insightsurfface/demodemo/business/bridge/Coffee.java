package com.insightsurfface.demodemo.business.bridge;

public abstract class Coffee {
    protected CoffeeAdditives impl;

    public Coffee() {
    }

    public Coffee(CoffeeAdditives impl) {
        this.impl = impl;
    }

    public void setImpl(CoffeeAdditives impl) {
        this.impl = impl;
    }

    public abstract String makeCoffee();
}
