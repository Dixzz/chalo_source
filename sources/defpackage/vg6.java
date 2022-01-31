package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: vg6  reason: default package */
/* compiled from: Tasks.kt */
public final class vg6 {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3647a = ec6.G("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int b;
    public static final int c;
    public static final long d = TimeUnit.SECONDS.toNanos(ec6.G("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    public static rg6 e = pg6.f2803a;

    static {
        ec6.F("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int i = eg6.f971a;
        int F = ec6.F("kotlinx.coroutines.scheduler.core.pool.size", i < 2 ? 2 : i, 1, 0, 8, null);
        b = F;
        c = ec6.F("kotlinx.coroutines.scheduler.max.pool.size", l96.b(i * 128, F, 2097150), 0, 2097150, 4, null);
    }
}
