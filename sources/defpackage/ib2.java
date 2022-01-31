package defpackage;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import java.lang.reflect.Method;

/* renamed from: ib2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ib2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f1501a;
    public static final Method b;
    public static final Method c;
    public static final Method d;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    static {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib2.<clinit>():void");
    }

    public static boolean a(@RecentlyNonNull Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        nb2 a2 = ob2.a(context);
        if (a2.f2531a.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }
}
