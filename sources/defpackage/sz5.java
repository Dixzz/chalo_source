package defpackage;

/* renamed from: sz5  reason: default package */
/* compiled from: Subscription */
public final class sz5 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3283a;
    public final qz5 b;
    public final int c;
    public volatile boolean d = true;

    public sz5(Object obj, qz5 qz5, int i) {
        this.f3283a = obj;
        this.b = qz5;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sz5)) {
            return false;
        }
        sz5 sz5 = (sz5) obj;
        if (this.f3283a != sz5.f3283a || !this.b.equals(sz5.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b.d.hashCode() + this.f3283a.hashCode();
    }
}
