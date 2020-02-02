package com.insightsurfface.demodemo.business.visitor;

import java.util.Random;

public class Fighter extends Staff {
    public Fighter(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getKilledNum() {
        return new Random().nextInt(200);
    }
}
