package defpackage;

import defpackage.n25;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: f25  reason: default package */
/* compiled from: UnknownFieldSetLite */
public final class f25 {
    public static final f25 f = new f25(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f1064a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public f25() {
        this(0, new int[8], new Object[8], true);
    }

    public static f25 d(f25 f25, f25 f252) {
        int i = f25.f1064a + f252.f1064a;
        int[] copyOf = Arrays.copyOf(f25.b, i);
        System.arraycopy(f252.b, 0, copyOf, f25.f1064a, f252.f1064a);
        Object[] copyOf2 = Arrays.copyOf(f25.c, i);
        System.arraycopy(f252.c, 0, copyOf2, f25.f1064a, f252.f1064a);
        return new f25(i, copyOf, copyOf2, true);
    }

    public static f25 e() {
        return new f25(0, new int[8], new Object[8], true);
    }

    public static void g(int i, Object obj, n25 n25) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((e05) n25).f912a.Z(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((e05) n25).f912a.M(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((e05) n25).f912a.I(i2, (a05) obj);
        } else if (i3 == 3) {
            e05 e05 = (e05) n25;
            n25.a aVar = n25.a.ASCENDING;
            if (aVar == aVar) {
                e05.f912a.W(i2, 3);
                ((f25) obj).h(n25);
                e05.f912a.W(i2, 4);
                return;
            }
            e05.f912a.W(i2, 4);
            ((f25) obj).h(n25);
            e05.f912a.W(i2, 3);
        } else if (i3 == 5) {
            ((e05) n25).f912a.K(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(t05.d());
        }
    }

    public void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public int b() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1064a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = d05.A(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 1) {
                i = d05.h(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 2) {
                i = d05.c(i6, (a05) this.c[i4]);
            } else if (i7 == 3) {
                i3 = ((f25) this.c[i4]).b() + (d05.x(i6) * 2) + i3;
            } else if (i7 == 5) {
                i = d05.g(i6, ((Integer) this.c[i4]).intValue());
            } else {
                throw new IllegalStateException(t05.d());
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public boolean c(int i, b05 b05) throws IOException {
        int A;
        a();
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            f(i, Long.valueOf(b05.s()));
            return true;
        } else if (i3 == 1) {
            f(i, Long.valueOf(b05.p()));
            return true;
        } else if (i3 == 2) {
            f(i, b05.l());
            return true;
        } else if (i3 == 3) {
            f25 f25 = new f25(0, new int[8], new Object[8], true);
            do {
                A = b05.A();
                if (A == 0) {
                    break;
                }
            } while (f25.c(A, b05));
            b05.a((i2 << 3) | 4);
            f(i, f25);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                f(i, Integer.valueOf(b05.o()));
                return true;
            }
            throw t05.d();
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f25)) {
            return false;
        }
        f25 f25 = (f25) obj;
        int i = this.f1064a;
        if (i == f25.f1064a) {
            int[] iArr = this.b;
            int[] iArr2 = f25.b;
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
                Object[] objArr2 = f25.c;
                int i3 = this.f1064a;
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

    public void f(int i, Object obj) {
        a();
        int i2 = this.f1064a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.b = Arrays.copyOf(iArr, i3);
            this.c = Arrays.copyOf(this.c, i3);
        }
        int[] iArr2 = this.b;
        int i4 = this.f1064a;
        iArr2[i4] = i;
        this.c[i4] = obj;
        this.f1064a = i4 + 1;
    }

    public void h(n25 n25) throws IOException {
        if (this.f1064a != 0) {
            Objects.requireNonNull((e05) n25);
            n25.a aVar = n25.a.ASCENDING;
            if (aVar == aVar) {
                for (int i = 0; i < this.f1064a; i++) {
                    g(this.b[i], this.c[i], n25);
                }
                return;
            }
            for (int i2 = this.f1064a - 1; i2 >= 0; i2--) {
                g(this.b[i2], this.c[i2], n25);
            }
        }
    }

    public int hashCode() {
        int i = this.f1064a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f1064a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public f25(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f1064a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
