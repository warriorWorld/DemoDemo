package com.insightsurfface.demodemo.business.visitor;

import java.util.Random;

public class Doctor extends Staff {
    public Doctor(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCuredNum() {
        return new Random().nextInt(200);
    }
}
