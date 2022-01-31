package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: t15  reason: default package */
/* compiled from: Protobuf */
public final class t15 {
    public static final t15 c = new t15();

    /* renamed from: a  reason: collision with root package name */
    public final y15 f3295a = new b15();
    public final ConcurrentMap<Class<?>, x15<?>> b = new ConcurrentHashMap();

    public <T> x15<T> a(Class<T> cls) {
        x15<T> x15;
        m15 m15;
        Class<?> cls2;
        Charset charset = s05.f3160a;
        Objects.requireNonNull(cls, "messageType");
        x15<T> x152 = (x15<T>) this.b.get(cls);
        if (x152 != null) {
            return x152;
        }
        b15 b15 = (b15) this.f3295a;
        Objects.requireNonNull(b15);
        Class<?> cls3 = z15.f4109a;
        if (q05.class.isAssignableFrom(cls) || (cls2 = z15.f4109a) == null || cls2.isAssignableFrom(cls)) {
            h15 a2 = b15.f365a.a(cls);
            if (a2.a()) {
                if (q05.class.isAssignableFrom(cls)) {
                    e25<?, ?> e25 = z15.d;
                    j05<?> j05 = l05.f2147a;
                    m15 = new m15(e25, l05.f2147a, a2.b());
                } else {
                    e25<?, ?> e252 = z15.b;
                    j05<?> j052 = l05.b;
                    if (j052 != null) {
                        m15 = new m15(e252, j052, a2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                x15 = m15;
            } else {
                boolean z = true;
                if (q05.class.isAssignableFrom(cls)) {
                    if (a2.c() != s15.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        n15 n15 = p15.b;
                        z05 z05 = z05.b;
                        e25<?, ?> e253 = z15.d;
                        j05<?> j053 = l05.f2147a;
                        x15 = l15.B(a2, n15, z05, e253, l05.f2147a, g15.b);
                    } else {
                        x15 = l15.B(a2, p15.b, z05.b, z15.d, null, g15.b);
                    }
                } else {
                    if (a2.c() != s15.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        n15 n152 = p15.f2759a;
                        z05 z052 = z05.f4107a;
                        e25<?, ?> e254 = z15.b;
                        j05<?> j054 = l05.b;
                        if (j054 != null) {
                            x15 = l15.B(a2, n152, z052, e254, j054, g15.f1204a);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        x15 = l15.B(a2, p15.f2759a, z05.f4107a, z15.c, null, g15.f1204a);
                    }
                }
            }
            x15<T> x153 = (x15<T>) this.b.putIfAbsent(cls, x15);
            return x153 != null ? x153 : x15;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public <T> x15<T> b(T t) {
        return a(t.getClass());
    }
}
