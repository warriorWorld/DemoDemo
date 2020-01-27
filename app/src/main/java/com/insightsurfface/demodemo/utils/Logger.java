package com.insightsurfface.demodemo.utils;

import android.util.Log;

public class Logger {
    public static void d(String d) {
        Log.d("DEMODEMO", d);
    }

    public static void e(String e) {
        Log.d("DEMODEMO", e);
    }

    public static void i(String i) {
        Log.i("DEMODEMO", i);
    }

    public static void d(Double d) {
        d(String.valueOf(d));
    }

    public static void d(int d) {
        d(String.valueOf(d));
    }
}
