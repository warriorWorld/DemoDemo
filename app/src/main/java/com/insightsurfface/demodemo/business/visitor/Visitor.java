package com.insightsurfface.demodemo.business.visitor;

public interface Visitor {
    void visit(Fighter fighter);

    void visit(Doctor doctor);

    void visit(Blacksmith blacksmith);
}
