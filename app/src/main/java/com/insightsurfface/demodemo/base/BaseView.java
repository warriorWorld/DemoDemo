package com.insightsurfface.demodemo.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
