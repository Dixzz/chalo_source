package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: im2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class im2 {
    public static final im2 c = new im2();

    /* renamed from: a  reason: collision with root package name */
    public final nm2 f1535a = new ul2();
    public final ConcurrentMap<Class<?>, mm2<?>> b = new ConcurrentHashMap();

    public final <T> mm2<T> a(Class<T> cls) {
        em2 em2;
        Class<?> cls2;
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(cls, "messageType");
        dm2 dm2 = (mm2<T>) this.b.get(cls);
        if (dm2 == null) {
            ul2 ul2 = (ul2) this.f1535a;
            Objects.requireNonNull(ul2);
            Class<?> cls3 = om2.f2710a;
            if (ea3.class.isAssignableFrom(cls) || (cls2 = om2.f2710a) == null || cls2.isAssignableFrom(cls)) {
                zl2 b2 = ul2.f3523a.b(cls);
                if (b2.zza()) {
                    if (ea3.class.isAssignableFrom(cls)) {
                        zm2<?, ?> zm2 = om2.d;
                        t93<?> t93 = v93.f3620a;
                        em2 = new em2(zm2, v93.f3620a, b2.zzb());
                    } else {
                        zm2<?, ?> zm22 = om2.b;
                        t93<?> t932 = v93.b;
                        if (t932 != null) {
                            em2 = new em2(zm22, t932, b2.zzb());
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    }
                    dm2 = em2;
                } else {
                    boolean z = false;
                    if (ea3.class.isAssignableFrom(cls)) {
                        if (b2.zzc() == 1) {
                            z = true;
                        }
                        if (z) {
                            fm2 fm2 = gm2.b;
                            ql2 ql2 = ql2.b;
                            zm2<?, ?> zm23 = om2.d;
                            t93<?> t933 = v93.f3620a;
                            dm2 = dm2.F(b2, fm2, ql2, zm23, v93.f3620a, yl2.b);
                        } else {
                            dm2 = dm2.F(b2, gm2.b, ql2.b, om2.d, null, yl2.b);
                        }
                    } else {
                        if (b2.zzc() == 1) {
                            z = true;
                        }
                        if (z) {
                            fm2 fm22 = gm2.f1281a;
                            ql2 ql22 = ql2.f2959a;
                            zm2<?, ?> zm24 = om2.b;
                            t93<?> t934 = v93.b;
                            if (t934 != null) {
                                dm2 = dm2.F(b2, fm22, ql22, zm24, t934, yl2.f4065a);
                            } else {
                                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                            }
                        } else {
                            dm2 = dm2.F(b2, gm2.f1281a, ql2.f2959a, om2.c, null, yl2.f4065a);
                        }
                    }
                }
                mm2<?> putIfAbsent = this.b.putIfAbsent(cls, dm2);
                return putIfAbsent == null ? dm2 : putIfAbsent;
            }
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }
}
