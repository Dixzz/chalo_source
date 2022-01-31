package defpackage;

import java.security.MessageDigest;

/* renamed from: an1  reason: default package */
/* compiled from: DataCacheKey */
public final class an1 implements dm1 {
    public final dm1 b;
    public final dm1 c;

    public an1(dm1 dm1, dm1 dm12) {
        this.b = dm1;
        this.c = dm12;
    }

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (!(obj instanceof an1)) {
            return false;
        }
        an1 an1 = (an1) obj;
        if (!this.b.equals(an1.b) || !this.c.equals(an1.c)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DataCacheKey{sourceKey=");
        i0.append(this.b);
        i0.append(", signature=");
        i0.append(this.c);
        i0.append('}');
        return i0.toString();
    }
}
