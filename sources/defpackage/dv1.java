package defpackage;

import android.content.Context;
import defpackage.ay1;
import defpackage.by1;
import defpackage.hv1;
import defpackage.ky1;
import defpackage.ly1;
import defpackage.zx1;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: dv1  reason: default package */
/* compiled from: DaggerTransportRuntimeComponent */
public final class dv1 extends ov1 {
    public Provider<Executor> f;
    public Provider<Context> g;
    public Provider h;
    public Provider i;
    public Provider j;
    public Provider<dy1> k;
    public Provider<zw1> l;
    public Provider<ex1> m;
    public Provider<iw1> n;
    public Provider<ax1> o;
    public Provider<cx1> p;
    public Provider<nv1> q;

    public dv1(Context context, a aVar) {
        Provider<dy1> provider;
        Provider provider2 = hv1.a.f1432a;
        Object obj = dw1.c;
        this.f = !(provider2 instanceof dw1) ? new dw1(provider2) : provider2;
        Objects.requireNonNull(context, "instance cannot be null");
        ew1 ew1 = new ew1(context);
        this.g = ew1;
        ky1 ky1 = ky1.a.f2136a;
        ly1 ly1 = ly1.a.f2293a;
        zv1 zv1 = new zv1(ew1, ky1, ly1);
        this.h = zv1;
        Provider bw1 = new bw1(ew1, zv1);
        this.i = !(bw1 instanceof dw1) ? new dw1(bw1) : bw1;
        gy1 gy1 = new gy1(this.g, zx1.a.f4224a, ay1.a.f347a);
        this.j = gy1;
        ey1 ey1 = new ey1(ky1, ly1, by1.a.f490a, gy1);
        if (ey1 instanceof dw1) {
            provider = ey1;
        } else {
            provider = new dw1<>(ey1);
        }
        this.k = provider;
        lw1 lw1 = new lw1(ky1);
        this.l = lw1;
        Provider<Context> provider3 = this.g;
        mw1 mw1 = new mw1(provider3, provider, lw1, ly1);
        this.m = mw1;
        Provider<Executor> provider4 = this.f;
        Provider provider5 = this.i;
        jw1 jw1 = new jw1(provider4, provider5, mw1, provider, provider);
        this.n = jw1;
        bx1 bx1 = new bx1(provider3, provider5, provider, mw1, provider4, provider, ky1);
        this.o = bx1;
        dx1 dx1 = new dx1(provider4, provider, mw1, provider);
        this.p = dx1;
        Provider pv1 = new pv1(ky1, ly1, jw1, bx1, dx1);
        this.q = !(pv1 instanceof dw1) ? new dw1(pv1) : pv1;
    }
}
