package com.insightsurfface.demodemo.business.command;

public class LeftCommand implements Command {
    private TetrisMachine mTetrisMachine;

    public LeftCommand(TetrisMachine tetrisMachine) {
        this.mTetrisMachine = tetrisMachine;
    }

    @Override
    public void execute() {
        mTetrisMachine.toLeft();
    }
}
