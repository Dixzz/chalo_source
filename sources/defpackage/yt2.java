package defpackage;

/* renamed from: yt2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class yt2 extends ea3<yt2, xt2> implements cm2 {
    private static final yt2 zzh;
    private int zzb;
    private st2 zze;
    private g93 zzf;
    private g93 zzg;

    static {
        yt2 yt2 = new yt2();
        zzh = yt2;
        ea3.r(yt2.class, yt2);
    }

    public yt2() {
        g93 g93 = g93.g;
        this.zzf = g93;
        this.zzg = g93;
    }

    public static /* synthetic */ void B(yt2 yt2, st2 st2) {
        st2.getClass();
        yt2.zze = st2;
    }

    public static /* synthetic */ void C(yt2 yt2, g93 g93) {
        g93.getClass();
        yt2.zzf = g93;
    }

    public static /* synthetic */ void D(yt2 yt2, g93 g93) {
        g93.getClass();
        yt2.zzg = g93;
    }

    public static yt2 w(g93 g93, s93 s93) throws ma3 {
        return (yt2) ea3.f(zzh, g93, s93);
    }

    public static xt2 x() {
        return (xt2) zzh.n();
    }

    public static yt2 y() {
        return zzh;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new yt2();
        } else {
            if (i2 == 4) {
                return new xt2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final int s() {
        return this.zzb;
    }

    public final st2 t() {
        st2 st2 = this.zze;
        return st2 == null ? st2.w() : st2;
    }

    public final g93 u() {
        return this.zzf;
    }

    public final g93 v() {
        return this.zzg;
    }
}
