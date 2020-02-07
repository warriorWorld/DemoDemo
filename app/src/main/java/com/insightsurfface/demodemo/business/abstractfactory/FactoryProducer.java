package com.insightsurfface.demodemo.business.abstractfactory;

import com.insightsurfface.demodemo.business.factory.ShapeFactory;

public class FactoryProducer {
    public enum FactoryType {
        COLOR_FACTORY,
        SHAPE_FACTORY,
    }

    public static AbstractFactory getFactory(FactoryType factoryType) {
        switch (factoryType) {
            case COLOR_FACTORY:
                return new ColorFactory();
            case SHAPE_FACTORY:
                return new ShapeFactory();
            default:
                return null;
        }
    }
}
