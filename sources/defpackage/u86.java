package defpackage;

/* renamed from: u86  reason: default package */
/* compiled from: PropertyReference */
public abstract class u86 extends f86 implements s96 {
    public u86() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u86) {
            u86 u86 = (u86) obj;
            if (!f().equals(u86.f()) || !this.i.equals(u86.i) || !this.j.equals(u86.j) || !n86.a(this.g, u86.g)) {
                return false;
            }
            return true;
        } else if (obj instanceof s96) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.j.hashCode() + hj1.r0(this.i, f().hashCode() * 31, 31);
    }

    public String toString() {
        m96 c = c();
        if (c != this) {
            return c.toString();
        }
        return hj1.a0(hj1.i0("property "), this.i, " (Kotlin reflection is not available)");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u86(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }
}
