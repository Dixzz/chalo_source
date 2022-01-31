package defpackage;

/* renamed from: ks2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ks2 extends ea3<ks2, js2> implements cm2 {
    private static final ks2 zzg;
    private int zzb;
    private qs2 zze;
    private g93 zzf = g93.g;

    static {
        ks2 ks2 = new ks2();
        zzg = ks2;
        ea3.r(ks2.class, ks2);
    }

    public static /* synthetic */ void A(ks2 ks2, g93 g93) {
        g93.getClass();
        ks2.zzf = g93;
    }

    public static ks2 v(g93 g93, s93 s93) throws ma3 {
        return (ks2) ea3.f(zzg, g93, s93);
    }

    public static js2 w() {
        return (js2) zzg.n();
    }

    public static /* synthetic */ void z(ks2 ks2, qs2 qs2) {
        qs2.getClass();
        ks2.zze = qs2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new ks2();
        } else {
            if (i2 == 4) {
                return new js2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final int s() {
        return this.zzb;
    }

    public final qs2 t() {
        qs2 qs2 = this.zze;
        return qs2 == null ? qs2.u() : qs2;
    }

    public final g93 u() {
        return this.zzf;
    }
}
