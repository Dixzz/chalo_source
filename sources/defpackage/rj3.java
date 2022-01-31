package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: rj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class rj3 {
    public static final rj3 c = new rj3();

    /* renamed from: a  reason: collision with root package name */
    public final vj3 f3088a = new si3();
    public final ConcurrentMap<Class<?>, sj3<?>> b = new ConcurrentHashMap();

    public final <T> sj3<T> a(Class<T> cls) {
        sj3<T> sj3;
        ij3 ij3;
        Class<?> cls2;
        Charset charset = zh3.f4175a;
        Objects.requireNonNull(cls, "messageType");
        sj3<T> sj32 = (sj3<T>) this.b.get(cls);
        if (sj32 != null) {
            return sj32;
        }
        si3 si3 = (si3) this.f3088a;
        Objects.requireNonNull(si3);
        Class<?> cls3 = uj3.f3513a;
        if (uh3.class.isAssignableFrom(cls) || (cls2 = uj3.f3513a) == null || cls2.isAssignableFrom(cls)) {
            ej3 b2 = si3.f3217a.b(cls);
            if (b2.b()) {
                if (uh3.class.isAssignableFrom(cls)) {
                    gk3<?, ?> gk3 = uj3.d;
                    kh3<?> kh3 = mh3.f2376a;
                    ij3 = new ij3(gk3, mh3.f2376a, b2.c());
                } else {
                    gk3<?, ?> gk32 = uj3.b;
                    kh3<?> kh32 = mh3.b;
                    if (kh32 != null) {
                        ij3 = new ij3(gk32, kh32, b2.c());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                sj3 = ij3;
            } else {
                boolean z = false;
                if (uh3.class.isAssignableFrom(cls)) {
                    if (b2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        kj3 kj3 = mj3.b;
                        pi3 pi3 = pi3.b;
                        gk3<?, ?> gk33 = uj3.d;
                        kh3<?> kh33 = mh3.f2376a;
                        sj3 = jj3.a(b2, kj3, pi3, gk33, mh3.f2376a, bj3.b);
                    } else {
                        sj3 = jj3.a(b2, mj3.b, pi3.b, uj3.d, null, bj3.b);
                    }
                } else {
                    if (b2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        kj3 kj32 = mj3.f2386a;
                        pi3 pi32 = pi3.f2807a;
                        gk3<?, ?> gk34 = uj3.b;
                        kh3<?> kh34 = mh3.b;
                        if (kh34 != null) {
                            sj3 = jj3.a(b2, kj32, pi32, gk34, kh34, bj3.f441a);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        sj3 = jj3.a(b2, mj3.f2386a, pi3.f2807a, uj3.c, null, bj3.f441a);
                    }
                }
            }
            sj3<T> sj33 = (sj3<T>) this.b.putIfAbsent(cls, sj3);
            return sj33 != null ? sj33 : sj3;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public final <T> sj3<T> b(T t) {
        return a(t.getClass());
    }
}
