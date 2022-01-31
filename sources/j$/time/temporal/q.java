package j$.time.temporal;

import j$.time.b;
import java.io.Serializable;

public final class q implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f1639a;
    private final long b;
    private final long c;
    private final long d;

    private q(long j, long j2, long j3, long j4) {
        this.f1639a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    private String c(l lVar, long j) {
        if (lVar != null) {
            return "Invalid value for " + lVar + " (valid values " + this + "): " + j;
        }
        return "Invalid value (valid values " + this + "): " + j;
    }

    public static q i(long j, long j2) {
        if (j <= j2) {
            return new q(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static q j(long j, long j2, long j3) {
        if (j > j) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j2 > j3) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j <= j3) {
            return new q(j, j, j2, j3);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public int a(long j, l lVar) {
        if (g() && h(j)) {
            return (int) j;
        }
        throw new b(c(lVar, j));
    }

    public long b(long j, l lVar) {
        if (h(j)) {
            return j;
        }
        throw new b(c(lVar, j));
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.f1639a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f1639a == qVar.f1639a && this.b == qVar.b && this.c == qVar.c && this.d == qVar.d;
    }

    public boolean f() {
        return this.f1639a == this.b && this.c == this.d;
    }

    public boolean g() {
        return this.f1639a >= -2147483648L && this.d <= 2147483647L;
    }

    public boolean h(long j) {
        return j >= this.f1639a && j <= this.d;
    }

    public int hashCode() {
        long j = this.f1639a;
        long j2 = this.b;
        long j3 = j + (j2 << 16) + (j2 >> 48);
        long j4 = this.c;
        long j5 = j3 + (j4 << 32) + (j4 >> 32);
        long j6 = this.d;
        long j7 = j5 + (j6 << 48) + (j6 >> 16);
        return (int) (j7 ^ (j7 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1639a);
        if (this.f1639a != this.b) {
            sb.append('/');
            sb.append(this.b);
        }
        sb.append(" - ");
        sb.append(this.c);
        if (this.c != this.d) {
            sb.append('/');
            sb.append(this.d);
        }
        return sb.toString();
    }
}
