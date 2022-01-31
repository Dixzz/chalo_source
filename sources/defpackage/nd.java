package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: nd  reason: default package */
/* compiled from: Protobuf */
public final class nd {
    public static final nd c = new nd();

    /* renamed from: a  reason: collision with root package name */
    public final sd f2538a = new vc();
    public final ConcurrentMap<Class<?>, rd<?>> b = new ConcurrentHashMap();

    public <T> rd<T> a(Class<T> cls) {
        rd<T> rdVar;
        gd gdVar;
        Class<?> cls2;
        Charset charset = mc.f2352a;
        Objects.requireNonNull(cls, "messageType");
        rd<T> rdVar2 = (rd<T>) this.b.get(cls);
        if (rdVar2 != null) {
            return rdVar2;
        }
        vc vcVar = (vc) this.f2538a;
        Objects.requireNonNull(vcVar);
        Class<?> cls3 = td.f3335a;
        if (kc.class.isAssignableFrom(cls) || (cls2 = td.f3335a) == null || cls2.isAssignableFrom(cls)) {
            bd a2 = vcVar.f3628a.a(cls);
            if (a2.a()) {
                if (kc.class.isAssignableFrom(cls)) {
                    yd<?, ?> ydVar = td.d;
                    dc<?> dcVar = fc.f1111a;
                    gdVar = new gd(ydVar, fc.f1111a, a2.b());
                } else {
                    yd<?, ?> ydVar2 = td.b;
                    dc<?> dcVar2 = fc.b;
                    if (dcVar2 != null) {
                        gdVar = new gd(ydVar2, dcVar2, a2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                rdVar = gdVar;
            } else {
                boolean z = true;
                if (kc.class.isAssignableFrom(cls)) {
                    if (a2.c() != md.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        hd hdVar = jd.b;
                        tc tcVar = tc.b;
                        yd<?, ?> ydVar3 = td.d;
                        dc<?> dcVar3 = fc.f1111a;
                        rdVar = fd.y(a2, hdVar, tcVar, ydVar3, fc.f1111a, ad.b);
                    } else {
                        rdVar = fd.y(a2, jd.b, tc.b, td.d, null, ad.b);
                    }
                } else {
                    if (a2.c() != md.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        hd hdVar2 = jd.f1904a;
                        tc tcVar2 = tc.f3330a;
                        yd<?, ?> ydVar4 = td.b;
                        dc<?> dcVar4 = fc.b;
                        if (dcVar4 != null) {
                            rdVar = fd.y(a2, hdVar2, tcVar2, ydVar4, dcVar4, ad.f151a);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        rdVar = fd.y(a2, jd.f1904a, tc.f3330a, td.c, null, ad.f151a);
                    }
                }
            }
            rd<T> rdVar3 = (rd<T>) this.b.putIfAbsent(cls, rdVar);
            return rdVar3 != null ? rdVar3 : rdVar;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public <T> rd<T> b(T t) {
        return a(t.getClass());
    }
}
