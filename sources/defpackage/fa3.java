package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: fa3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fa3 extends t83<Integer> implements RandomAccess, ja3, hm2 {
    public static final fa3 i;
    public int[] g;
    public int h;

    static {
        fa3 fa3 = new fa3(new int[0], 0);
        i = fa3;
        fa3.f = false;
    }

    public fa3() {
        this.g = new int[10];
        this.h = 0;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new fa3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(n(i2));
        }
        int[] iArr = this.g;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.g, i2, iArr2, i2 + 1, this.h - i2);
            this.g = iArr2;
        }
        this.g[i2] = intValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof fa3)) {
            return super.addAll(collection);
        }
        fa3 fa3 = (fa3) collection;
        int i2 = fa3.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.g;
            if (i4 > iArr.length) {
                this.g = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(fa3.g, 0, this.g, this.h, fa3.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // j$.util.Collection, j$.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i2) {
        k(i2);
        return this.g[i2];
    }

    public final void e(int i2) {
        b();
        int i3 = this.h;
        int[] iArr = this.g;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.g = iArr2;
        }
        int[] iArr3 = this.g;
        int i4 = this.h;
        this.h = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fa3)) {
            return super.equals(obj);
        }
        fa3 fa3 = (fa3) obj;
        if (this.h != fa3.h) {
            return false;
        }
        int[] iArr = fa3.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        k(i2);
        return Integer.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + this.g[i3];
        }
        return i2;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == intValue) {
                return i3;
            }
        }
        return -1;
    }

    public final void k(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    public final String n(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.t83, java.util.List
    public final /* bridge */ /* synthetic */ Integer remove(int i2) {
        b();
        k(i2);
        int[] iArr = this.g;
        int i3 = iArr[i2];
        int i4 = this.h;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    public final void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            int[] iArr = this.g;
            System.arraycopy(iArr, i3, iArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        k(i2);
        int[] iArr = this.g;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public fa3(int[] iArr, int i2) {
        this.g = iArr;
        this.h = i2;
    }
}
