package defpackage;

import com.google.firebase.perf.FirebasePerformance;

/* renamed from: dk6  reason: default package */
/* compiled from: HttpMethod.kt */
public final class dk6 {
    public static final boolean a(String str) {
        n86.f(str, "method");
        return !n86.a(str, FirebasePerformance.HttpMethod.GET) && !n86.a(str, "HEAD");
    }
}
