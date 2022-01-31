package defpackage;

/* renamed from: vr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vr2 extends ea3<vr2, ur2> implements cm2 {
    private static final vr2 zzg;
    private int zzb;
    private bs2 zze;
    private mu2 zzf;

    static {
        vr2 vr2 = new vr2();
        zzg = vr2;
        ea3.r(vr2.class, vr2);
    }

    public static /* synthetic */ void A(vr2 vr2, mu2 mu2) {
        mu2.getClass();
        vr2.zzf = mu2;
    }

    public static vr2 v(g93 g93, s93 s93) throws ma3 {
        return (vr2) ea3.f(zzg, g93, s93);
    }

    public static ur2 w() {
        return (ur2) zzg.n();
    }

    public static /* synthetic */ void z(vr2 vr2, bs2 bs2) {
        bs2.getClass();
        vr2.zze = bs2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new vr2();
        } else {
            if (i2 == 4) {
                return new ur2(null);
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

    public final bs2 t() {
        bs2 bs2 = this.zze;
        return bs2 == null ? bs2.x() : bs2;
    }

    public final mu2 u() {
        mu2 mu2 = this.zzf;
        return mu2 == null ? mu2.x() : mu2;
    }
}
