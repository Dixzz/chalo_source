package defpackage;

/* renamed from: mu2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class mu2 extends ea3<mu2, lu2> implements cm2 {
    private static final mu2 zzg;
    private int zzb;
    private su2 zze;
    private g93 zzf = g93.g;

    static {
        mu2 mu2 = new mu2();
        zzg = mu2;
        ea3.r(mu2.class, mu2);
    }

    public static /* synthetic */ void A(mu2 mu2, su2 su2) {
        su2.getClass();
        mu2.zze = su2;
    }

    public static /* synthetic */ void B(mu2 mu2, g93 g93) {
        g93.getClass();
        mu2.zzf = g93;
    }

    public static mu2 v(g93 g93, s93 s93) throws ma3 {
        return (mu2) ea3.f(zzg, g93, s93);
    }

    public static lu2 w() {
        return (lu2) zzg.n();
    }

    public static mu2 x() {
        return zzg;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new mu2();
        } else {
            if (i2 == 4) {
                return new lu2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final int s() {
        return this.zzb;
    }

    public final su2 t() {
        su2 su2 = this.zze;
        return su2 == null ? su2.v() : su2;
    }

    public final g93 u() {
        return this.zzf;
    }
}
