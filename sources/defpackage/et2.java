package defpackage;

/* renamed from: et2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class et2 extends ea3<et2, dt2> implements cm2 {
    private static final et2 zzf;
    private int zzb;
    private g93 zze = g93.g;

    static {
        et2 et2 = new et2();
        zzf = et2;
        ea3.r(et2.class, et2);
    }

    public static et2 u(g93 g93, s93 s93) throws ma3 {
        return (et2) ea3.f(zzf, g93, s93);
    }

    public static dt2 v() {
        return (dt2) zzf.n();
    }

    public static /* synthetic */ void y(et2 et2, g93 g93) {
        g93.getClass();
        et2.zze = g93;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new et2();
        } else {
            if (i2 == 4) {
                return new dt2(null);
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
