package defpackage;

/* renamed from: bu2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bu2 extends ea3<bu2, au2> implements cm2 {
    private static final bu2 zzg;
    private int zzb;
    private int zze;
    private g93 zzf = g93.g;

    static {
        bu2 bu2 = new bu2();
        zzg = bu2;
        ea3.r(bu2.class, bu2);
    }

    public static /* synthetic */ void A(bu2 bu2, g93 g93) {
        g93.getClass();
        bu2.zzf = g93;
    }

    public static au2 v() {
        return (au2) zzg.n();
    }

    public static bu2 w() {
        return zzg;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new bu2();
        } else {
            if (i2 == 4) {
                return new au2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final du2 s() {
        du2 zzb2 = du2.zzb(this.zzb);
        return zzb2 == null ? du2.UNRECOGNIZED : zzb2;
    }

    public final ju2 t() {
        ju2 zzb2 = ju2.zzb(this.zze);
        return zzb2 == null ? ju2.UNRECOGNIZED : zzb2;
    }

    public final g93 u() {
        return this.zzf;
    }
}
