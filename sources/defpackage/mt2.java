package defpackage;

/* renamed from: mt2 */
public final class mt2 extends ea3<mt2, lt2> implements cm2 {
    private static final mt2 zze;
    private cv2 zzb;

    static {
        mt2 mt2 = new mt2();
        zze = mt2;
        ea3.r(mt2.class, mt2);
    }

    public static lt2 t() {
        return (lt2) zze.n();
    }

    public static mt2 u() {
        return zze;
    }

    public static /* synthetic */ void w(mt2 mt2, cv2 cv2) {
        cv2.getClass();
        mt2.zzb = cv2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zze, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new mt2();
        } else {
            if (i2 == 4) {
                return new lt2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final cv2 s() {
        cv2 cv2 = this.zzb;
        return cv2 == null ? cv2.w() : cv2;
    }
}
