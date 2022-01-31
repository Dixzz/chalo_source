package defpackage;

/* renamed from: ov2 */
public final class ov2 extends ea3<ov2, nv2> implements cm2 {
    private static final ov2 zzh;
    private String zzb = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        ov2 ov2 = new ov2();
        zzh = ov2;
        ea3.r(ov2.class, ov2);
    }

    public static nv2 t() {
        return (nv2) zzh.n();
    }

    public static /* synthetic */ void v(ov2 ov2, String str) {
        str.getClass();
        ov2.zzb = str;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new ov2();
        } else {
            if (i2 == 4) {
                return new nv2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final int s() {
        return this.zzf;
    }
}
