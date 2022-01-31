package defpackage;

import javax.inject.Provider;

/* renamed from: pv1  reason: default package */
/* compiled from: TransportRuntime_Factory */
public final class pv1 implements Object<nv1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<jy1> f2857a;
    public final Provider<jy1> b;
    public final Provider<kw1> c;
    public final Provider<ax1> d;
    public final Provider<cx1> e;

    public pv1(Provider<jy1> provider, Provider<jy1> provider2, Provider<kw1> provider3, Provider<ax1> provider4, Provider<cx1> provider5) {
        this.f2857a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public Object get() {
        return new nv1(this.f2857a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
