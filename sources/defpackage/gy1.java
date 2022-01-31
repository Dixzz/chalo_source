package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: gy1  reason: default package */
/* compiled from: SchemaManager_Factory */
public final class gy1 implements Object<fy1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<Context> f1316a;
    public final Provider<String> b;
    public final Provider<Integer> c;

    public gy1(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f1316a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public Object get() {
        return new fy1(this.f1316a.get(), this.b.get(), this.c.get().intValue());
    }
}
