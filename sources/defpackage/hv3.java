package defpackage;

/* renamed from: hv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class hv3 {

    /* renamed from: a  reason: collision with root package name */
    public volatile cw3 f1433a;
    public volatile qt3 b;

    static {
        eu3.a();
    }

    public final int a() {
        if (this.b != null) {
            return this.b.d();
        }
        if (this.f1433a != null) {
            return this.f1433a.a();
        }
        return 0;
    }

    public final cw3 b(cw3 cw3) {
        if (this.f1433a == null) {
            synchronized (this) {
                if (this.f1433a == null) {
                    try {
                        this.f1433a = cw3;
                        this.b = qt3.g;
                    } catch (cv3 unused) {
                        this.f1433a = cw3;
                        this.b = qt3.g;
                    }
                }
            }
        }
        return this.f1433a;
    }

    public final qt3 c() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.f1433a == null) {
                this.b = qt3.g;
            } else {
                this.b = this.f1433a.e();
            }
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hv3)) {
            return false;
        }
        hv3 hv3 = (hv3) obj;
        cw3 cw3 = this.f1433a;
        cw3 cw32 = hv3.f1433a;
        if (cw3 == null && cw32 == null) {
            return c().equals(hv3.c());
        }
        if (cw3 != null && cw32 != null) {
            return cw3.equals(cw32);
        }
        if (cw3 != null) {
            return cw3.equals(hv3.b(cw3.d()));
        }
        return b(cw32.d()).equals(cw32);
    }

    public int hashCode() {
        return 1;
    }
}
