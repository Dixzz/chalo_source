package defpackage;

import defpackage.uh3;
import java.util.Objects;

/* renamed from: il3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class il3 extends uh3<il3, a> implements hj3 {
    private static volatile pj3<il3> zzbc;
    private static final il3 zzrs;
    private int zzbd;
    private String zzqs = "";
    private kl3 zzrr;

    /* renamed from: il3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class a extends uh3.b<il3, a> implements hj3 {
        public a() {
            super(il3.zzrs);
        }

        public final a g(kl3 kl3) {
            if (this.h) {
                d();
                this.h = false;
            }
            il3.j((il3) this.g, kl3);
            return this;
        }

        public final a h(String str) {
            if (this.h) {
                d();
                this.h = false;
            }
            il3.k((il3) this.g, str);
            return this;
        }

        public a(ml3 ml3) {
            super(il3.zzrs);
        }
    }

    static {
        il3 il3 = new il3();
        zzrs = il3;
        uh3.h(il3.class, il3);
    }

    public static void j(il3 il3, kl3 kl3) {
        Objects.requireNonNull(il3);
        kl3.getClass();
        il3.zzrr = kl3;
        il3.zzbd |= 2;
    }

    public static void k(il3 il3, String str) {
        Objects.requireNonNull(il3);
        str.getClass();
        il3.zzbd |= 1;
        il3.zzqs = str;
    }

    public static a l() {
        return (a) zzrs.i();
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [pj3<il3>, uh3$a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.uh3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.il3.f(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
