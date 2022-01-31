package defpackage;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.iz1;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: iz1  reason: default package */
public abstract class iz1<T extends iz1> {
    public static String a(Object obj) {
        return b(obj, 0);
    }

    public static String b(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object obj2 : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(b(obj2, i + 1));
            }
            if (i > 0) {
                sb.append("]");
            }
            return sb.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            boolean z = false;
            int i2 = 0;
            for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
                String b = b(entry.getValue(), i + 1);
                if (!TextUtils.isEmpty(b)) {
                    if (i > 0 && !z) {
                        sb2.append("{");
                        i2 = sb2.length();
                        z = true;
                    }
                    if (sb2.length() > i2) {
                        sb2.append(", ");
                    }
                    hj1.U0(sb2, (String) entry.getKey(), '=', b);
                }
            }
            if (z) {
                sb2.append("}");
            }
            return sb2.toString();
        }
    }

    public abstract void c(T t);
}
