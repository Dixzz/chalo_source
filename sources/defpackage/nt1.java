package defpackage;

import android.os.SystemClock;

/* renamed from: nt1  reason: default package */
/* compiled from: LogTime */
public final class nt1 {

    /* renamed from: a  reason: collision with root package name */
    public static final double f2602a = (1.0d / Math.pow(10.0d, 6.0d));
    public static final /* synthetic */ int b = 0;

    public static double a(long j) {
        return ((double) (SystemClock.elapsedRealtimeNanos() - j)) * f2602a;
    }
}
