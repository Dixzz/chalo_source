package defpackage;

/* renamed from: ns2 */
public final class ns2 extends ea3<ns2, ms2> implements cm2 {
    private static final ns2 zzf;
    private qs2 zzb;
    private int zze;

    static {
        ns2 ns2 = new ns2();
        zzf = ns2;
        ea3.r(ns2.class, ns2);
    }

    public static ns2 u(g93 g93, s93 s93) {
        return (ns2) ea3.f(zzf, g93, s93);
    }

    public static ms2 v() {
        return (ms2) zzf.n();
    }

    public static /* synthetic */ void x(ns2 ns2, qs2 qs2) {
        qs2.getClass();
        ns2.zzb = qs2;
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
            return new ns2();
        } else {
            if (i2 == 4) {
                return new ms2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final qs2 s() {
        qs2 qs2 = this.zzb;
        return qs2 == null ? qs2.u() : qs2;
    }

    public final int t() {
        return this.zze;
    }
}
