package defpackage;

import java.util.Objects;

/* renamed from: l86  reason: default package */
/* compiled from: FunctionReference */
public class l86 extends f86 implements k86, p96 {
    public final int l;
    public final int m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l86(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.l = i;
        this.m = i2 >> 1;
    }

    @Override // defpackage.f86
    public m96 d() {
        Objects.requireNonNull(z86.f4146a);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l86) {
            l86 l86 = (l86) obj;
            if (!n86.a(f(), l86.f()) || !this.i.equals(l86.i) || !this.j.equals(l86.j) || this.m != l86.m || this.l != l86.l || !n86.a(this.g, l86.g)) {
                return false;
            }
            return true;
        } else if (obj instanceof p96) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    @Override // defpackage.k86
    public int getArity() {
        return this.l;
    }

    public int hashCode() {
        return this.j.hashCode() + hj1.r0(this.i, f() == null ? 0 : f().hashCode() * 31, 31);
    }

    public String toString() {
        m96 c = c();
        if (c != this) {
            return c.toString();
        }
        if ("<init>".equals(this.i)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return hj1.a0(hj1.i0("function "), this.i, " (Kotlin reflection is not available)");
    }
}
