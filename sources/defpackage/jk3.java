package defpackage;

import java.io.IOException;
import java.util.Objects;

/* renamed from: jk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class jk3 {
    public static final jk3 e = new jk3(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f1947a;
    public int[] b;
    public Object[] c;
    public int d;

    public jk3() {
        this(0, new int[8], new Object[8], true);
    }

    public static void a(int i, Object obj, al3 al3) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((jh3) al3).f1925a.b(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((jh3) al3).f1925a.u(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((jh3) al3).f1925a.c(i2, (xg3) obj);
        } else if (i3 == 3) {
            jh3 jh3 = (jh3) al3;
            jh3.f1925a.l(i2, 3);
            ((jk3) obj).b(al3);
            jh3.f1925a.l(i2, 4);
        } else if (i3 == 5) {
            ((jh3) al3).f1925a.B(i2, ((Integer) obj).intValue());
        } else {
            int i4 = fi3.f;
            throw new RuntimeException(new ei3("Protocol message tag had invalid wire type."));
        }
    }

    public final void b(al3 al3) throws IOException {
        if (this.f1947a != 0) {
            Objects.requireNonNull(al3);
            for (int i = 0; i < this.f1947a; i++) {
                a(this.b[i], this.c[i], al3);
            }
        }
    }

    public final int c() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1947a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = hh3.y(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.c[i4]).longValue();
                i = hh3.C(i6);
            } else if (i7 == 2) {
                i = hh3.q(i6, (xg3) this.c[i4]);
            } else if (i7 == 3) {
                i3 = ((jk3) this.c[i4]).c() + (hh3.Q(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.c[i4]).intValue();
                i = hh3.I(i6);
            } else {
                int i8 = fi3.f;
                throw new IllegalStateException(new ei3("Protocol message tag had invalid wire type."));
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof jk3)) {
            return false;
        }
        jk3 jk3 = (jk3) obj;
        int i = this.f1947a;
        if (i == jk3.f1947a) {
            int[] iArr = this.b;
            int[] iArr2 = jk3.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.c;
                Object[] objArr2 = jk3.c;
                int i3 = this.f1947a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.f1947a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f1947a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public jk3(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f1947a = i;
        this.b = iArr;
        this.c = objArr;
    }
}
