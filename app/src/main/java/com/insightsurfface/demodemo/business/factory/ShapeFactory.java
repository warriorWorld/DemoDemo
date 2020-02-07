package com.insightsurfface.demodemo.business.factory;

import android.content.Context;

import com.insightsurfface.demodemo.business.abstractfactory.AbstractFactory;
import com.insightsurfface.demodemo.business.abstractfactory.Color;
import com.insightsurfface.demodemo.business.abstractfactory.ColorFactory;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(Context context, ColorFactory.ColorType colorType) {
        return null;
    }

    @Override
    public Shape getShape(Context context, ShapeType shapeType) {
        switch (shapeType) {
            case SQUARE:
                return new Square(context);
            case CIRCLE:
                return new Circle(context);
            default:
                return null;
        }
    }

    public enum ShapeType {
        CIRCLE,
        SQUARE,
    }
}
