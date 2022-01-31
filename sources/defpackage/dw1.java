package defpackage;

import javax.inject.Provider;

/* renamed from: dw1  reason: default package */
/* compiled from: DoubleCheck */
public final class dw1<T> implements Provider<T> {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Provider<T> f895a;
    public volatile Object b = c;

    public dw1(Provider<T> provider) {
        this.f895a = provider;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.f895a.get();
                    a(this.b, t);
                    this.b = t;
                    this.f895a = null;
                }
            }
        }
        return t;
    }
}
