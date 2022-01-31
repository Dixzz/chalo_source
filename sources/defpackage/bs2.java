package defpackage;

/* renamed from: bs2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bs2 extends ea3<bs2, as2> implements cm2 {
    private static final bs2 zzg;
    private int zzb;
    private hs2 zze;
    private g93 zzf = g93.g;

    static {
        bs2 bs2 = new bs2();
        zzg = bs2;
        ea3.r(bs2.class, bs2);
    }

    public static /* synthetic */ void A(bs2 bs2, hs2 hs2) {
        hs2.getClass();
        bs2.zze = hs2;
    }

    public static /* synthetic */ void B(bs2 bs2, g93 g93) {
        g93.getClass();
        bs2.zzf = g93;
    }

    public static bs2 v(g93 g93, s93 s93) throws ma3 {
        return (bs2) ea3.f(zzg, g93, s93);
    }

    public static as2 w() {
        return (as2) zzg.n();
    }

    public static bs2 x() {
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
            return new bs2();
        } else {
            if (i2 == 4) {
                return new as2(null);
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

    public final hs2 t() {
        hs2 hs2 = this.zze;
        return hs2 == null ? hs2.u() : hs2;
    }

    public final g93 u() {
        return this.zzf;
    }
}
