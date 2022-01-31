package defpackage;

@Deprecated
/* renamed from: dw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dw2 extends ea3<dw2, cw2> implements cm2 {
    private static final dw2 zzf;
    private String zzb = "";
    private ja3<ev2> zze = km2.i;

    static {
        dw2 dw2 = new dw2();
        zzf = dw2;
        ea3.r(dw2.class, dw2);
    }

    public static dw2 s() {
        return zzf;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zze", ev2.class});
        } else if (i2 == 3) {
            return new dw2();
        } else {
            if (i2 == 4) {
                return new cw2();
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
