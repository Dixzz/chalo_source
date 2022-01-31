package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: nw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class nw3 {
    public static final nw3 c = new nw3();

    /* renamed from: a  reason: collision with root package name */
    public final pw3 f2613a = new pv3();
    public final ConcurrentMap<Class<?>, qw3<?>> b = new ConcurrentHashMap();

    public final <T> qw3<T> a(Class<T> cls) {
        qw3<T> qw3;
        gw3 gw3;
        Class<?> cls2;
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(cls, "messageType");
        qw3<T> qw32 = (qw3<T>) this.b.get(cls);
        if (qw32 != null) {
            return qw32;
        }
        pv3 pv3 = (pv3) this.f2613a;
        Objects.requireNonNull(pv3);
        Class<?> cls3 = sw3.f3265a;
        if (ru3.class.isAssignableFrom(cls) || (cls2 = sw3.f3265a) == null || cls2.isAssignableFrom(cls)) {
            aw3 a2 = pv3.f2858a.a(cls);
            if (a2.zzb()) {
                if (ru3.class.isAssignableFrom(cls)) {
                    ex3<?, ?> ex3 = sw3.d;
                    gu3<?> gu3 = hu3.f1429a;
                    gw3 = new gw3(ex3, hu3.f1429a, a2.zzc());
                } else {
                    ex3<?, ?> ex32 = sw3.b;
                    gu3<?> gu32 = hu3.b;
                    if (gu32 != null) {
                        gw3 = new gw3(ex32, gu32, a2.zzc());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                qw3 = gw3;
            } else {
                boolean z = false;
                if (ru3.class.isAssignableFrom(cls)) {
                    if (a2.zza() == 1) {
                        z = true;
                    }
                    if (z) {
                        iw3 iw3 = kw3.b;
                        mv3 mv3 = mv3.b;
                        ex3<?, ?> ex33 = sw3.d;
                        gu3<?> gu33 = hu3.f1429a;
                        qw3 = ew3.m(a2, iw3, mv3, ex33, hu3.f1429a, xv3.b);
                    } else {
                        qw3 = ew3.m(a2, kw3.b, mv3.b, sw3.d, null, xv3.b);
                    }
                } else {
                    if (a2.zza() == 1) {
                        z = true;
                    }
                    if (z) {
                        iw3 iw32 = kw3.f2128a;
                        mv3 mv32 = mv3.f2449a;
                        ex3<?, ?> ex34 = sw3.b;
                        gu3<?> gu34 = hu3.b;
                        if (gu34 != null) {
                            qw3 = ew3.m(a2, iw32, mv32, ex34, gu34, xv3.f3968a);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        qw3 = ew3.m(a2, kw3.f2128a, mv3.f2449a, sw3.c, null, xv3.f3968a);
                    }
                }
            }
            qw3<T> qw33 = (qw3<T>) this.b.putIfAbsent(cls, qw3);
            return qw33 != null ? qw33 : qw3;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public final <T> qw3<T> b(T t) {
        return a(t.getClass());
    }
}
