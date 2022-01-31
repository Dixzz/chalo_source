package defpackage;

import java.util.Arrays;

/* renamed from: e45  reason: default package */
/* compiled from: BitArray */
public final class e45 implements Cloneable {
    public int[] f;
    public int g;

    public e45() {
        this.g = 0;
        this.f = new int[1];
    }

    public void a(boolean z) {
        d(this.g + 1);
        if (z) {
            int[] iArr = this.f;
            int i = this.g;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.g++;
    }

    public void b(e45 e45) {
        int i = e45.g;
        d(this.g + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(e45.e(i2));
        }
    }

    public void c(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        d(this.g + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return new e45((int[]) this.f.clone(), this.g);
    }

    public final void d(int i) {
        int[] iArr = this.f;
        if (i > (iArr.length << 5)) {
            int[] iArr2 = new int[((i + 31) / 32)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f = iArr2;
        }
    }

    public boolean e(int i) {
        return ((1 << (i & 31)) & this.f[i / 32]) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e45)) {
            return false;
        }
        e45 e45 = (e45) obj;
        if (this.g != e45.g || !Arrays.equals(this.f, e45.f)) {
            return false;
        }
        return true;
    }

    public int f(int i) {
        int i2 = this.g;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & this.f[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f;
            if (i3 == iArr.length) {
                return this.g;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.g;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int g(int i) {
        int i2 = this.g;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & (~this.f[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f;
            if (i3 == iArr.length) {
                return this.g;
            }
            i4 = ~iArr[i3];
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.g;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int h() {
        return (this.g + 7) / 8;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f) + (this.g * 31);
    }

    public boolean i(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.g) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int i10 = this.f[i6] & i9;
                if (!z) {
                    i9 = 0;
                }
                if (i10 != i9) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public void j() {
        int[] iArr = new int[this.f.length];
        int i = (this.g - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.g;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f = iArr;
    }

    public void k(int i) {
        int[] iArr = this.f;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public String toString() {
        int i = this.g;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.g; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(e(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public e45(int i) {
        this.g = i;
        this.f = new int[((i + 31) / 32)];
    }

    public e45(int[] iArr, int i) {
        this.f = iArr;
        this.g = i;
    }
}
