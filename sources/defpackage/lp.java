package defpackage;

import android.os.Build;

/* renamed from: lp  reason: default package */
/* compiled from: Constraints */
public final class lp {
    public static final lp i = new lp(new a());

    /* renamed from: a  reason: collision with root package name */
    public up f2251a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public mp h;

    /* renamed from: lp$a */
    /* compiled from: Constraints */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public up f2252a = up.NOT_REQUIRED;
        public long b = -1;
        public long c = -1;
        public mp d = new mp();
    }

    public lp() {
        this.f2251a = up.NOT_REQUIRED;
        this.f = -1;
        this.g = -1;
        this.h = new mp();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lp.class != obj.getClass()) {
            return false;
        }
        lp lpVar = (lp) obj;
        if (this.b == lpVar.b && this.c == lpVar.c && this.d == lpVar.d && this.e == lpVar.e && this.f == lpVar.f && this.g == lpVar.g && this.f2251a == lpVar.f2251a) {
            return this.h.equals(lpVar.h);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f;
        long j2 = this.g;
        return this.h.hashCode() + (((((((((((((this.f2251a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public lp(a aVar) {
        this.f2251a = up.NOT_REQUIRED;
        this.f = -1;
        this.g = -1;
        this.h = new mp();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.f2251a = aVar.f2252a;
        this.d = false;
        this.e = false;
        if (i2 >= 24) {
            this.h = aVar.d;
            this.f = aVar.b;
            this.g = aVar.c;
        }
    }

    public lp(lp lpVar) {
        this.f2251a = up.NOT_REQUIRED;
        this.f = -1;
        this.g = -1;
        this.h = new mp();
        this.b = lpVar.b;
        this.c = lpVar.c;
        this.f2251a = lpVar.f2251a;
        this.d = lpVar.d;
        this.e = lpVar.e;
        this.h = lpVar.h;
    }
}
