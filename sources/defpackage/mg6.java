package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* renamed from: mg6  reason: default package */
/* compiled from: Dispatcher.kt */
public class mg6 extends hc6 {
    public final int g;
    public final int h;
    public final long i;
    public final String j;
    public kg6 k;

    public mg6(int i2, int i3, String str, int i4) {
        i2 = (i4 & 1) != 0 ? vg6.b : i2;
        i3 = (i4 & 2) != 0 ? vg6.c : i3;
        String str2 = (i4 & 4) != 0 ? "DefaultDispatcher" : null;
        long j2 = vg6.d;
        this.g = i2;
        this.h = i3;
        this.i = j2;
        this.j = str2;
        this.k = new kg6(i2, i3, j2, str2);
    }

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        try {
            kg6 kg6 = this.k;
            AtomicLongFieldUpdater atomicLongFieldUpdater = kg6.m;
            kg6.f(runnable, qg6.f, false);
        } catch (RejectedExecutionException unused) {
            pb6.l.P(runnable);
        }
    }
}
