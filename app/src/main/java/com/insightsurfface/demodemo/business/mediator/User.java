package com.insightsurfface.demodemo.business.mediator;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

public class User {
    private String name;
    private EasyToast mToast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Context context, String name) {
        this.name = name;
        mToast = new EasyToast(context);
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(mToast, this, message);
    }
}
