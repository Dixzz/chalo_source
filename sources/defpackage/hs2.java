package defpackage;

/* renamed from: hs2 */
public final class hs2 extends ea3<hs2, gs2> implements cm2 {
    private static final hs2 zze;
    private int zzb;

    static {
        hs2 hs2 = new hs2();
        zze = hs2;
        ea3.r(hs2.class, hs2);
    }

    public static gs2 t() {
        return (gs2) zze.n();
    }

    public static hs2 u() {
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
            return new hs2();
        } else {
            if (i2 == 4) {
                return new gs2(null);
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
