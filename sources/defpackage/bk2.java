package defpackage;

import java.util.ArrayList;

/* renamed from: bk2  reason: default package */
public final class bk2 implements Cloneable {
    public int[] f;
    public ck2[] g;
    public int h;

    static {
        new ArrayList();
    }

    public bk2() {
        this(10);
    }

    public bk2(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f = new int[i5];
        this.g = new ck2[i5];
        this.h = 0;
    }

    public final boolean a() {
        return this.h == 0;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.h;
        bk2 bk2 = new bk2(i);
        System.arraycopy(this.f, 0, bk2.f, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            ck2[] ck2Arr = this.g;
            if (ck2Arr[i2] != null) {
                bk2.g[i2] = ck2Arr[i2].c();
            }
        }
        bk2.h = i;
        return bk2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bk2)) {
            return false;
        }
        bk2 bk2 = (bk2) obj;
        int i = this.h;
        if (i != bk2.h) {
            return false;
        }
        int[] iArr = this.f;
        int[] iArr2 = bk2.f;
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
            ck2[] ck2Arr = this.g;
            ck2[] ck2Arr2 = bk2.g;
            int i3 = this.h;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!ck2Arr[i4].equals(ck2Arr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (((i * 31) + this.f[i2]) * 31) + this.g[i2].hashCode();
        }
        return i;
    }
}
