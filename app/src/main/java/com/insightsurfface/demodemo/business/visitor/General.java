package com.insightsurfface.demodemo.business.visitor;

import android.widget.TextView;

public class General implements Visitor {
    private TextView tv;

    public General(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void visit(Fighter fighter) {
        tv.setText(tv.getText().toString() + "\n将军：  战士:" + fighter.name + ",人头数： " + fighter.getKilledNum());
    }

    @Override
    public void visit(Doctor doctor) {
        tv.setText(tv.getText().toString() + "\n将军：  医生：" + doctor.name + ",治愈数： " + doctor.getCuredNum());
    }

    @Override
    public void visit(Blacksmith blacksmith) {
        tv.setText(tv.getText().toString() + "\n将军：  铁匠：" + blacksmith.name + ",锻造数： " + blacksmith.getForgedWeapon());
    }
}
