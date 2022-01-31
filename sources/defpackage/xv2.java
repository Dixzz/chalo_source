package defpackage;

/* renamed from: xv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xv2 extends ea3<xv2, wv2> implements cm2 {
    private static final xv2 zzf;
    private int zzb;
    private zv2 zze;

    static {
        xv2 xv2 = new xv2();
        zzf = xv2;
        ea3.r(xv2.class, xv2);
    }

    public static xv2 u(g93 g93, s93 s93) throws ma3 {
        return (xv2) ea3.f(zzf, g93, s93);
    }

    public static wv2 v() {
        return (wv2) zzf.n();
    }

    public static /* synthetic */ void y(xv2 xv2, zv2 zv2) {
        zv2.getClass();
        xv2.zze = zv2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new xv2();
        } else {
            if (i2 == 4) {
                return new wv2(null);
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

    public final zv2 t() {
        zv2 zv2 = this.zze;
        return zv2 == null ? zv2.v() : zv2;
    }
}
