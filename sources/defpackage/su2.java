package defpackage;

/* renamed from: su2 */
public final class su2 extends ea3<su2, ru2> implements cm2 {
    private static final su2 zzf;
    private int zzb;
    private int zze;

    static {
        su2 su2 = new su2();
        zzf = su2;
        ea3.r(su2.class, su2);
    }

    public static ru2 u() {
        return (ru2) zzf.n();
    }

    public static su2 v() {
        return zzf;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new su2();
        } else {
            if (i2 == 4) {
                return new ru2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final ju2 s() {
        ju2 zzb2 = ju2.zzb(this.zzb);
        return zzb2 == null ? ju2.UNRECOGNIZED : zzb2;
    }

    public final int t() {
        return this.zze;
    }
}
