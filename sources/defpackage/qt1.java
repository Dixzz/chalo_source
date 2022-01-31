package defpackage;

/* renamed from: qt1  reason: default package */
/* compiled from: MultiClassKey */
public class qt1 {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f2988a;
    public Class<?> b;
    public Class<?> c;

    public qt1() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qt1.class != obj.getClass()) {
            return false;
        }
        qt1 qt1 = (qt1) obj;
        return this.f2988a.equals(qt1.f2988a) && this.b.equals(qt1.b) && rt1.b(this.c, qt1.c);
    }

    public int hashCode() {
        int hashCode = (this.b.hashCode() + (this.f2988a.hashCode() * 31)) * 31;
        Class<?> cls = this.c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MultiClassKey{first=");
        i0.append(this.f2988a);
        i0.append(", second=");
        i0.append(this.b);
        i0.append('}');
        return i0.toString();
    }

    public qt1(Class<?> cls, Class<?> cls2) {
        this.f2988a = cls;
        this.b = cls2;
        this.c = null;
    }

    public qt1(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f2988a = cls;
        this.b = cls2;
        this.c = cls3;
    }
}
