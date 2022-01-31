package defpackage;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: jw1  reason: default package */
/* compiled from: DefaultScheduler_Factory */
public final class jw1 implements Object<iw1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Executor> f1987a;
    public final Provider<uv1> b;
    public final Provider<ex1> c;
    public final Provider<xx1> d;
    public final Provider<iy1> e;

    public jw1(Provider<Executor> provider, Provider<uv1> provider2, Provider<ex1> provider3, Provider<xx1> provider4, Provider<iy1> provider5) {
        this.f1987a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public Object get() {
        return new iw1(this.f1987a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
