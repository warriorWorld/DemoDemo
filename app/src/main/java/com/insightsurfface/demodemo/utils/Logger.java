package com.insightsurfface.demodemo.utils;

import android.util.Log;

public class Logger {
    private static String tag = "DEMODEMO";

    public static void d(String d) {
        Log.d(tag, d);
    }

    public static void e(String e) {
        Log.d(tag, e);
    }

    public static void i(String i) {
        Log.i(tag, i);
    }

    public static void d(Double d) {
        d(String.valueOf(d));
    }

    public static void d(int d) {
        d(String.valueOf(d));
    }

    public static void setTag(String tag) {
        Logger.tag = tag;
    }
}
