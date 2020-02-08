package com.insightsurfface.demodemo.business.memoto;

import android.content.Context;

import com.insightsurfface.demodemo.utils.ShareObjUtil;

import java.security.Key;

public class Caretaker {
    private final static String KEY = "length_memoto";

    public static void saveMemoto(Context context, LengthMemoto lengthMemoto) {
        ShareObjUtil.saveObject(context, lengthMemoto, KEY);
    }

    public static LengthMemoto getLengthMemoto(Context context) {
        return (LengthMemoto) ShareObjUtil.getObject(context, KEY);
    }
}
