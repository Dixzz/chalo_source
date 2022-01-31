package defpackage;

/* renamed from: pu2 */
public final class pu2 extends ea3<pu2, ou2> implements cm2 {
    private static final pu2 zzg;
    private su2 zzb;
    private int zze;
    private int zzf;

    static {
        pu2 pu2 = new pu2();
        zzg = pu2;
        ea3.r(pu2.class, pu2);
    }

    public static pu2 u(g93 g93, s93 s93) {
        return (pu2) ea3.f(zzg, g93, s93);
    }

    public static ou2 v() {
        return (ou2) zzg.n();
    }

    public static pu2 w() {
        return zzg;
    }

    public static /* synthetic */ void y(pu2 pu2, su2 su2) {
        su2.getClass();
        pu2.zzb = su2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new pu2();
        } else {
            if (i2 == 4) {
                return new ou2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final su2 s() {
        su2 su2 = this.zzb;
        return su2 == null ? su2.v() : su2;
    }

    public final int t() {
        return this.zze;
    }
}
