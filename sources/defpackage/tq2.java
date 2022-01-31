package defpackage;

@Deprecated
/* renamed from: tq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class tq2 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3393a;
    public static final cv2 b;

    static {
        byte[] bArr = new byte[0];
        f3393a = bArr;
        du2 du2 = du2.NIST_P256;
        ju2 ju2 = ju2.SHA256;
        jt2 jt2 = jt2.UNCOMPRESSED;
        cv2 cv2 = ap2.f275a;
        bw2 bw2 = bw2.TINK;
        b = a(du2, ju2, jt2, cv2, bw2, bArr);
        a(du2, ju2, jt2.COMPRESSED, cv2, bw2.RAW, bArr);
        a(du2, ju2, jt2, ap2.b, bw2, bArr);
    }

    public static cv2 a(du2 du2, ju2 ju2, jt2 jt2, cv2 cv2, bw2 bw2, byte[] bArr) {
        ot2 u = pt2.u();
        au2 v = bu2.v();
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((bu2) v.g).zzb = du2.zza();
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((bu2) v.g).zze = ju2.zza();
        g93 A = g93.A(bArr, 0, bArr.length);
        if (v.h) {
            v.a();
            v.h = false;
        }
        bu2.A((bu2) v.g, A);
        bu2 bu2 = (bu2) v.c();
        lt2 t = mt2.t();
        if (t.h) {
            t.a();
            t.h = false;
        }
        mt2.w((mt2) t.g, cv2);
        mt2 mt2 = (mt2) t.c();
        rt2 v2 = st2.v();
        if (v2.h) {
            v2.a();
            v2.h = false;
        }
        st2.y((st2) v2.g, bu2);
        if (v2.h) {
            v2.a();
            v2.h = false;
        }
        st2.z((st2) v2.g, mt2);
        if (v2.h) {
            v2.a();
            v2.h = false;
        }
        st2.A((st2) v2.g, jt2);
        st2 st2 = (st2) v2.c();
        if (u.h) {
            u.a();
            u.h = false;
        }
        pt2.w((pt2) u.g, st2);
        bv2 v3 = cv2.v();
        new kq2();
        v3.f("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        v3.h(bw2);
        v3.g(((pt2) u.c()).j());
        return (cv2) v3.c();
    }
}
