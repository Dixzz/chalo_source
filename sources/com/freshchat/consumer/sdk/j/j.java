package com.freshchat.consumer.sdk.j;

import java.util.Locale;

public class j {
    private static String a(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return !a(lowerCase, 2, 3) ? z ? "" : "und" : lowerCase;
    }

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String str = "";
        String replace = as.a(locale.getVariant()) ? locale.getVariant().replace('_', '-') : str;
        String a2 = a(language, false);
        String b = b(country, false);
        String au = au(replace);
        if (a2.isEmpty()) {
            a2 = "und";
        }
        if (!"no".equals(a2) || !"NO".equals(b) || !"NY".equals(au)) {
            str = au;
        } else {
            a2 = "nn";
            b = "NO";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(a2);
        if (!b.isEmpty()) {
            sb.append('-');
            sb.append(b);
        }
        if (!str.isEmpty()) {
            sb.append('-');
            sb.append(str);
        }
        return sb.toString();
    }

    private static boolean a(String str, int i, int i2) {
        int length = str.length();
        if (length < i || length > i2) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    private static String au(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String replace = str.replace('-', '_');
        for (String str2 : replace.split("_")) {
            if (!aw(str2)) {
                return "";
            }
        }
        return replace;
    }

    private static boolean av(String str) {
        if (str.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean aw(String str) {
        char charAt;
        if (str.length() < 5 || str.length() > 8) {
            return str.length() == 4 && (charAt = str.charAt(0)) >= '0' && charAt <= '9' && ax(str);
        }
        if (ax(str)) {
            return true;
        }
    }

    private static boolean ax(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return false;
            }
        }
        return true;
    }

    private static String b(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        return (a(upperCase, 2, 2) || av(upperCase)) ? upperCase : "";
    }
}
