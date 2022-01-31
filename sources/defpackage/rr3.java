package defpackage;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* renamed from: rr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class rr3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f3121a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    public static final AtomicBoolean e = new AtomicBoolean();
    public static HashMap<String, String> f;
    public static final HashMap<String, Boolean> g = new HashMap<>();
    public static final HashMap<String, Integer> h = new HashMap<>();
    public static final HashMap<String, Long> i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static Object k;
    public static boolean l;
    public static String[] m = new String[0];

    public static void a(Object obj, String str, String str2) {
        synchronized (rr3.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }
}
