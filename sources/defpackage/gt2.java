package defpackage;

/* renamed from: gt2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gt2 extends ea3<gt2, ft2> implements cm2 {
    private static final gt2 zzb;

    static {
        gt2 gt2 = new gt2();
        zzb = gt2;
        ea3.r(gt2.class, gt2);
    }

    public static gt2 s(g93 g93, s93 s93) throws ma3 {
        return (gt2) ea3.f(zzb, g93, s93);
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
            return new gt2();
        }
        if (i2 == 4) {
            return new ft2();
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
