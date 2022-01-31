package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: rf2  reason: default package */
public final class rf2 extends of2<Boolean> implements zg2<Boolean>, RandomAccess {
    public boolean[] g;
    public int h;

    static {
        new rf2().f = false;
    }

    public rf2() {
        this.g = new boolean[10];
        this.h = 0;
    }

    public rf2(boolean[] zArr, int i) {
        this.g = zArr;
        this.h = i;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        d(i, ((Boolean) obj).booleanValue());
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof rf2)) {
            return super.addAll(collection);
        }
        rf2 rf2 = (rf2) collection;
        int i = rf2.h;
        if (i == 0) {
            return false;
        }
        int i2 = this.h;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.g;
            if (i3 > zArr.length) {
                this.g = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(rf2.g, 0, this.g, this.h, rf2.h);
            this.h = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void d(int i, boolean z) {
        int i2;
        b();
        if (i < 0 || i > (i2 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        boolean[] zArr = this.g;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.g, i, zArr2, i + 1, this.h - i);
            this.g = zArr2;
        }
        this.g[i] = z;
        this.h++;
        ((AbstractList) this).modCount++;
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
        if (!(obj instanceof rf2)) {
            return super.equals(obj);
        }
        rf2 rf2 = (rf2) obj;
        if (this.h != rf2.h) {
            return false;
        }
        boolean[] zArr = rf2.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + wg2.b(this.g[i2]);
        }
        return i;
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        e(i);
        boolean[] zArr = this.g;
        boolean z = zArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List, defpackage.of2
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Boolean.valueOf(this.g[i]))) {
                boolean[] zArr = this.g;
                System.arraycopy(zArr, i + 1, zArr, i, this.h - i);
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
            boolean[] zArr = this.g;
            System.arraycopy(zArr, i2, zArr, i, this.h - i2);
            this.h -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        e(i);
        boolean[] zArr = this.g;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    /* Return type fixed from 'zg2' to match base method */
    @Override // defpackage.zg2
    public final /* synthetic */ zg2<Boolean> y0(int i) {
        if (i >= this.h) {
            return new rf2(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }
}
