package defpackage;

/* renamed from: mm6  reason: default package */
/* compiled from: WebSocketExtensions.kt */
public final class mm6 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2408a;
    public final Integer b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    public mm6() {
        this.f2408a = false;
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mm6)) {
            return false;
        }
        mm6 mm6 = (mm6) obj;
        return this.f2408a == mm6.f2408a && n86.a(this.b, mm6.b) && this.c == mm6.c && n86.a(this.d, mm6.d) && this.e == mm6.e && this.f == mm6.f;
    }

    public int hashCode() {
        boolean z = this.f2408a;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        Integer num = this.b;
        int i6 = 0;
        int hashCode = (i5 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.c;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode + i7) * 31;
        Integer num2 = this.d;
        if (num2 != null) {
            i6 = num2.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        boolean z3 = this.e;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        boolean z4 = this.f;
        if (!z4) {
            i = z4 ? 1 : 0;
        }
        return i15 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("WebSocketExtensions(perMessageDeflate=");
        i0.append(this.f2408a);
        i0.append(", clientMaxWindowBits=");
        i0.append(this.b);
        i0.append(", clientNoContextTakeover=");
        i0.append(this.c);
        i0.append(", serverMaxWindowBits=");
        i0.append(this.d);
        i0.append(", serverNoContextTakeover=");
        i0.append(this.e);
        i0.append(", unknownValues=");
        i0.append(this.f);
        i0.append(")");
        return i0.toString();
    }

    public mm6(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.f2408a = z;
        this.b = num;
        this.c = z2;
        this.d = num2;
        this.e = z3;
        this.f = z4;
    }
}
