package defpackage;

/* renamed from: yr2 */
public final class yr2 extends ea3<yr2, xr2> implements cm2 {
    private static final yr2 zzf;
    private es2 zzb;
    private pu2 zze;

    static {
        yr2 yr2 = new yr2();
        zzf = yr2;
        ea3.r(yr2.class, yr2);
    }

    public static yr2 u(g93 g93, s93 s93) {
        return (yr2) ea3.f(zzf, g93, s93);
    }

    public static xr2 v() {
        return (xr2) zzf.n();
    }

    public static /* synthetic */ void x(yr2 yr2, es2 es2) {
        es2.getClass();
        yr2.zzb = es2;
    }

    public static /* synthetic */ void y(yr2 yr2, pu2 pu2) {
        pu2.getClass();
        yr2.zze = pu2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new yr2();
        } else {
            if (i2 == 4) {
                return new xr2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final es2 s() {
        es2 es2 = this.zzb;
        return es2 == null ? es2.w() : es2;
    }

    public final pu2 t() {
        pu2 pu2 = this.zze;
        return pu2 == null ? pu2.w() : pu2;
    }
}
