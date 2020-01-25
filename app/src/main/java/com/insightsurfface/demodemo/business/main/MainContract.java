package com.insightsurfface.demodemo.business.main;

import com.insightsurfface.demodemo.base.BasePresenter;
import com.insightsurfface.demodemo.base.BaseView;

public interface MainContract {
    interface Persenter extends BasePresenter {
        void getDemoList();
    }

    interface View extends BaseView<Persenter> {
        void displayList(String[] demoList);
    }
}
