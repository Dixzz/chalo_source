package defpackage;

import defpackage.uh3;
import java.util.Objects;

/* renamed from: jl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class jl3 extends uh3<jl3, a> implements hj3 {
    private static volatile pj3<jl3> zzbc;
    private static final jl3 zzru;
    private int zzbd;
    private String zzra = "";
    private ci3<il3> zzrt = qj3.i;

    /* renamed from: jl3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class a extends uh3.b<jl3, a> implements hj3 {
        public a() {
            super(jl3.zzru);
        }

        public final a g(il3 il3) {
            if (this.h) {
                d();
                this.h = false;
            }
            jl3.j((jl3) this.g, il3);
            return this;
        }

        public a(ml3 ml3) {
            super(jl3.zzru);
        }
    }

    static {
        jl3 jl3 = new jl3();
        zzru = jl3;
        uh3.h(jl3.class, jl3);
    }

    public static void j(jl3 jl3, il3 il3) {
        Objects.requireNonNull(jl3);
        il3.getClass();
        if (!jl3.zzrt.V()) {
            ci3<il3> ci3 = jl3.zzrt;
            int size = ci3.size();
            jl3.zzrt = ci3.H0(size == 0 ? 10 : size << 1);
        }
        jl3.zzrt.add(il3);
    }

    public static void k(jl3 jl3, String str) {
        Objects.requireNonNull(jl3);
        str.getClass();
        jl3.zzbd |= 1;
        jl3.zzra = str;
    }

    public static a l() {
        return (a) zzru.i();
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [pj3<jl3>, uh3$a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.uh3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jl3.f(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
