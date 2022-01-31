package defpackage;

import defpackage.uh3;
import java.util.Objects;

/* renamed from: kl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class kl3 extends uh3<kl3, a> implements hj3 {
    private static volatile pj3<kl3> zzbc;
    private static final kl3 zzsa;
    private int zzbd;
    private boolean zzrv;
    private String zzrw = "";
    private long zzrx;
    private double zzry;
    private jl3 zzrz;

    /* renamed from: kl3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class a extends uh3.b<kl3, a> implements hj3 {
        public a() {
            super(kl3.zzsa);
        }

        public a(ml3 ml3) {
            super(kl3.zzsa);
        }
    }

    static {
        kl3 kl3 = new kl3();
        zzsa = kl3;
        uh3.h(kl3.class, kl3);
    }

    public static void j(kl3 kl3, jl3 jl3) {
        Objects.requireNonNull(kl3);
        jl3.getClass();
        kl3.zzrz = jl3;
        kl3.zzbd |= 16;
    }

    public static void k(kl3 kl3, String str) {
        Objects.requireNonNull(kl3);
        str.getClass();
        kl3.zzbd |= 2;
        kl3.zzrw = str;
    }

    public static void l(kl3 kl3, boolean z) {
        kl3.zzbd |= 1;
        kl3.zzrv = z;
    }

    public static a m() {
        return (a) zzsa.i();
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [pj3<kl3>, uh3$a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.uh3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl3.f(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
