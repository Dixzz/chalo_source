package defpackage;

import javax.inject.Provider;

/* renamed from: ey1  reason: default package */
/* compiled from: SQLiteEventStore_Factory */
public final class ey1 implements Object<dy1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<jy1> f1043a;
    public final Provider<jy1> b;
    public final Provider<yx1> c;
    public final Provider<fy1> d;

    public ey1(Provider<jy1> provider, Provider<jy1> provider2, Provider<yx1> provider3, Provider<fy1> provider4) {
        this.f1043a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public Object get() {
        return new dy1(this.f1043a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
