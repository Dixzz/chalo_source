package defpackage;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: dx1  reason: default package */
/* compiled from: WorkInitializer_Factory */
public final class dx1 implements Object<cx1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Executor> f899a;
    public final Provider<xx1> b;
    public final Provider<ex1> c;
    public final Provider<iy1> d;

    public dx1(Provider<Executor> provider, Provider<xx1> provider2, Provider<ex1> provider3, Provider<iy1> provider4) {
        this.f899a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public Object get() {
        return new cx1(this.f899a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
