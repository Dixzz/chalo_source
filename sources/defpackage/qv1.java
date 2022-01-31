package defpackage;

import java.util.Arrays;

/* renamed from: qv1  reason: default package */
/* compiled from: AutoValue_BackendRequest */
public final class qv1 extends vv1 {

    /* renamed from: a  reason: collision with root package name */
    public final Iterable<gv1> f2994a;
    public final byte[] b;

    public qv1(Iterable iterable, byte[] bArr, a aVar) {
        this.f2994a = iterable;
        this.b = bArr;
    }

    @Override // defpackage.vv1
    public Iterable<gv1> a() {
        return this.f2994a;
    }

    @Override // defpackage.vv1
    public byte[] b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vv1)) {
            return false;
        }
        vv1 vv1 = (vv1) obj;
        if (this.f2994a.equals(vv1.a())) {
            if (Arrays.equals(this.b, vv1 instanceof qv1 ? ((qv1) vv1).b : vv1.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2994a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("BackendRequest{events=");
        i0.append(this.f2994a);
        i0.append(", extras=");
        i0.append(Arrays.toString(this.b));
        i0.append("}");
        return i0.toString();
    }
}
