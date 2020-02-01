package com.insightsurfface.demodemo.business.observer;

import java.util.Observable;

public class NumberObservable extends Observable {
    public void numberChanged(ObserverBean observerBean) {
        setChanged();
        notifyObservers(observerBean);
    }
}
