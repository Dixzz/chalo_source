package defpackage;

/* renamed from: kj  reason: default package */
/* compiled from: NavOptions */
public final class kj {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2067a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    public kj(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.f2067a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || kj.class != obj.getClass()) {
            return false;
        }
        kj kjVar = (kj) obj;
        if (this.f2067a == kjVar.f2067a && this.b == kjVar.b && this.c == kjVar.c && this.d == kjVar.d && this.e == kjVar.e && this.f == kjVar.f && this.g == kjVar.g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.f2067a ? 1 : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0)) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    }
}
