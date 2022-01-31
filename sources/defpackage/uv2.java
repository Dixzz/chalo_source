package defpackage;

/* renamed from: uv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class uv2 extends ea3<uv2, tv2> implements cm2 {
    private static final uv2 zze;
    private String zzb = "";

    static {
        uv2 uv2 = new uv2();
        zze = uv2;
        ea3.r(uv2.class, uv2);
    }

    public static uv2 t(g93 g93, s93 s93) throws ma3 {
        return (uv2) ea3.f(zze, g93, s93);
    }

    public static uv2 u() {
        return zze;
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new uv2();
        } else {
            if (i2 == 4) {
                return new tv2();
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final String s() {
        return this.zzb;
    }
}
