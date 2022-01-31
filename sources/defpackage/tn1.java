package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: tn1  reason: default package */
/* compiled from: ResourceCacheKey */
public final class tn1 implements dm1 {
    public static final ot1<Class<?>, byte[]> i = new ot1<>(50);
    public final dm1 b;
    public final dm1 c;
    public final int d;
    public final int e;
    public final Class<?> f;
    public final fm1 g;
    public final im1<?> h;

    public tn1(dm1 dm1, dm1 dm12, int i2, int i3, im1<?> im1, Class<?> cls, fm1 fm1) {
        this.b = dm1;
        this.c = dm12;
        this.d = i2;
        this.e = i3;
        this.h = im1;
        this.f = cls;
        this.g = fm1;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.d).putInt(this.e).array();
        this.c.a(messageDigest);
        this.b.a(messageDigest);
        messageDigest.update(array);
        im1<?> im1 = this.h;
        if (im1 != null) {
            im1.a(messageDigest);
        }
        this.g.a(messageDigest);
        ot1<Class<?>, byte[]> ot1 = i;
        byte[] a2 = ot1.a(this.f);
        if (a2 == null) {
            a2 = this.f.getName().getBytes(dm1.f856a);
            ot1.d(this.f, a2);
        }
        messageDigest.update(a2);
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (!(obj instanceof tn1)) {
            return false;
        }
        tn1 tn1 = (tn1) obj;
        if (this.e != tn1.e || this.d != tn1.d || !rt1.b(this.h, tn1.h) || !this.f.equals(tn1.f) || !this.b.equals(tn1.b) || !this.c.equals(tn1.c) || !this.g.equals(tn1.g)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        int hashCode = ((((this.c.hashCode() + (this.b.hashCode() * 31)) * 31) + this.d) * 31) + this.e;
        im1<?> im1 = this.h;
        if (im1 != null) {
            hashCode = (hashCode * 31) + im1.hashCode();
        }
        int hashCode2 = this.f.hashCode();
        return this.g.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ResourceCacheKey{sourceKey=");
        i0.append(this.b);
        i0.append(", signature=");
        i0.append(this.c);
        i0.append(", width=");
        i0.append(this.d);
        i0.append(", height=");
        i0.append(this.e);
        i0.append(", decodedResourceClass=");
        i0.append(this.f);
        i0.append(", transformation='");
        i0.append(this.h);
        i0.append('\'');
        i0.append(", options=");
        i0.append(this.g);
        i0.append('}');
        return i0.toString();
    }
}
