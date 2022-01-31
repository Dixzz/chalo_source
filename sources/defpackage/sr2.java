package defpackage;

/* renamed from: sr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class sr2 extends ea3<sr2, rr2> implements cm2 {
    private static final sr2 zze;
    private int zzb;

    static {
        sr2 sr2 = new sr2();
        zze = sr2;
        ea3.r(sr2.class, sr2);
    }

    public static sr2 t() {
        return zze;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new sr2();
        } else {
            if (i2 == 4) {
                return new rr2();
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final int s() {
        return this.zzb;
    }
}
