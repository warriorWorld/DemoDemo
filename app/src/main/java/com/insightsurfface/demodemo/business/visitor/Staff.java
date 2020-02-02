package com.insightsurfface.demodemo.business.visitor;

import java.util.Random;

public abstract class Staff {
    public String name;
    public int appearanceLevel;

    public Staff(String name) {
        this.name = name;
        appearanceLevel = new Random().nextInt(500);
    }

    public abstract void accept(Visitor visitor);
}
