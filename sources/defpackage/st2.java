package defpackage;

/* renamed from: st2 */
public final class st2 extends ea3<st2, rt2> implements cm2 {
    private static final st2 zzg;
    private bu2 zzb;
    private mt2 zze;
    private int zzf;

    static {
        st2 st2 = new st2();
        zzg = st2;
        ea3.r(st2.class, st2);
    }

    public static rt2 v() {
        return (rt2) zzg.n();
    }

    public static st2 w() {
        return zzg;
    }

    public static /* synthetic */ void y(st2 st2, bu2 bu2) {
        bu2.getClass();
        st2.zzb = bu2;
    }

    public static /* synthetic */ void z(st2 st2, mt2 mt2) {
        mt2.getClass();
        st2.zze = mt2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new st2();
        } else {
            if (i2 == 4) {
                return new rt2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final bu2 s() {
        bu2 bu2 = this.zzb;
        return bu2 == null ? bu2.w() : bu2;
    }

    public final mt2 t() {
        mt2 mt2 = this.zze;
        return mt2 == null ? mt2.u() : mt2;
    }

    public final jt2 u() {
        jt2 zzb2 = jt2.zzb(this.zzf);
        return zzb2 == null ? jt2.UNRECOGNIZED : zzb2;
    }
}
