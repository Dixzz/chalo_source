package defpackage;

@Deprecated
/* renamed from: ap2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ap2 {

    /* renamed from: a  reason: collision with root package name */
    public static final cv2 f275a = a(16);
    public static final cv2 b;

    static {
        a(32);
        b(16, 16);
        b(32, 16);
        ju2 ju2 = ju2.SHA256;
        b = c(16, 16, 32, 16, ju2);
        c(32, 16, 32, 32, ju2);
        bv2 v = cv2.v();
        new vp2();
        v.f("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        bw2 bw2 = bw2.TINK;
        v.h(bw2);
        cv2 cv2 = (cv2) v.c();
        bv2 v2 = cv2.v();
        new fq2();
        v2.f("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        v2.h(bw2);
        cv2 cv22 = (cv2) v2.c();
    }

    public static cv2 a(int i) {
        vs2 u = ws2.u();
        if (u.h) {
            u.a();
            u.h = false;
        }
        ((ws2) u.g).zzb = i;
        bv2 v = cv2.v();
        v.g(((ws2) u.c()).j());
        new pp2();
        v.f("type.googleapis.com/google.crypto.tink.AesGcmKey");
        v.h(bw2.TINK);
        return (cv2) v.c();
    }

    public static cv2 b(int i, int i2) {
        ms2 v = ns2.v();
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((ns2) v.g).zze = i;
        ps2 t = qs2.t();
        if (t.h) {
            t.a();
            t.h = false;
        }
        ((qs2) t.g).zzb = 16;
        qs2 qs2 = (qs2) t.c();
        if (v.h) {
            v.a();
            v.h = false;
        }
        ns2.x((ns2) v.g, qs2);
        bv2 v2 = cv2.v();
        v2.g(((ns2) v.c()).j());
        new lp2();
        v2.f("type.googleapis.com/google.crypto.tink.AesEaxKey");
        v2.h(bw2.TINK);
        return (cv2) v2.c();
    }

    public static cv2 c(int i, int i2, int i3, int i4, ju2 ju2) {
        ds2 v = es2.v();
        gs2 t = hs2.t();
        if (t.h) {
            t.a();
            t.h = false;
        }
        ((hs2) t.g).zzb = 16;
        hs2 hs2 = (hs2) t.c();
        if (v.h) {
            v.a();
            v.h = false;
        }
        es2.y((es2) v.g, hs2);
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((es2) v.g).zze = i;
        es2 es2 = (es2) v.c();
        ou2 v2 = pu2.v();
        ru2 u = su2.u();
        if (u.h) {
            u.a();
            u.h = false;
        }
        ((su2) u.g).zzb = ju2.zza();
        if (u.h) {
            u.a();
            u.h = false;
        }
        ((su2) u.g).zze = i4;
        su2 su2 = (su2) u.c();
        if (v2.h) {
            v2.a();
            v2.h = false;
        }
        pu2.y((pu2) v2.g, su2);
        if (v2.h) {
            v2.a();
            v2.h = false;
        }
        ((pu2) v2.g).zze = 32;
        pu2 pu2 = (pu2) v2.c();
        xr2 v3 = yr2.v();
        if (v3.h) {
            v3.a();
            v3.h = false;
        }
        yr2.x((yr2) v3.g, es2);
        if (v3.h) {
            v3.a();
            v3.h = false;
        }
        yr2.y((yr2) v3.g, pu2);
        bv2 v4 = cv2.v();
        v4.g(((yr2) v3.c()).j());
        new fp2();
        v4.f("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        v4.h(bw2.TINK);
        return (cv2) v4.c();
    }
}
