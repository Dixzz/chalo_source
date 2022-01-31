package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: ed5  reason: default package */
/* compiled from: SystemInformation */
public class ed5 {
    public static ed5 h;
    public static final Object i = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f963a;
    public final Boolean b;
    public final Boolean c;
    public final DisplayMetrics d;
    public final String e;
    public final Integer f;
    public final String g;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[SYNTHETIC, Splitter:B:22:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ed5(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ed5.<init>(android.content.Context):void");
    }

    public static ed5 a(Context context) {
        synchronized (i) {
            if (h == null) {
                h = new ed5(context.getApplicationContext());
            }
        }
        return h;
    }
}
