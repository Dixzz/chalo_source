package defpackage;

/* renamed from: zv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zv2 extends ea3<zv2, yv2> implements cm2 {
    private static final zv2 zzf;
    private String zzb = "";
    private cv2 zze;

    static {
        zv2 zv2 = new zv2();
        zzf = zv2;
        ea3.r(zv2.class, zv2);
    }

    public static zv2 u(g93 g93, s93 s93) throws ma3 {
        return (zv2) ea3.f(zzf, g93, s93);
    }

    public static zv2 v() {
        return zzf;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zv2();
        } else {
            if (i2 == 4) {
                return new yv2();
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final String s() {
        return this.zzb;
    }

    public final cv2 t() {
        cv2 cv2 = this.zze;
        return cv2 == null ? cv2.w() : cv2;
    }
}
