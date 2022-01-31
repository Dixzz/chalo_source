package defpackage;

/* renamed from: hh2  reason: default package */
public class hh2 {

    /* renamed from: a  reason: collision with root package name */
    public volatile zh2 f1371a;
    public volatile uf2 b;

    static {
        gg2.a();
    }

    public final int a() {
        if (this.b != null) {
            return this.b.size();
        }
        if (this.f1371a != null) {
            return this.f1371a.e();
        }
        return 0;
    }

    public final zh2 b(zh2 zh2) {
        if (this.f1371a == null) {
            synchronized (this) {
                if (this.f1371a == null) {
                    try {
                        this.f1371a = zh2;
                        this.b = uf2.g;
                    } catch (ah2 unused) {
                        this.f1371a = zh2;
                        this.b = uf2.g;
                    }
                }
            }
        }
        return this.f1371a;
    }

    public final uf2 c() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            this.b = this.f1371a == null ? uf2.g : this.f1371a.a();
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hh2)) {
            return false;
        }
        hh2 hh2 = (hh2) obj;
        zh2 zh2 = this.f1371a;
        zh2 zh22 = hh2.f1371a;
        return (zh2 == null && zh22 == null) ? c().equals(hh2.c()) : (zh2 == null || zh22 == null) ? zh2 != null ? zh2.equals(hh2.b(zh2.f())) : b(zh22.f()).equals(zh22) : zh2.equals(zh22);
    }

    public int hashCode() {
        return 1;
    }
}
