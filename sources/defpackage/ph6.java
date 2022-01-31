package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: ph6  reason: default package */
/* compiled from: ConnectionPool.kt */
public final class ph6 {

    /* renamed from: a  reason: collision with root package name */
    public final tj6 f2806a;

    public ph6() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        n86.f(timeUnit, "timeUnit");
        tj6 tj6 = new tj6(ij6.h, 5, 5, timeUnit);
        n86.f(tj6, "delegate");
        this.f2806a = tj6;
    }
}
