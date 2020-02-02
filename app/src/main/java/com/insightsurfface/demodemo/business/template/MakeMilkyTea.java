package com.insightsurfface.demodemo.business.template;

import android.content.Context;

public class MakeMilkyTea extends MakeTeaAbstract {

    public MakeMilkyTea(Context context) {
        super(context);
    }

    @Override
    protected String addTea() {
        return "加入茶叶";
    }

    @Override
    protected String addLiquid() {
        return "加热奶";
    }

    @Override
    protected String addFlavour() {
        return "加糖";
    }
}
