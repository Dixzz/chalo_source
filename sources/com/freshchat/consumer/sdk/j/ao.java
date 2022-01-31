package com.freshchat.consumer.sdk.j;

import android.content.Context;
import java.lang.reflect.Method;

public class ao {
    public static Class ay(String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Method c(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class u(Context context, String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
