package com.insightsurfface.demodemo.business.template;

import android.content.Context;

public class MakeTea extends MakeTeaAbstract {

    public MakeTea(Context context) {
        super(context);
    }

    @Override
    protected String addTea() {
        return "加入茶叶";
    }

    @Override
    protected String addLiquid() {
        return "加热水";
    }

    @Override
    protected String addFlavour() {
        return null;
    }
}
