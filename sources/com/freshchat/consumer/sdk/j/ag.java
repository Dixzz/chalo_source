package com.freshchat.consumer.sdk.j;

import android.content.Intent;
import android.os.Bundle;
import java.util.Set;

public class ag {
    public static final String TAG = "com.freshchat.consumer.sdk.j.ag";

    public static void a(String str, Intent intent) {
        if (!(intent == null || intent.getExtras() == null)) {
            if (as.isEmpty(str)) {
                str = TAG;
            }
            Bundle extras = intent.getExtras();
            Set<String> keySet = extras.keySet();
            StringBuilder i0 = hj1.i0("************* Printing Intent (has ");
            i0.append(keySet.size());
            i0.append("extras) **********");
            ai.d(str, i0.toString());
            String action = intent.getAction();
            ai.d(str, "Action : " + action);
            StringBuilder sb = new StringBuilder();
            for (String str2 : keySet) {
                Object obj = extras.get(str2);
                sb.setLength(0);
                sb.append("Name: ");
                sb.append(str2);
                sb.append(", Value: ");
                String str3 = null;
                sb.append(obj != null ? obj.toString() : null);
                sb.append(" (Type: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb.append(str3);
                sb.append(" )");
                ai.d(str, sb.toString());
            }
            ai.d(str, "************* Done with intent **************");
        }
    }

    public static String b(Intent intent, String str) {
        return intent.getStringExtra(str);
    }

    public static boolean c(Intent intent, String str) {
        return intent.getBooleanExtra(str, false);
    }

    public static long d(Intent intent, String str) {
        if (intent == null || as.isEmpty(str)) {
            return 0;
        }
        try {
            String stringExtra = intent.getStringExtra(str);
            if (!as.isEmpty(stringExtra)) {
                return Long.valueOf(stringExtra).longValue();
            }
            return 0;
        } catch (Exception e) {
            ai.e("FRESHCHAT", "Found invalid value for " + str, e);
            return 0;
        }
    }

    public static int e(Intent intent, String str) {
        if (intent == null || as.isEmpty(str)) {
            return 0;
        }
        try {
            String stringExtra = intent.getStringExtra(str);
            if (!as.isEmpty(stringExtra)) {
                return Integer.valueOf(stringExtra).intValue();
            }
            return 0;
        } catch (Exception e) {
            ai.e("FRESHCHAT", "Found invalid value for " + str, e);
            return 0;
        }
    }
}
