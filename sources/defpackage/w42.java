package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: w42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class w42 implements e52 {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    public final h52 f3726a;

    public w42(h52 h52) {
        this.f3726a = h52;
    }

    @Override // defpackage.e52
    public final void a() {
        h52 h52 = this.f3726a;
        h52.f.lock();
        try {
            h52.p = new v42(h52, h52.m, h52.n, h52.i, h52.o, h52.f, h52.h);
            h52.p.d();
            h52.g.signalAll();
        } finally {
            h52.f.unlock();
        }
    }

    @Override // defpackage.e52
    public final <A extends x22.b, T extends l32<? extends f32, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // defpackage.e52
    public final boolean c() {
        return true;
    }

    @Override // defpackage.e52
    public final void d() {
        for (x22.f fVar : this.f3726a.k.values()) {
            fVar.disconnect();
        }
        this.f3726a.s.p = Collections.emptySet();
    }

    @Override // defpackage.e52
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t) {
        this.f3726a.s.h.add(t);
        return t;
    }

    @Override // defpackage.e52
    public final void f(Bundle bundle) {
    }

    @Override // defpackage.e52
    public final void g(int i) {
    }

    @Override // defpackage.e52
    public final void h(ConnectionResult connectionResult, x22<?> x22, boolean z) {
    }
}
