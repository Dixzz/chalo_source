package defpackage;

import java.util.Arrays;
import java.util.Objects;

/* renamed from: fv1  reason: default package */
/* compiled from: EncodedPayload */
public final class fv1 {

    /* renamed from: a  reason: collision with root package name */
    public final zt1 f1174a;
    public final byte[] b;

    public fv1(zt1 zt1, byte[] bArr) {
        Objects.requireNonNull(zt1, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f1174a = zt1;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fv1)) {
            return false;
        }
        fv1 fv1 = (fv1) obj;
        if (!this.f1174a.equals(fv1.f1174a)) {
            return false;
        }
        return Arrays.equals(this.b, fv1.b);
    }

    public int hashCode() {
        return ((this.f1174a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("EncodedPayload{encoding=");
        i0.append(this.f1174a);
        i0.append(", bytes=[...]}");
        return i0.toString();
    }
}
