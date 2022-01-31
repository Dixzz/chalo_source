package defpackage;

/* renamed from: gu2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gu2 extends ea3<gu2, fu2> implements cm2 {
    private static final gu2 zzf;
    private g93 zzb = g93.g;
    private pv2 zze;

    static {
        gu2 gu2 = new gu2();
        zzf = gu2;
        ea3.r(gu2.class, gu2);
    }

    public static gu2 t(byte[] bArr, s93 s93) throws ma3 {
        return (gu2) ea3.g(zzf, bArr, s93);
    }

    public static fu2 u() {
        return (fu2) zzf.n();
    }

    public static /* synthetic */ void w(gu2 gu2, g93 g93) {
        g93.getClass();
        gu2.zzb = g93;
    }

    public static /* synthetic */ void x(gu2 gu2, pv2 pv2) {
        pv2.getClass();
        gu2.zze = pv2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new gu2();
        } else {
            if (i2 == 4) {
                return new fu2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final g93 s() {
        return this.zzb;
    }
}
