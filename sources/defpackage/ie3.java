package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;
import java.util.Map;

/* renamed from: ie3  reason: default package */
public final class ie3 {
    public static String a(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry().toLowerCase(locale));
        }
        return sb.toString();
    }

    public static void b(Map<String, String> map, String str, Map<String, String> map2) {
        e(map, str, map2.get(str));
    }

    public static boolean c(double d, String str) {
        int i;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 100.0d) {
            if (!TextUtils.isEmpty(str)) {
                i = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char charAt = str.charAt(length);
                    i = ((i << 6) & 268435455) + charAt + (charAt << 14);
                    int i2 = 266338304 & i;
                    if (i2 != 0) {
                        i ^= i2 >> 21;
                    }
                }
            } else {
                i = 1;
            }
            if (((double) (i % 10000)) >= d * 100.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo == null || !receiverInfo.enabled || (z && !receiverInfo.exported)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void e(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }
}
