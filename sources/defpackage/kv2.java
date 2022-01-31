package defpackage;

import java.util.List;

/* renamed from: kv2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kv2 extends ea3<kv2, gv2> implements cm2 {
    private static final kv2 zzf;
    private int zzb;
    private ja3<jv2> zze = km2.i;

    static {
        kv2 kv2 = new kv2();
        zzf = kv2;
        ea3.r(kv2.class, kv2);
    }

    public static void A(kv2 kv2, jv2 jv2) {
        jv2.getClass();
        ja3<jv2> ja3 = kv2.zze;
        if (!ja3.zza()) {
            int size = ja3.size();
            kv2.zze = ja3.D(size == 0 ? 10 : size + size);
        }
        kv2.zze.add(jv2);
    }

    public static kv2 w(byte[] bArr, s93 s93) throws ma3 {
        return (kv2) ea3.g(zzf, bArr, s93);
    }

    public static gv2 x() {
        return (gv2) zzf.n();
    }

    @Override // defpackage.ea3
    public final Object i(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new lm2(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", jv2.class});
        } else if (i2 == 3) {
            return new kv2();
        } else {
            if (i2 == 4) {
                return new gv2(null);
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

    public final List<jv2> t() {
        return this.zze;
    }

    public final int u() {
        return this.zze.size();
    }

    public final jv2 v(int i) {
        return this.zze.get(i);
    }
}
