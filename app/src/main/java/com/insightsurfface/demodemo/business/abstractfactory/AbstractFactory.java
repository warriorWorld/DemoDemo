package com.insightsurfface.demodemo.business.abstractfactory;

import android.content.Context;

import com.insightsurfface.demodemo.business.factory.Shape;
import com.insightsurfface.demodemo.business.factory.ShapeFactory;

public abstract class AbstractFactory {
    public abstract Color getColor(Context context, ColorFactory.ColorType colorType);

    public abstract Shape getShape(Context context, ShapeFactory.ShapeType shapeType);
}
