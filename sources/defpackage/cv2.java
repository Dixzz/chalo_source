package defpackage;

/* renamed from: cv2 */
public final class cv2 extends ea3<cv2, bv2> implements cm2 {
    private static final cv2 zzg;
    private String zzb = "";
    private g93 zze = g93.g;
    private int zzf;

    static {
        cv2 cv2 = new cv2();
        zzg = cv2;
        ea3.r(cv2.class, cv2);
    }

    public static bv2 v() {
        return (bv2) zzg.n();
    }

    public static cv2 w() {
        return zzg;
    }

    public static /* synthetic */ void y(cv2 cv2, String str) {
        str.getClass();
        cv2.zzb = str;
    }

    public static /* synthetic */ void z(cv2 cv2, g93 g93) {
        g93.getClass();
        cv2.zze = g93;
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
            return new cv2();
        } else {
            if (i2 == 4) {
                return new bv2(null);
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

    public final bw2 u() {
        bw2 zzb2 = bw2.zzb(this.zzf);
        return zzb2 == null ? bw2.UNRECOGNIZED : zzb2;
    }
}
