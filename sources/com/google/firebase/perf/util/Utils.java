package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.firebase.perf.logging.AndroidLogger;
import defpackage.di6;

public class Utils {
    private static Boolean mIsDebugLoggingEnabled;

    public static int bufferToInt(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4 && i < bArr.length) {
            i2 |= (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean isDebugLoggingEnabled(Context context) {
        Boolean bool = mIsDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            mIsDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            AndroidLogger instance = AndroidLogger.getInstance();
            StringBuilder i0 = hj1.i0("No perf logcat meta data found ");
            i0.append(e.getMessage());
            instance.debug(i0.toString(), new Object[0]);
            return false;
        }
    }

    public static int saturatedIntCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return j < -2147483648L ? RtlSpacingHelper.UNDEFINED : (int) j;
    }

    public static String stripSensitiveInfo(String str) {
        di6 h = di6.h(str);
        if (h == null) {
            return str;
        }
        di6.a f = h.f();
        f.h("");
        f.g("");
        f.g = null;
        f.h = null;
        return f.toString();
    }

    public static String truncateURL(String str, int i) {
        int lastIndexOf;
        if (str.length() <= i) {
            return str;
        }
        if (str.charAt(i) == '/') {
            return str.substring(0, i);
        }
        di6 h = di6.h(str);
        if (h == null) {
            return str.substring(0, i);
        }
        if (h.b().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, i - 1)) < 0) {
            return str.substring(0, i);
        }
        return str.substring(0, lastIndexOf);
    }
}
