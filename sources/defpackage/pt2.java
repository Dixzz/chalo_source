package defpackage;

/* renamed from: pt2 */
public final class pt2 extends ea3<pt2, ot2> implements cm2 {
    private static final pt2 zze;
    private st2 zzb;

    static {
        pt2 pt2 = new pt2();
        zze = pt2;
        ea3.r(pt2.class, pt2);
    }

    public static pt2 t(g93 g93, s93 s93) {
        return (pt2) ea3.f(zze, g93, s93);
    }

    public static ot2 u() {
        return (ot2) zze.n();
    }

    public static /* synthetic */ void w(pt2 pt2, st2 st2) {
        st2.getClass();
        pt2.zzb = st2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new pt2();
        } else {
            if (i2 == 4) {
                return new ot2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final st2 s() {
        st2 st2 = this.zzb;
        return st2 == null ? st2.w() : st2;
    }
}
