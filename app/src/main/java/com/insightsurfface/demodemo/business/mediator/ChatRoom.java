package com.insightsurfface.demodemo.business.mediator;

import android.content.Context;

import com.insightsurfface.demodemo.widget.toast.EasyToast;

import java.util.Date;

public class ChatRoom {
    public static void showMessage(EasyToast toast, User user, String message) {
      toast.showToast(new Date().toString()
                + "\n [" + user.getName() + "] : " + message);
    }
}
