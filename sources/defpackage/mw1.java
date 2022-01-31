package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: mw1  reason: default package */
/* compiled from: SchedulingModule_WorkSchedulerFactory */
public final class mw1 implements Object<ex1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Context> f2452a;
    public final Provider<xx1> b;
    public final Provider<zw1> c;
    public final Provider<jy1> d;

    public mw1(Provider<Context> provider, Provider<xx1> provider2, Provider<zw1> provider3, Provider<jy1> provider4) {
        this.f2452a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public Object get() {
        this.d.get();
        return new yw1(this.f2452a.get(), this.b.get(), this.c.get());
    }
}
