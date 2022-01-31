package defpackage;

/* renamed from: pv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pv2 extends ea3<pv2, mv2> implements cm2 {
    private static final pv2 zzf;
    private int zzb;
    private ja3<ov2> zze = km2.i;

    static {
        pv2 pv2 = new pv2();
        zzf = pv2;
        ea3.r(pv2.class, pv2);
    }

    public static mv2 t() {
        return (mv2) zzf.n();
    }

    public static void w(pv2 pv2, ov2 ov2) {
        ov2.getClass();
        ja3<ov2> ja3 = pv2.zze;
        if (!ja3.zza()) {
            int size = ja3.size();
            pv2.zze = ja3.D(size == 0 ? 10 : size + size);
        }
        pv2.zze.add(ov2);
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", ov2.class});
        } else if (i2 == 3) {
            return new pv2();
        } else {
            if (i2 == 4) {
                return new mv2(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final ov2 s() {
        return this.zze.get(0);
    }
}
