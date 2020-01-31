package com.insightsurfface.demodemo.business.command;

import java.util.ArrayList;
import java.util.List;

public class Commander {
    private List<Command> orders = new ArrayList<>();
    private List<Command> undoOrders = new ArrayList<>();
    private boolean isStop = false;

    public void takeCommand(Command command) {
        orders.add(command);
    }

    public void action() {
        isStop=false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (orders.size() > 0) {
                    if (isStop) {
                        return;
                    }
                    orders.get(0).execute();
                    undoOrders.add(orders.get(0));
                    orders.remove(0);
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void continueAction() {
        action();
    }

    public void getActioned() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Command order : undoOrders) {
                    order.execute();
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
