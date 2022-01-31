package defpackage;

/* renamed from: zi  reason: default package */
/* compiled from: NavArgument */
public final class zi {

    /* renamed from: a  reason: collision with root package name */
    public final lj f4177a;
    public final boolean b;
    public final boolean c;
    public final Object d;

    public zi(lj<?> ljVar, boolean z, Object obj, boolean z2) {
        if (!ljVar.f2225a && z) {
            throw new IllegalArgumentException(ljVar.b() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.f4177a = ljVar;
            this.b = z;
            this.d = obj;
            this.c = z2;
        } else {
            StringBuilder i0 = hj1.i0("Argument with type ");
            i0.append(ljVar.b());
            i0.append(" has null value but is not nullable.");
            throw new IllegalArgumentException(i0.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zi.class != obj.getClass()) {
            return false;
        }
        zi ziVar = (zi) obj;
        if (this.b != ziVar.b || this.c != ziVar.c || !this.f4177a.equals(ziVar.f4177a)) {
            return false;
        }
        Object obj2 = this.d;
        if (obj2 != null) {
            return obj2.equals(ziVar.d);
        }
        if (ziVar.d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f4177a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
