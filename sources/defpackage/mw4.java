package defpackage;

import java.util.Objects;

/* renamed from: mw4  reason: default package */
public final class mw4<T> implements nw4, kw4 {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile nw4<T> f2453a;
    public volatile Object b = c;

    public mw4(nw4<T> nw4) {
        this.f2453a = nw4;
    }

    public static <P extends nw4<T>, T> kw4<T> b(P p) {
        if (p instanceof kw4) {
            return (kw4) p;
        }
        Objects.requireNonNull(p);
        return new mw4(p);
    }

    @Override // defpackage.kw4, defpackage.nw4
    public final T a() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.f2453a.a();
                    Object obj2 = this.b;
                    if (obj2 != obj) {
                        if (obj2 != t) {
                            String valueOf = String.valueOf(obj2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.b = t;
                    this.f2453a = null;
                }
            }
        }
        return t;
    }
}
