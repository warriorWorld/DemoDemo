package com.insightsurfface.demodemo.business.abstractfactory;

import android.content.Context;

import com.insightsurfface.demodemo.business.factory.Circle;
import com.insightsurfface.demodemo.business.factory.Shape;
import com.insightsurfface.demodemo.business.factory.ShapeFactory;
import com.insightsurfface.demodemo.business.factory.Square;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(Context context, ColorType colorType) {
        switch (colorType) {
            case RED:
                return new Red(context);
            case GREEN:
                return new Green(context);
            default:
                return null;
        }
    }

    @Override
    public Shape getShape(Context context, ShapeFactory.ShapeType shapeType) {
        return null;
    }

    public enum ColorType {
        RED,
        GREEN,
    }
}
