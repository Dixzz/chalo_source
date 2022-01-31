package defpackage;

@Deprecated
/* renamed from: ev2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ev2 extends ea3<ev2, dv2> implements cm2 {
    private static final ev2 zzi;
    private String zzb = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        ev2 ev2 = new ev2();
        zzi = ev2;
        ea3.r(ev2.class, ev2);
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new ev2();
        } else {
            if (i2 == 4) {
                return new dv2();
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
