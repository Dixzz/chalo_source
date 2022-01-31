package defpackage;

/* renamed from: sv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class sv2 extends ea3<sv2, rv2> implements cm2 {
    private static final sv2 zzf;
    private int zzb;
    private uv2 zze;

    static {
        sv2 sv2 = new sv2();
        zzf = sv2;
        ea3.r(sv2.class, sv2);
    }

    public static sv2 u(g93 g93, s93 s93) throws ma3 {
        return (sv2) ea3.f(zzf, g93, s93);
    }

    public static rv2 v() {
        return (rv2) zzf.n();
    }

    public static /* synthetic */ void y(sv2 sv2, uv2 uv2) {
        uv2.getClass();
        sv2.zze = uv2;
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
            return new sv2();
        } else {
            if (i2 == 4) {
                return new rv2(null);
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

    public final uv2 t() {
        uv2 uv2 = this.zze;
        return uv2 == null ? uv2.u() : uv2;
    }
}
