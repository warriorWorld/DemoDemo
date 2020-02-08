package com.insightsurfface.demodemo.utils;/**
 * Created by Administrator on 2016/10/27.
 */

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 作者：苏航 on 2016/10/27 14:15
 * 邮箱：772192594@qq.com
 */
public class NumberUtil {
    public static String toCommaNum(BigDecimal num) {
        try {
            //这种方式会导致数值不精确
//        int numI = (int) (num * 100);
//        num = numI / 100f;
            java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
            df.setRoundingMode(RoundingMode.FLOOR);
            return df.format(num);
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String toCommaNum(String num) {
        if (TextUtils.isEmpty(num)) {
            return "";
        }
        try {
            return toCommaNum(new BigDecimal(num));
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String toCommaNumButNoDot(String num) {
        if (TextUtils.isEmpty(num)) {
            return "";
        }
        try {
            return toCommaNumButNoDot(new BigDecimal(num));
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String toCommaNumButNoDot(BigDecimal num) {
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat("###,###.##");
            return df.format(num);
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String cutNum(BigDecimal num) {
        try {
//        int numI = (int) (num * 100);
//        num = numI / 100f;
            //##.##代表0去掉,
            java.text.DecimalFormat df = new java.text.DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.FLOOR);
            return df.format(num);
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String doubleDecimals(BigDecimal num) {
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat("##0.00");
            df.setRoundingMode(RoundingMode.FLOOR);
            return df.format(num);
        } catch (Exception e) {
            Logger.d(e + ":doubleDecimals");
            return num + "";
        }
    }

    public static String doubleDecimals(String num) {
        try {
            return doubleDecimals(new BigDecimal(num));
        } catch (Exception e) {
            return num;
        }
    }

    //四舍五入的方式
    public static String toCommaNumRound(String num) {
        if (TextUtils.isEmpty(num)) {
            return "";
        }
        try {
            return toCommaNumRound(new BigDecimal(num));
        } catch (Exception e) {
            return num + "";
        }
    }

    //四舍五入的方式
    public static String toCommaNumRound(BigDecimal num) {
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
            return df.format(num);
        } catch (Exception e) {
            return num + "";
        }
    }

    public static String cutNum(double num) {
        return cutNum(num + "");
    }

    public static String cutNum(String num) {
        if (TextUtils.isEmpty(num)) {
            return "0";
        }
        try {
            return cutNum(new BigDecimal(num));
        } catch (Exception e) {
            return num + "";
        }
    }

    //四舍五入
    public static String cutNumRound(BigDecimal num) {
//        int numI = (int) (num * 100);
//        num = numI / 100f;
        //##.##代表0去掉,
        java.text.DecimalFormat df = new java.text.DecimalFormat("##.##");
        return df.format(num);
    }

    public static String cutNumRound(String num) {
        if (TextUtils.isEmpty(num)) {
            return "";
        }
        return cutNumRound(new BigDecimal(num));
    }

    public static int yuan2Fen(double yuan) {
        BigDecimal fenDecimal = new BigDecimal("100");
        return new BigDecimal(String.valueOf(yuan)).multiply(fenDecimal).intValue();
    }

    public static String toDoubleNum(double num) {
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat("00");
            return df.format(num);
        } catch (Exception e) {
            return num + "";
        }
    }
}
