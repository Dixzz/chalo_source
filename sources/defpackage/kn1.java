package defpackage;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;

/* renamed from: kn1  reason: default package */
/* compiled from: EngineKey */
public class kn1 implements dm1 {
    public final Object b;
    public final int c;
    public final int d;
    public final Class<?> e;
    public final Class<?> f;
    public final dm1 g;
    public final Map<Class<?>, im1<?>> h;
    public final fm1 i;
    public int j;

    public kn1(Object obj, dm1 dm1, int i2, int i3, Map<Class<?>, im1<?>> map, Class<?> cls, Class<?> cls2, fm1 fm1) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.b = obj;
        Objects.requireNonNull(dm1, "Signature must not be null");
        this.g = dm1;
        this.c = i2;
        this.d = i3;
        Objects.requireNonNull(map, "Argument must not be null");
        this.h = map;
        Objects.requireNonNull(cls, "Resource class must not be null");
        this.e = cls;
        Objects.requireNonNull(cls2, "Transcode class must not be null");
        this.f = cls2;
        Objects.requireNonNull(fm1, "Argument must not be null");
        this.i = fm1;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (!(obj instanceof kn1)) {
            return false;
        }
        kn1 kn1 = (kn1) obj;
        if (!this.b.equals(kn1.b) || !this.g.equals(kn1.g) || this.d != kn1.d || this.c != kn1.c || !this.h.equals(kn1.h) || !this.e.equals(kn1.e) || !this.f.equals(kn1.f) || !this.i.equals(kn1.i)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.b.hashCode();
            this.j = hashCode;
            int hashCode2 = this.g.hashCode() + (hashCode * 31);
            this.j = hashCode2;
            int i2 = (hashCode2 * 31) + this.c;
            this.j = i2;
            int i3 = (i2 * 31) + this.d;
            this.j = i3;
            int hashCode3 = this.h.hashCode() + (i3 * 31);
            this.j = hashCode3;
            int hashCode4 = this.e.hashCode() + (hashCode3 * 31);
            this.j = hashCode4;
            int hashCode5 = this.f.hashCode() + (hashCode4 * 31);
            this.j = hashCode5;
            this.j = this.i.hashCode() + (hashCode5 * 31);
        }
        return this.j;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("EngineKey{model=");
        i0.append(this.b);
        i0.append(", width=");
        i0.append(this.c);
        i0.append(", height=");
        i0.append(this.d);
        i0.append(", resourceClass=");
        i0.append(this.e);
        i0.append(", transcodeClass=");
        i0.append(this.f);
        i0.append(", signature=");
        i0.append(this.g);
        i0.append(", hashCode=");
        i0.append(this.j);
        i0.append(", transformations=");
        i0.append(this.h);
        i0.append(", options=");
        i0.append(this.i);
        i0.append('}');
        return i0.toString();
    }
}
