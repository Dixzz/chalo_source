package defpackage;

/* renamed from: fr  reason: default package */
/* compiled from: NetworkState */
public class fr {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1161a;
    public boolean b;
    public boolean c;
    public boolean d;

    public fr(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1161a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fr)) {
            return false;
        }
        fr frVar = (fr) obj;
        if (this.f1161a == frVar.f1161a && this.b == frVar.b && this.c == frVar.c && this.d == frVar.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f1161a ? 1 : 0;
        if (this.b) {
            i += 16;
        }
        if (this.c) {
            i += 256;
        }
        return this.d ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f1161a), Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
