package com.insightsurfface.demodemo.business.bridge;

public class VeryLargeCoffee extends Coffee {
    public VeryLargeCoffee() {
        super();
    }

    public VeryLargeCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public String makeCoffee() {
        return "特大杯的" + impl.addSomething() + "咖啡";
    }
}
