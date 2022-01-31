package defpackage;

import android.os.Build;

/* renamed from: if3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class if3 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f1515a = (!a());

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
