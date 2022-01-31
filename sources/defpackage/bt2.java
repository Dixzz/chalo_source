package defpackage;

/* renamed from: bt2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bt2 extends ea3<bt2, at2> implements cm2 {
    private static final bt2 zzf;
    private int zzb;
    private int zze;

    static {
        bt2 bt2 = new bt2();
        zzf = bt2;
        ea3.r(bt2.class, bt2);
    }

    public static bt2 t(g93 g93, s93 s93) throws ma3 {
        return (bt2) ea3.f(zzf, g93, s93);
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzb"});
        } else if (i2 == 3) {
            return new bt2();
        } else {
            if (i2 == 4) {
                return new at2();
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
}
