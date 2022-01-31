package defpackage;

import java.security.MessageDigest;
import java.util.Objects;

/* renamed from: jt1  reason: default package */
/* compiled from: ObjectKey */
public final class jt1 implements dm1 {
    public final Object b;

    public jt1(Object obj) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.b = obj;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(dm1.f856a));
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (obj instanceof jt1) {
            return this.b.equals(((jt1) obj).b);
        }
        return false;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ObjectKey{object=");
        i0.append(this.b);
        i0.append('}');
        return i0.toString();
    }
}
