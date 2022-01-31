package defpackage;

/* renamed from: or2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class or2 extends ea3<or2, nr2> implements cm2 {
    private static final or2 zzg;
    private int zzb;
    private g93 zze = g93.g;
    private sr2 zzf;

    static {
        or2 or2 = new or2();
        zzg = or2;
        ea3.r(or2.class, or2);
    }

    public static /* synthetic */ void A(or2 or2, sr2 sr2) {
        sr2.getClass();
        or2.zzf = sr2;
    }

    public static or2 v(g93 g93, s93 s93) throws ma3 {
        return (or2) ea3.f(zzg, g93, s93);
    }

    public static nr2 w() {
        return (nr2) zzg.n();
    }

    public static /* synthetic */ void z(or2 or2, g93 g93) {
        g93.getClass();
        or2.zze = g93;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new or2();
        } else {
            if (i2 == 4) {
                return new nr2(null);
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

    public final g93 t() {
        return this.zze;
    }

    public final sr2 u() {
        sr2 sr2 = this.zzf;
        return sr2 == null ? sr2.t() : sr2;
    }
}
