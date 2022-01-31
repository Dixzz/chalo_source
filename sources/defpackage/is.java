package defpackage;

/* renamed from: is  reason: default package */
/* compiled from: SystemIdInfo */
public class is {

    /* renamed from: a  reason: collision with root package name */
    public final String f1565a;
    public final int b;

    public is(String str, int i) {
        this.f1565a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof is)) {
            return false;
        }
        is isVar = (is) obj;
        if (this.b != isVar.b) {
            return false;
        }
        return this.f1565a.equals(isVar.f1565a);
    }

    public int hashCode() {
        return (this.f1565a.hashCode() * 31) + this.b;
    }
}
