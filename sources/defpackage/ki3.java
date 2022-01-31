package defpackage;

/* renamed from: ki3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class ki3 {

    /* renamed from: a  reason: collision with root package name */
    public volatile gj3 f2064a;
    public volatile xg3 b;

    static {
        lh3.a();
    }

    public final xg3 a() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.f2064a == null) {
                this.b = xg3.g;
            } else {
                this.b = this.f2064a.q();
            }
            return this.b;
        }
    }

    public final int b() {
        if (this.b != null) {
            return this.b.size();
        }
        if (this.f2064a != null) {
            return this.f2064a.r();
        }
        return 0;
    }

    public final gj3 c(gj3 gj3) {
        if (this.f2064a == null) {
            synchronized (this) {
                if (this.f2064a == null) {
                    try {
                        this.f2064a = gj3;
                        this.b = xg3.g;
                    } catch (fi3 unused) {
                        this.f2064a = gj3;
                        this.b = xg3.g;
                    }
                }
            }
        }
        return this.f2064a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ki3)) {
            return false;
        }
        ki3 ki3 = (ki3) obj;
        gj3 gj3 = this.f2064a;
        gj3 gj32 = ki3.f2064a;
        if (gj3 == null && gj32 == null) {
            return a().equals(ki3.a());
        }
        if (gj3 != null && gj32 != null) {
            return gj3.equals(gj32);
        }
        if (gj3 != null) {
            return gj3.equals(ki3.c(gj3.a()));
        }
        return c(gj32.a()).equals(gj32);
    }

    public int hashCode() {
        return 1;
    }
}
