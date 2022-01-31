package defpackage;

/* renamed from: oa3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class oa3 {

    /* renamed from: a  reason: collision with root package name */
    public volatile bm2 f2671a;
    public volatile g93 b;

    static {
        s93.a();
    }

    public final int a() {
        if (this.b != null) {
            return ((e93) this.b).i.length;
        }
        if (this.f2671a != null) {
            return this.f2671a.k();
        }
        return 0;
    }

    public final g93 b() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.f2671a == null) {
                this.b = g93.g;
            } else {
                this.b = this.f2671a.j();
            }
            return this.b;
        }
    }

    public final void c(bm2 bm2) {
        if (this.f2671a == null) {
            synchronized (this) {
                if (this.f2671a == null) {
                    try {
                        this.f2671a = bm2;
                        this.b = g93.g;
                    } catch (ma3 unused) {
                        this.f2671a = bm2;
                        this.b = g93.g;
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa3)) {
            return false;
        }
        oa3 oa3 = (oa3) obj;
        bm2 bm2 = this.f2671a;
        bm2 bm22 = oa3.f2671a;
        if (bm2 == null && bm22 == null) {
            return b().equals(oa3.b());
        }
        if (bm2 != null && bm22 != null) {
            return bm2.equals(bm22);
        }
        if (bm2 != null) {
            oa3.c(bm2.d());
            return bm2.equals(oa3.f2671a);
        }
        c(bm22.d());
        return this.f2671a.equals(bm22);
    }

    public int hashCode() {
        return 1;
    }
}
