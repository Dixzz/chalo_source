package defpackage;

import java.util.Objects;

/* renamed from: wx1  reason: default package */
/* compiled from: AutoValue_PersistedEvent */
public final class wx1 extends cy1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f3851a;
    public final jv1 b;
    public final gv1 c;

    public wx1(long j, jv1 jv1, gv1 gv1) {
        this.f3851a = j;
        Objects.requireNonNull(jv1, "Null transportContext");
        this.b = jv1;
        Objects.requireNonNull(gv1, "Null event");
        this.c = gv1;
    }

    @Override // defpackage.cy1
    public gv1 a() {
        return this.c;
    }

    @Override // defpackage.cy1
    public long b() {
        return this.f3851a;
    }

    @Override // defpackage.cy1
    public jv1 c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cy1)) {
            return false;
        }
        cy1 cy1 = (cy1) obj;
        if (this.f3851a != cy1.b() || !this.b.equals(cy1.c()) || !this.c.equals(cy1.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f3851a;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("PersistedEvent{id=");
        i0.append(this.f3851a);
        i0.append(", transportContext=");
        i0.append(this.b);
        i0.append(", event=");
        i0.append(this.c);
        i0.append("}");
        return i0.toString();
    }
}
