package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: vg2  reason: default package */
public final class vg2 extends of2<Integer> implements zg2<Integer>, RandomAccess {
    public int[] g;
    public int h;

    static {
        new vg2().f = false;
    }

    public vg2() {
        this.g = new int[10];
        this.h = 0;
    }

    public vg2(int[] iArr, int i) {
        this.g = iArr;
        this.h = i;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        n(i, ((Integer) obj).intValue());
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof vg2)) {
            return super.addAll(collection);
        }
        vg2 vg2 = (vg2) collection;
        int i = vg2.h;
        if (i == 0) {
            return false;
        }
        int i2 = this.h;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.g;
            if (i3 > iArr.length) {
                this.g = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(vg2.g, 0, this.g, this.h, vg2.h);
            this.h = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final int d(int i) {
        e(i);
        return this.g[i];
    }

    public final void e(int i) {
        if (i < 0 || i >= this.h) {
            throw new IndexOutOfBoundsException(k(i));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vg2)) {
            return super.equals(obj);
        }
        vg2 vg2 = (vg2) obj;
        if (this.h != vg2.h) {
            return false;
        }
        int[] iArr = vg2.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final Object get(int i) {
        e(i);
        return Integer.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + this.g[i2];
        }
        return i;
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    public final void n(int i, int i2) {
        int i3;
        b();
        if (i < 0 || i > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        int[] iArr = this.g;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.g, i, iArr2, i + 1, this.h - i);
            this.g = iArr2;
        }
        this.g[i] = i2;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        e(i);
        int[] iArr = this.g;
        int i2 = iArr[i];
        int i3 = this.h;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List, defpackage.of2
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Integer.valueOf(this.g[i]))) {
                int[] iArr = this.g;
                System.arraycopy(iArr, i + 1, iArr, i, this.h - i);
                this.h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        b();
        if (i2 >= i) {
            int[] iArr = this.g;
            System.arraycopy(iArr, i2, iArr, i, this.h - i2);
            this.h -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        e(i);
        int[] iArr = this.g;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    /* Return type fixed from 'zg2' to match base method */
    @Override // defpackage.zg2
    public final /* synthetic */ zg2<Integer> y0(int i) {
        if (i >= this.h) {
            return new vg2(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }
}
