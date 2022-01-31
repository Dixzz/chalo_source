package defpackage;

/* renamed from: qs2 */
public final class qs2 extends ea3<qs2, ps2> implements cm2 {
    private static final qs2 zze;
    private int zzb;

    static {
        qs2 qs2 = new qs2();
        zze = qs2;
        ea3.r(qs2.class, qs2);
    }

    public static ps2 t() {
        return (ps2) zze.n();
    }

    public static qs2 u() {
        return zze;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new qs2();
        } else {
            if (i2 == 4) {
                return new ps2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final int s() {
        return this.zzb;
    }
}
