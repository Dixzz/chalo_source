package defpackage;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.x22;
import java.util.Objects;

/* renamed from: k42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class k42 implements e52 {

    /* renamed from: a  reason: collision with root package name */
    public final h52 f2018a;

    public k42(h52 h52) {
        this.f2018a = h52;
    }

    @Override // defpackage.e52
    public final void a() {
    }

    @Override // defpackage.e52
    public final <A extends x22.b, T extends l32<? extends f32, A>> T b(T t) {
        try {
            l62 l62 = this.f2018a.s.w;
            l62.f2180a.add(t);
            t.g.set(l62.b);
            d52 d52 = this.f2018a.s;
            x22.f fVar = d52.o.get(t.o);
            gj1.l(fVar, "Appropriate Api was not requested.");
            if (fVar.isConnected() || !this.f2018a.l.containsKey(t.o)) {
                t.m(fVar);
            } else {
                t.n(new Status(17, null));
            }
        } catch (DeadObjectException unused) {
            h52 h52 = this.f2018a;
            h52.j.sendMessage(h52.j.obtainMessage(1, new j42(this, this)));
        }
        return t;
    }

    @Override // defpackage.e52
    public final boolean c() {
        Objects.requireNonNull(this.f2018a.s);
        this.f2018a.j(null);
        return true;
    }

    @Override // defpackage.e52
    public final void d() {
    }

    @Override // defpackage.e52
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t) {
        b(t);
        return t;
    }

    @Override // defpackage.e52
    public final void f(Bundle bundle) {
    }

    @Override // defpackage.e52
    public final void g(int i) {
        this.f2018a.j(null);
        this.f2018a.t.c(i, false);
    }

    @Override // defpackage.e52
    public final void h(ConnectionResult connectionResult, x22<?> x22, boolean z) {
    }
}
