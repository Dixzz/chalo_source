package defpackage;

/* renamed from: ts2 */
public final class ts2 extends ea3<ts2, ss2> implements cm2 {
    private static final ts2 zzf;
    private int zzb;
    private g93 zze = g93.g;

    static {
        ts2 ts2 = new ts2();
        zzf = ts2;
        ea3.r(ts2.class, ts2);
    }

    public static ts2 u(g93 g93, s93 s93) {
        return (ts2) ea3.f(zzf, g93, s93);
    }

    public static ss2 v() {
        return (ss2) zzf.n();
    }

    public static /* synthetic */ void y(ts2 ts2, g93 g93) {
        g93.getClass();
        ts2.zze = g93;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new ts2();
        } else {
            if (i2 == 4) {
                return new ss2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final int s() {
        return this.zzb;
    }

    public final g93 t() {
        return this.zze;
    }
}
