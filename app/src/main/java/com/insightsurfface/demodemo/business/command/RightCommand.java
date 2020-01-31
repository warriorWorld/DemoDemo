package com.insightsurfface.demodemo.business.command;

public class RightCommand implements Command {
    private TetrisMachine mTetrisMachine;

    public RightCommand(TetrisMachine tetrisMachine) {
        this.mTetrisMachine = tetrisMachine;
    }

    @Override
    public void execute() {
        mTetrisMachine.toRight();
    }
}
