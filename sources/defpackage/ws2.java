package defpackage;

/* renamed from: ws2 */
public final class ws2 extends ea3<ws2, vs2> implements cm2 {
    private static final ws2 zzf;
    private int zzb;
    private int zze;

    static {
        ws2 ws2 = new ws2();
        zzf = ws2;
        ea3.r(ws2.class, ws2);
    }

    public static ws2 t(g93 g93, s93 s93) {
        return (ws2) ea3.f(zzf, g93, s93);
    }

    public static vs2 u() {
        return (vs2) zzf.n();
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new ws2();
        } else {
            if (i2 == 4) {
                return new vs2(null);
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
}
