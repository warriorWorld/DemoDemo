package com.insightsurfface.demodemo.business.visitor;

import android.widget.TextView;

public class Funs implements Visitor {
    private TextView tv;

    public Funs(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void visit(Fighter fighter) {
        tv.setText(tv.getText().toString() + "\n粉丝：  战士:" + fighter.name + ",颜值： " + fighter.appearanceLevel);
    }

    @Override
    public void visit(Doctor doctor) {
        tv.setText(tv.getText().toString() + "\n粉丝：  医生:" + doctor.name + ",颜值： " + doctor.appearanceLevel);
    }

    @Override
    public void visit(Blacksmith blacksmith) {
        tv.setText(tv.getText().toString() + "\n粉丝：  铁匠:" + blacksmith.name + ",颜值： " + blacksmith.appearanceLevel);
    }
}
