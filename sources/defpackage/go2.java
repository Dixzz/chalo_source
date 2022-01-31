package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* renamed from: go2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class go2 {

    /* renamed from: a  reason: collision with root package name */
    public final kv2 f1289a;

    public go2(kv2 kv2) {
        this.f1289a = kv2;
    }

    public static final go2 a(kv2 kv2) throws GeneralSecurityException {
        if (kv2.u() > 0) {
            return new go2(kv2);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static final go2 f(ar2 ar2, vn2 vn2) throws GeneralSecurityException, IOException {
        gu2 t = gu2.t(ar2.a(), s93.a());
        if (t.s().e() != 0) {
            try {
                kv2 w = kv2.w(vn2.b(t.s().C(), new byte[0]), s93.a());
                if (w.u() > 0) {
                    return new go2(w);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (ma3 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final void b(io2 io2, vn2 vn2) throws GeneralSecurityException, IOException {
        kv2 kv2 = this.f1289a;
        byte[] a2 = vn2.a(kv2.a(), new byte[0]);
        try {
            if (kv2.w(vn2.b(a2, new byte[0]), s93.a()).equals(kv2)) {
                fu2 u = gu2.u();
                g93 B = g93.B(a2);
                if (u.h) {
                    u.a();
                    u.h = false;
                }
                gu2.w((gu2) u.g, B);
                pv2 a3 = yo2.a(kv2);
                if (u.h) {
                    u.a();
                    u.h = false;
                }
                gu2.x((gu2) u.g, a3);
                io2.b((gu2) u.c());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (ma3 unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(defpackage.io2 r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.go2.c(io2):void");
    }

    public final go2 d() throws GeneralSecurityException {
        if (this.f1289a != null) {
            gv2 x = kv2.x();
            for (jv2 jv2 : this.f1289a.t()) {
                xu2 t = jv2.t();
                if (t.u() == wu2.ASYMMETRIC_PRIVATE) {
                    String s = t.s();
                    g93 t2 = t.t();
                    ao2 i = xo2.i(s, null);
                    if (i instanceof ro2) {
                        ro2 ro2 = (ro2) i;
                        Objects.requireNonNull(ro2);
                        try {
                            vt2 v = vt2.v(t2, s93.a());
                            kq2.h(v);
                            yt2 t3 = v.t();
                            ro2.c.d(t3);
                            uu2 v2 = xu2.v();
                            if (v2.h) {
                                v2.a();
                                v2.h = false;
                            }
                            xu2.y((xu2) v2.g, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                            g93 j = t3.j();
                            if (v2.h) {
                                v2.a();
                                v2.h = false;
                            }
                            xu2.z((xu2) v2.g, j);
                            wu2 wu2 = wu2.ASYMMETRIC_PUBLIC;
                            if (v2.h) {
                                v2.a();
                                v2.h = false;
                            }
                            ((xu2) v2.g).zzf = wu2.zza();
                            xu2 xu2 = (xu2) v2.c();
                            xo2.j(xu2.s(), xu2.t(), null);
                            hv2 x2 = jv2.x();
                            x2.e(jv2);
                            if (x2.h) {
                                x2.a();
                                x2.h = false;
                            }
                            jv2.z((jv2) x2.g, xu2);
                            jv2 jv22 = (jv2) x2.c();
                            if (x.h) {
                                x.a();
                                x.h = false;
                            }
                            kv2.A((kv2) x.g, jv22);
                        } catch (ma3 e) {
                            throw new GeneralSecurityException("expected serialized proto of type ", e);
                        }
                    } else {
                        throw new GeneralSecurityException(hj1.b0(new StringBuilder(String.valueOf(s).length() + 48), "manager for key type ", s, " is not a PrivateKeyManager"));
                    }
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            int s2 = this.f1289a.s();
            if (x.h) {
                x.a();
                x.h = false;
            }
            ((kv2) x.g).zzb = s2;
            return new go2((kv2) x.c());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    public final <P> P e(Class<P> cls) throws GeneralSecurityException {
        String str;
        byte[] bArr;
        String str2;
        qo2<?, ?> qo2 = xo2.e.get(cls);
        Class<?> zzc = qo2 == null ? null : qo2.zzc();
        if (zzc == null) {
            String name = cls.getName();
            if (name.length() != 0) {
                str2 = "No wrapper found for ".concat(name);
            } else {
                str2 = new String("No wrapper found for ");
            }
            throw new GeneralSecurityException(str2);
        }
        kv2 kv2 = this.f1289a;
        int i = yo2.f4076a;
        int s = kv2.s();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (jv2 jv2 : kv2.t()) {
            if (jv2.u() == zu2.ENABLED) {
                if (!jv2.s()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(jv2.v())));
                } else if (jv2.w() == bw2.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(jv2.v())));
                } else if (jv2.u() != zu2.UNKNOWN_STATUS) {
                    if (jv2.v() == s) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= jv2.t().u() == wu2.ASYMMETRIC_PUBLIC;
                    i2++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(jv2.v())));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (z || z2) {
            po2<?> po2 = new po2<>(zzc);
            for (jv2 jv22 : this.f1289a.t()) {
                zu2 u = jv22.u();
                zu2 zu2 = zu2.ENABLED;
                if (u == zu2) {
                    xu2 t = jv22.t();
                    Object j = xo2.j(t.s(), t.t(), zzc);
                    if (jv22.u() == zu2) {
                        bw2 bw2 = bw2.UNKNOWN_PREFIX;
                        int ordinal = jv22.w().ordinal();
                        if (ordinal != 1) {
                            if (ordinal != 2) {
                                if (ordinal == 3) {
                                    bArr = xn2.f3943a;
                                } else if (ordinal != 4) {
                                    throw new GeneralSecurityException("unknown output prefix type");
                                }
                            }
                            bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(jv22.v()).array();
                        } else {
                            bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(jv22.v()).array();
                        }
                        no2 no2 = new no2(j, bArr, jv22.u(), jv22.w());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(no2);
                        byte[] bArr2 = no2.b;
                        oo2 oo2 = new oo2(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length));
                        List<no2<P>> put = po2.f2833a.put(oo2, Collections.unmodifiableList(arrayList));
                        if (put != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(put);
                            arrayList2.add(no2);
                            po2.f2833a.put(oo2, Collections.unmodifiableList(arrayList2));
                        }
                        if (jv22.v() != this.f1289a.s()) {
                            continue;
                        } else if (no2.c == zu2) {
                            byte[] bArr3 = no2.b;
                            if (po2.a(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length)).isEmpty()) {
                                throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
                            }
                        } else {
                            throw new IllegalArgumentException("the primary entry has to be ENABLED");
                        }
                    } else {
                        throw new GeneralSecurityException("only ENABLED key is allowed");
                    }
                }
            }
            qo2<?, ?> qo22 = xo2.e.get(cls);
            if (qo22 == null) {
                String name2 = po2.b.getName();
                if (name2.length() != 0) {
                    str = "No wrapper found for ".concat(name2);
                } else {
                    str = new String("No wrapper found for ");
                }
                throw new GeneralSecurityException(str);
            } else if (qo22.zzc().equals(po2.b)) {
                return (P) qo22.a(po2);
            } else {
                String valueOf = String.valueOf(qo22.zzc());
                String valueOf2 = String.valueOf(po2.b);
                throw new GeneralSecurityException(hj1.c0(new StringBuilder(valueOf.length() + 44 + valueOf2.length()), "Wrong input primitive class, expected ", valueOf, ", got ", valueOf2));
            }
        } else {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    public final String toString() {
        return yo2.a(this.f1289a).toString();
    }
}
