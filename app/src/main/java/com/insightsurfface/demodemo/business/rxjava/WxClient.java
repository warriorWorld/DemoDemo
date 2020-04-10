package com.insightsurfface.demodemo.business.rxjava;

import java.util.Random;

public class WxClient {

    public void getRawData(OnResponseListener listener) throws PayException {
        Random random = new Random();
        if (random.nextInt(10) > 2) {
            listener.onGetData("rawData");
        } else {
            listener.onError();
        }
    }

    public void getFaceCode(String rawData, OnResponseListener listener) throws PayException {
        Random random = new Random();
        int res = random.nextInt(10);
        if (res > 4) {
            listener.onGetData("facecode"); //成功
        } else if (res > 3) {
            listener.onGetData("cancel"); //用户取消
        } else {
            listener.onError();
        }
    }

    public void pay(String faceCode, OnResponseListener listener) throws PayException {
        Random random = new Random();
        int result = random.nextInt(8);
        if (result > 6) {
            listener.onGetData("orderId");
        } else if (result >2) {
            listener.onGetData("unknow");
        } else {
            listener.onError();
        }
    }

    public void uploadRecord(String orderId, OnResponseListener listener) throws PayException {
        Random random = new Random();
        if (random.nextInt(5) > 2) {
            listener.onGetData("success");
        } else {
            listener.onError();
        }
    }

    public void queryPayed(String faceCode, OnResponseListener listener) throws PayException {
        Random random = new Random();
        int result = random.nextInt(8);
        if (result > 6) {
            listener.onGetData("success");
        } else if (result > 4) {
            listener.onGetData("unknow");
        } else {
            listener.onError();
        }
    }

    public void cancelOrder(OnResponseListener listener) throws PayException {
        if (new Random().nextInt(6) > 4) {
            listener.onGetData("success");
        } else {
            listener.onError();
        }
    }

    public boolean isUserCancel() {
        return new Random().nextBoolean();
    }

    public interface OnResponseListener {
        void onGetData(String data) throws PayException;

        void onError() throws PayException;
    }
}
