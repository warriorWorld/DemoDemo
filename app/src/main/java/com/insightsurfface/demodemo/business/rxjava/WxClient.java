package com.insightsurfface.demodemo.business.rxjava;

import java.util.Random;

public class WxClient {

    public void getRawData(OnResponseListener listener) {
        Random random = new Random();
        if (random.nextInt(5) > 2) {
            listener.onGetData("rawData");
        } else {
            listener.onError();
        }
    }

    public void getFaceCode(String rawData, OnResponseListener listener) {
        Random random = new Random();
        int res = random.nextInt(10);
        if (res > 6) {
            listener.onGetData("facecode"); //成功
        } else if (res > 3) {
            listener.onGetData("cancel"); //用户取消
        } else {
            listener.onGetData("error");
        }
    }

    public void pay(String faceCode, OnResponseListener listener) {
        Random random = new Random();
        if (random.nextInt(5) > 2) {
            listener.onGetData("orderId");
        } else {
            listener.onError();
        }
    }

    public void uploadRecord(String orderId, OnResponseListener listener) {
        Random random = new Random();
        if (random.nextInt(5) > 2) {
            listener.onGetData("success");
        } else {
            listener.onError();
        }
    }

    public boolean isUserCancel() {
        return new Random().nextBoolean();
    }

    public interface OnResponseListener {
        void onGetData(String data);

        void onError();
    }
}
