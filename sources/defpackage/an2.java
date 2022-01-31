package defpackage;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: an2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class an2 {
    public static final an2 f = new an2(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f182a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public an2() {
        this(0, new int[8], new Object[8], true);
    }

    public an2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f182a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static an2 a() {
        return new an2(0, new int[8], new Object[8], true);
    }

    public final int b() {
        int i;
        int i2;
        int i3;
        int i4 = this.d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f182a; i6++) {
            int i7 = this.b[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.c[i6]).longValue();
                    i3 = n93.B(i8) + 8;
                } else if (i9 == 2) {
                    int B = n93.B(i8);
                    int e2 = ((g93) this.c[i6]).e();
                    i5 = n93.b(e2) + e2 + B + i5;
                } else if (i9 == 3) {
                    int B2 = n93.B(i8);
                    i2 = B2 + B2;
                    i = ((an2) this.c[i6]).b();
                } else if (i9 == 5) {
                    ((Integer) this.c[i6]).intValue();
                    i3 = n93.B(i8) + 4;
                } else {
                    int i10 = ma3.f;
                    throw new IllegalStateException(new la3());
                }
                i5 = i3 + i5;
            } else {
                long longValue = ((Long) this.c[i6]).longValue();
                i2 = n93.B(i8);
                i = n93.c(longValue);
            }
            i5 = i + i2 + i5;
        }
        this.d = i5;
        return i5;
    }

    public final void c(int i, Object obj) {
        if (this.e) {
            int i2 = this.f182a;
            int[] iArr = this.b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.b = Arrays.copyOf(iArr, i3);
                this.c = Arrays.copyOf(this.c, i3);
            }
            int[] iArr2 = this.b;
            int i4 = this.f182a;
            iArr2[i4] = i;
            this.c[i4] = obj;
            this.f182a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(o93 o93) throws IOException {
        if (this.f182a != 0) {
            for (int i = 0; i < this.f182a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    o93.f2666a.o(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    o93.f2666a.q(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    o93.f2666a.t(i3, (g93) obj);
                } else if (i4 == 3) {
                    o93.f2666a.k(i3, 3);
                    ((an2) obj).d(o93);
                    o93.f2666a.k(i3, 4);
                } else if (i4 == 5) {
                    o93.f2666a.n(i3, ((Integer) obj).intValue());
                } else {
                    int i5 = ma3.f;
                    throw new RuntimeException(new la3());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof an2)) {
            return false;
        }
        an2 an2 = (an2) obj;
        int i = this.f182a;
        if (i == an2.f182a) {
            int[] iArr = this.b;
            int[] iArr2 = an2.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = an2.c;
                    int i3 = this.f182a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f182a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f182a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
