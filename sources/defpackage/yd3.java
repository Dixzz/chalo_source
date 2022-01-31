package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: yd3  reason: default package */
public final class yd3 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f4032a = new Object();
    public static oi4 b;
    public static Boolean c;

    public static boolean a(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean d = ie3.d(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        c = Boolean.valueOf(d);
        return d;
    }
}
