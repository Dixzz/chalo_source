package defpackage;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: bx1  reason: default package */
/* compiled from: Uploader_Factory */
public final class bx1 implements Object<ax1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Context> f486a;
    public final Provider<uv1> b;
    public final Provider<xx1> c;
    public final Provider<ex1> d;
    public final Provider<Executor> e;
    public final Provider<iy1> f;
    public final Provider<jy1> g;

    public bx1(Provider<Context> provider, Provider<uv1> provider2, Provider<xx1> provider3, Provider<ex1> provider4, Provider<Executor> provider5, Provider<iy1> provider6, Provider<jy1> provider7) {
        this.f486a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public Object get() {
        return new ax1(this.f486a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
