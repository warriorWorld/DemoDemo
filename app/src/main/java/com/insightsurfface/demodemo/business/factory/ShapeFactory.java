package com.insightsurfface.demodemo.business.factory;

import android.content.Context;

public class ShapeFactory {
    public enum ShapeType {
        CIRCLE,
        SQUARE,
    }

    public static Shape getShape(Context context, ShapeType shapeType) {
        switch (shapeType) {
            case SQUARE:
                return new Square(context);
            case CIRCLE:
                return new Circle(context);
            default:
                return null;
        }
    }
}
