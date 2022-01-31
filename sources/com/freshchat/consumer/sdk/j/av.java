package com.freshchat.consumer.sdk.j;

import android.util.Patterns;

public class av {
    private static boolean a(String str, int i, String... strArr) {
        boolean a2 = as.a(str);
        if (a2 && i != 0 && str.length() > i) {
            a2 = false;
        }
        if (a2 && strArr != null) {
            for (String str2 : strArr) {
                if (as.a(str2)) {
                    try {
                        if (!str.matches(str2)) {
                            return false;
                        }
                    } catch (Exception e) {
                        ai.e("FRESHCHAT_WARNING", e.toString());
                    }
                }
            }
        }
        return a2;
    }

    public static boolean aK(String str) {
        return a(str, 384, Patterns.EMAIL_ADDRESS.pattern());
    }

    public static boolean aL(String str) {
        return a(str, 6, "\\+?[0-9]+");
    }

    public static boolean aM(String str) {
        return a(str, 16, Patterns.PHONE.pattern());
    }

    public static boolean aN(String str) {
        return a(str, 256, new String[0]);
    }

    public static boolean aO(String str) {
        return a(str, 32, "[\\w -]+");
    }

    public static boolean d(String str, int i) {
        return a(str, i, new String[0]);
    }

    public static boolean e(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Double) || (obj instanceof String);
    }
}
