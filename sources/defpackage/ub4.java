package defpackage;

import java.lang.Thread;

/* renamed from: ub4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ub4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final String f3484a;
    public final /* synthetic */ sb4 b;

    public ub4(sb4 sb4, String str) {
        this.b = sb4;
        this.f3484a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.g().f.b(this.f3484a, th);
    }
}
