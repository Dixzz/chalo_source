package defpackage;

import java.nio.charset.Charset;

/* renamed from: ph2  reason: default package */
public final class ph2 implements qi2 {
    public static final yh2 b = new qh2();

    /* renamed from: a  reason: collision with root package name */
    public final yh2 f2804a;

    public ph2() {
        yh2 yh2;
        yh2[] yh2Arr = new yh2[2];
        yh2Arr[0] = tg2.f3351a;
        try {
            yh2 = (yh2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            yh2 = b;
        }
        yh2Arr[1] = yh2;
        rh2 rh2 = new rh2(yh2Arr);
        Charset charset = wg2.f3775a;
        this.f2804a = rh2;
    }

    @Override // defpackage.qi2
    public final <T> pi2<T> a(Class<T> cls) {
        fi2 fi2;
        kh2 kh2;
        dj2<?, ?> dj2;
        hg2<?> hg2;
        uh2 uh2;
        Class<?> cls2;
        Class<?> cls3 = ri2.f3084a;
        if (ug2.class.isAssignableFrom(cls) || (cls2 = ri2.f3084a) == null || cls2.isAssignableFrom(cls)) {
            xh2 a2 = this.f2804a.a(cls);
            boolean b2 = a2.b();
            boolean isAssignableFrom = ug2.class.isAssignableFrom(cls);
            if (!b2) {
                boolean z = false;
                if (isAssignableFrom) {
                    if (a2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        fi2 = hi2.b;
                        kh2 = kh2.b;
                        dj2 = ri2.d;
                        hg2<?> hg22 = kg2.f2054a;
                        hg2 = kg2.f2054a;
                    } else {
                        fi2 = hi2.b;
                        kh2 = kh2.b;
                        dj2 = ri2.d;
                        hg2 = null;
                    }
                    uh2 = wh2.b;
                } else {
                    if (a2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        fi2 fi22 = hi2.f1376a;
                        kh2 = kh2.f2059a;
                        dj2 = ri2.b;
                        hg2 = kg2.b;
                        if (hg2 != null) {
                            uh2 = wh2.f3782a;
                            fi2 = fi22;
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        fi2 = hi2.f1376a;
                        kh2 = kh2.f2059a;
                        dj2 = ri2.c;
                        hg2 = null;
                        uh2 = wh2.f3782a;
                    }
                }
                return ci2.q(a2, fi2, kh2, dj2, hg2, uh2);
            } else if (isAssignableFrom) {
                dj2<?, ?> dj22 = ri2.d;
                hg2<?> hg23 = kg2.f2054a;
                return new di2(dj22, kg2.f2054a, a2.c());
            } else {
                dj2<?, ?> dj23 = ri2.b;
                hg2<?> hg24 = kg2.b;
                if (hg24 != null) {
                    return new di2(dj23, hg24, a2.c());
                }
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
        } else {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }
}
