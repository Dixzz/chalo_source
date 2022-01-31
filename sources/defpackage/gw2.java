package defpackage;

/* renamed from: gw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gw2 extends ea3<gw2, fw2> implements cm2 {
    private static final gw2 zzf;
    private int zzb;
    private g93 zze = g93.g;

    static {
        gw2 gw2 = new gw2();
        zzf = gw2;
        ea3.r(gw2.class, gw2);
    }

    public static gw2 u(g93 g93, s93 s93) throws ma3 {
        return (gw2) ea3.f(zzf, g93, s93);
    }

    public static fw2 v() {
        return (fw2) zzf.n();
    }

    public static /* synthetic */ void y(gw2 gw2, g93 g93) {
        g93.getClass();
        gw2.zze = g93;
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
            return new gw2();
        } else {
            if (i2 == 4) {
                return new fw2(null);
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
