package defpackage;

/* renamed from: xu2 */
public final class xu2 extends ea3<xu2, uu2> implements cm2 {
    private static final xu2 zzg;
    private String zzb = "";
    private g93 zze = g93.g;
    private int zzf;

    static {
        xu2 xu2 = new xu2();
        zzg = xu2;
        ea3.r(xu2.class, xu2);
    }

    public static uu2 v() {
        return (uu2) zzg.n();
    }

    public static xu2 w() {
        return zzg;
    }

    public static /* synthetic */ void y(xu2 xu2, String str) {
        str.getClass();
        xu2.zzb = str;
    }

    public static /* synthetic */ void z(xu2 xu2, g93 g93) {
        g93.getClass();
        xu2.zze = g93;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new xu2();
        } else {
            if (i2 == 4) {
                return new uu2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final String s() {
        return this.zzb;
    }

    public final g93 t() {
        return this.zze;
    }

    public final wu2 u() {
        wu2 zzb2 = wu2.zzb(this.zzf);
        return zzb2 == null ? wu2.UNRECOGNIZED : zzb2;
    }
}
