package com.insightsurfface.demodemo.business.command;

public class RotateCommand implements Command {
    private TetrisMachine mTetrisMachine;

    public RotateCommand(TetrisMachine tetrisMachine) {
        this.mTetrisMachine = tetrisMachine;
    }

    @Override
    public void execute() {
        mTetrisMachine.rotate();
    }
}
