package com.insightsurfface.demodemo.business.touchevent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TouchViewModel extends ViewModel {
    private MutableLiveData<Boolean> isDispatch0 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isDispatch1 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isDispatch2 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isIntercept0 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isIntercept1 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isHandleDownEvent0 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isHandleDownEvent1 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isHandleDownEvent2 = new MutableLiveData<>();
    private MutableLiveData<Boolean> isHandleDownEvent3 = new MutableLiveData<>();

    public void init() {
        isDispatch0.setValue(false);
        isDispatch1.setValue(false);
        isDispatch2.setValue(false);
        isIntercept0.setValue(false);
        isIntercept1.setValue(false);
        isHandleDownEvent0.setValue(false);
        isHandleDownEvent1.setValue(false);
        isHandleDownEvent2.setValue(false);
    }

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

    public LiveData<Boolean> getIsHandleDownEvent3() {
        return isHandleDownEvent3;
    }

    public void setIsHandleDownEvent3(boolean b) {
        isHandleDownEvent3.setValue(b);
    }
}
