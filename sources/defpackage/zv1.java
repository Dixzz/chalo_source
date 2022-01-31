package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: zv1  reason: default package */
/* compiled from: CreationContextFactory_Factory */
public final class zv1 implements Object<yv1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Context> f4218a;
    public final Provider<jy1> b;
    public final Provider<jy1> c;

    public zv1(Provider<Context> provider, Provider<jy1> provider2, Provider<jy1> provider3) {
        this.f4218a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public Object get() {
        return new yv1(this.f4218a.get(), this.b.get(), this.c.get());
    }
}
