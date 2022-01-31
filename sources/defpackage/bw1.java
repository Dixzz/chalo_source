package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: bw1  reason: default package */
/* compiled from: MetadataBackendRegistry_Factory */
public final class bw1 implements Object<aw1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Context> f483a;
    public final Provider<yv1> b;

    public bw1(Provider<Context> provider, Provider<yv1> provider2) {
        this.f483a = provider;
        this.b = provider2;
    }

    public Object get() {
        return new aw1(this.f483a.get(), this.b.get());
    }
}
