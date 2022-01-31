package defpackage;

/* renamed from: jv2 */
public final class jv2 extends ea3<jv2, hv2> implements cm2 {
    private static final jv2 zzh;
    private xu2 zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        jv2 jv2 = new jv2();
        zzh = jv2;
        ea3.r(jv2.class, jv2);
    }

    public static hv2 x() {
        return (hv2) zzh.n();
    }

    public static /* synthetic */ void z(jv2 jv2, xu2 xu2) {
        xu2.getClass();
        jv2.zzb = xu2;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new jv2();
        } else {
            if (i2 == 4) {
                return new hv2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final boolean s() {
        return this.zzb != null;
    }

    public final xu2 t() {
        xu2 xu2 = this.zzb;
        return xu2 == null ? xu2.w() : xu2;
    }

    public final zu2 u() {
        zu2 zzb2 = zu2.zzb(this.zze);
        return zzb2 == null ? zu2.UNRECOGNIZED : zzb2;
    }

    public final int v() {
        return this.zzf;
    }

    public final bw2 w() {
        bw2 zzb2 = bw2.zzb(this.zzg);
        return zzb2 == null ? bw2.UNRECOGNIZED : zzb2;
    }
}
