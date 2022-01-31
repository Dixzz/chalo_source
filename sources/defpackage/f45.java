package defpackage;

import java.util.Arrays;

/* renamed from: f45  reason: default package */
/* compiled from: BitMatrix */
public final class f45 implements Cloneable {
    public final int f;
    public final int g;
    public final int h;
    public final int[] i;

    public f45(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f = i2;
        this.g = i3;
        int i4 = (i2 + 31) / 32;
        this.h = i4;
        this.i = new int[(i4 * i3)];
    }

    public void a(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.h);
        int[] iArr = this.i;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean b(int i2, int i3) {
        return ((this.i[(i2 / 32) + (i3 * this.h)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] c() {
        int length = this.i.length - 1;
        while (length >= 0 && this.i[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.h;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.i[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return new f45(this.f, this.g, this.h, (int[]) this.i.clone());
    }

    public e45 d(int i2, e45 e45) {
        int i3 = e45.g;
        int i4 = this.f;
        if (i3 < i4) {
            e45 = new e45(i4);
        } else {
            int length = e45.f.length;
            for (int i5 = 0; i5 < length; i5++) {
                e45.f[i5] = 0;
            }
        }
        int i6 = i2 * this.h;
        for (int i7 = 0; i7 < this.h; i7++) {
            e45.f[(i7 << 5) / 32] = this.i[i6 + i7];
        }
        return e45;
    }

    public int[] e() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.i;
            if (i2 < iArr.length && iArr[i2] == 0) {
                i2++;
            }
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.h;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f45)) {
            return false;
        }
        f45 f45 = (f45) obj;
        if (this.f == f45.f && this.g == f45.g && this.h == f45.h && Arrays.equals(this.i, f45.i)) {
            return true;
        }
        return false;
    }

    public void f(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.h);
        int[] iArr = this.i;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void g(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.g || i6 > this.f) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.h * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.i;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
        }
    }

    public int hashCode() {
        int i2 = this.f;
        return Arrays.hashCode(this.i) + (((((((i2 * 31) + i2) * 31) + this.g) * 31) + this.h) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f + 1) * this.g);
        for (int i2 = 0; i2 < this.g; i2++) {
            for (int i3 = 0; i3 < this.f; i3++) {
                sb.append(b(i3, i2) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public f45(int i2, int i3, int i4, int[] iArr) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = iArr;
    }
}
