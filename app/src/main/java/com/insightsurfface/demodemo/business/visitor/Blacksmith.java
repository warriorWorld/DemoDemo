package com.insightsurfface.demodemo.business.visitor;

import java.util.Random;

public class Blacksmith extends Staff {
    public Blacksmith(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getForgedWeapon() {
        return new Random().nextInt(50);
    }
}
