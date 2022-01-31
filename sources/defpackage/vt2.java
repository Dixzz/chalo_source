package defpackage;

/* renamed from: vt2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vt2 extends ea3<vt2, ut2> implements cm2 {
    private static final vt2 zzg;
    private int zzb;
    private yt2 zze;
    private g93 zzf = g93.g;

    static {
        vt2 vt2 = new vt2();
        zzg = vt2;
        ea3.r(vt2.class, vt2);
    }

    public static /* synthetic */ void A(vt2 vt2, g93 g93) {
        g93.getClass();
        vt2.zzf = g93;
    }

    public static vt2 v(g93 g93, s93 s93) throws ma3 {
        return (vt2) ea3.f(zzg, g93, s93);
    }

    public static ut2 w() {
        return (ut2) zzg.n();
    }

    public static /* synthetic */ void z(vt2 vt2, yt2 yt2) {
        yt2.getClass();
        vt2.zze = yt2;
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
            return new vt2();
        } else {
            if (i2 == 4) {
                return new ut2(null);
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

    public final yt2 t() {
        yt2 yt2 = this.zze;
        return yt2 == null ? yt2.y() : yt2;
    }

    public final g93 u() {
        return this.zzf;
    }
}
