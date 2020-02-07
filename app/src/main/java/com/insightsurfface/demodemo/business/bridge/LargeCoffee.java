package com.insightsurfface.demodemo.business.bridge;

public class LargeCoffee extends Coffee {
    public LargeCoffee(){
        super();
    }
    public LargeCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public String makeCoffee() {
        return "大杯的" + impl.addSomething() + "咖啡";
    }
}
