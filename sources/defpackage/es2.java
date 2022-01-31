package defpackage;

/* renamed from: es2 */
public final class es2 extends ea3<es2, ds2> implements cm2 {
    private static final es2 zzf;
    private hs2 zzb;
    private int zze;

    static {
        es2 es2 = new es2();
        zzf = es2;
        ea3.r(es2.class, es2);
    }

    public static es2 u(g93 g93, s93 s93) {
        return (es2) ea3.f(zzf, g93, s93);
    }

    public static ds2 v() {
        return (ds2) zzf.n();
    }

    public static es2 w() {
        return zzf;
    }

    public static /* synthetic */ void y(es2 es2, hs2 hs2) {
        hs2.getClass();
        es2.zzb = hs2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new es2();
        } else {
            if (i2 == 4) {
                return new ds2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final hs2 s() {
        hs2 hs2 = this.zzb;
        return hs2 == null ? hs2.u() : hs2;
    }

    public final int t() {
        return this.zze;
    }
}
