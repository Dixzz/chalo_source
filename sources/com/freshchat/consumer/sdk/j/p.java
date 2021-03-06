package com.freshchat.consumer.sdk.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.beans.User;
import com.razorpay.AnalyticsConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class p {
    public static boolean a(Context context, WindowManager windowManager) {
        if (!at(context) && !au(context)) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return BigDecimal.valueOf(Math.sqrt(Math.pow((double) (((float) as(context)) / displayMetrics.ydpi), 2.0d) + Math.pow((double) (((float) ar(context)) / displayMetrics.xdpi), 2.0d))).setScale(1, RoundingMode.HALF_UP).compareTo(BigDecimal.valueOf(6.1d)) >= 0;
    }

    public static boolean aD(Context context) {
        return (aw.eX() ? TextUtils.getLayoutDirectionFromLocale(ah.bb(context)) : 0) != 0;
    }

    @TargetApi(17)
    public static int ar(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (aw.eX()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        if (aw.eU()) {
            try {
                return ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        return defaultDisplay.getWidth();
    }

    @TargetApi(17)
    public static int as(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (aw.eX()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        if (aw.eU()) {
            try {
                return ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        return defaultDisplay.getHeight();
    }

    private static boolean at(Context context) {
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) == 3;
    }

    private static boolean au(Context context) {
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) == 4;
    }

    public static Map<String, String> av(Context context) {
        HashMap hashMap = new HashMap();
        try {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            String str3 = Build.VERSION.RELEASE;
            int i = Build.VERSION.SDK_INT;
            hashMap.put("manufacturer", str);
            hashMap.put("model", str2);
            hashMap.put(User.DEVICE_META_OS_NAME, AnalyticsConstants.ANDROID);
            hashMap.put(User.DEVICE_META_OS_VERSION_NAME, str3);
            hashMap.put(User.DEVICE_META_OS_VERSION_CODE, String.valueOf(i));
            hashMap.put(User.DEVICE_META_APP_VERSION_NAME, g.ae(context));
            hashMap.put(User.DEVICE_META_APP_VERSION_CODE, String.valueOf(g.af(context)));
            hashMap.put(User.DEVICE_META_SDK_VERSION_CODE, String.valueOf(Freshchat.getSDKVersionCode()));
        } catch (Exception e) {
            q.a(e);
        }
        return hashMap;
    }

    public static int cq(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels * displayMetrics.widthPixels;
    }

    public static boolean ew() {
        return Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
    }
}
