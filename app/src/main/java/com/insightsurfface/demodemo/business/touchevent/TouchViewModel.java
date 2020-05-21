package com.insightsurfface.demodemo.business.touchevent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TouchViewModel extends ViewModel {
    private MutableLiveData<Boolean> isDispatch0;
    private MutableLiveData<Boolean> isDispatch1;
    private MutableLiveData<Boolean> isDispatch2;
    private MutableLiveData<Boolean> isIntercept0;
    private MutableLiveData<Boolean> isIntercept1;
    private MutableLiveData<Boolean> isHandleDownEvent0;
    private MutableLiveData<Boolean> isHandleDownEvent1;
    private MutableLiveData<Boolean> isHandleDownEvent2;

    public LiveData<Boolean> getIsDispatch0() {
        return isDispatch0;
    }

    public void setIsDispatch0(boolean b) {
        isDispatch0.setValue(b);
    }

    public LiveData<Boolean> getIsDispatch1() {
        return isDispatch1;
    }

    public void setIsDispatch1(boolean b) {
        isDispatch1.setValue(b);
    }

    public LiveData<Boolean> getIsDispatch2() {
        return isDispatch2;
    }

    public void setIsDispatch2(boolean b) {
        isDispatch2.setValue(b);
    }

    public LiveData<Boolean> getIsIntercept0() {
        return isIntercept0;
    }

    public void setIsIntercept0(boolean b) {
        isIntercept0.setValue(b);
    }

    public LiveData<Boolean> getIsIntercept1() {
        return isIntercept1;
    }

    public void setIsIntercept1(boolean b) {
        isIntercept1.setValue(b);
    }

    public LiveData<Boolean> getIsHandleDownEvent0() {
        return isHandleDownEvent0;
    }

    public void setIsHandleDownEvent0(boolean b) {
        isHandleDownEvent0.setValue(b);
    }

    public LiveData<Boolean> getIsHandleDownEvent1() {
        return isHandleDownEvent1;
    }

    public void setIsHandleDownEvent1(boolean b) {
        isHandleDownEvent1.setValue(b);
    }

    public LiveData<Boolean> getIsHandleDownEvent2() {
        return isHandleDownEvent2;
    }

    public void setIsHandleDownEvent2(boolean b) {
        isHandleDownEvent2.setValue(b);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
