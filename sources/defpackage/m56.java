package defpackage;

import java.io.Serializable;

/* renamed from: m56  reason: default package */
/* compiled from: Tuples.kt */
public final class m56<A, B> implements Serializable {
    public final A f;
    public final B g;

    public m56(A a2, B b) {
        this.f = a2;
        this.g = b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m56)) {
            return false;
        }
        m56 m56 = (m56) obj;
        return n86.a(this.f, m56.f) && n86.a(this.g, m56.g);
    }

    public int hashCode() {
        A a2 = this.f;
        int i = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b = this.g;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return '(' + ((Object) this.f) + ", " + ((Object) this.g) + ')';
    }
}
