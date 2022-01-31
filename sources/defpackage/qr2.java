package defpackage;

/* renamed from: qr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class qr2 extends ea3<qr2, pr2> implements cm2 {
    private static final qr2 zzf;
    private int zzb;
    private sr2 zze;

    static {
        qr2 qr2 = new qr2();
        zzf = qr2;
        ea3.r(qr2.class, qr2);
    }

    public static qr2 u(g93 g93, s93 s93) throws ma3 {
        return (qr2) ea3.f(zzf, g93, s93);
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
            return new qr2();
        } else {
            if (i2 == 4) {
                return new pr2();
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

    public final sr2 t() {
        sr2 sr2 = this.zze;
        return sr2 == null ? sr2.t() : sr2;
    }
}
