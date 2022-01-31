package defpackage;

/* renamed from: r93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r93 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3060a;
    public final int b;

    public r93(Object obj, int i) {
        this.f3060a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r93)) {
            return false;
        }
        r93 r93 = (r93) obj;
        if (this.f3060a == r93.f3060a && this.b == r93.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3060a) * 65535) + this.b;
    }
}
