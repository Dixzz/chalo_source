package defpackage;

/* renamed from: iw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class iw2 extends ea3<iw2, hw2> implements cm2 {
    private static final iw2 zzb;

    static {
        iw2 iw2 = new iw2();
        zzb = iw2;
        ea3.r(iw2.class, iw2);
    }

    public static iw2 s(g93 g93, s93 s93) throws ma3 {
        return (iw2) ea3.f(zzb, g93, s93);
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzb, "\u0000\u0000", null);
        }
        if (i2 == 3) {
            return new iw2();
        }
        if (i2 == 4) {
            return new hw2();
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
