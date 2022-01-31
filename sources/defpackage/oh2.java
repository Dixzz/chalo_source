package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: oh2  reason: default package */
public final class oh2 extends of2<Long> implements zg2<Long>, RandomAccess {
    public long[] g;
    public int h;

    static {
        new oh2().f = false;
    }

    public oh2() {
        this.g = new long[10];
        this.h = 0;
    }

    public oh2(long[] jArr, int i) {
        this.g = jArr;
        this.h = i;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        n(i, ((Long) obj).longValue());
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof oh2)) {
            return super.addAll(collection);
        }
        oh2 oh2 = (oh2) collection;
        int i = oh2.h;
        if (i == 0) {
            return false;
        }
        int i2 = this.h;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.g;
            if (i3 > jArr.length) {
                this.g = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(oh2.g, 0, this.g, this.h, oh2.h);
            this.h = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final long d(int i) {
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
        if (!(obj instanceof oh2)) {
            return super.equals(obj);
        }
        oh2 oh2 = (oh2) obj;
        if (this.h != oh2.h) {
            return false;
        }
        long[] jArr = oh2.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final Object get(int i) {
        e(i);
        return Long.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + wg2.c(this.g[i2]);
        }
        return i;
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    public final void n(int i, long j) {
        int i2;
        b();
        if (i < 0 || i > (i2 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        long[] jArr = this.g;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.g, i, jArr2, i + 1, this.h - i);
            this.g = jArr2;
        }
        this.g[i] = j;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        e(i);
        long[] jArr = this.g;
        long j = jArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List, defpackage.of2
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Long.valueOf(this.g[i]))) {
                long[] jArr = this.g;
                System.arraycopy(jArr, i + 1, jArr, i, this.h - i);
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
            long[] jArr = this.g;
            System.arraycopy(jArr, i2, jArr, i, this.h - i2);
            this.h -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        e(i);
        long[] jArr = this.g;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    /* Return type fixed from 'zg2' to match base method */
    @Override // defpackage.zg2
    public final /* synthetic */ zg2<Long> y0(int i) {
        if (i >= this.h) {
            return new oh2(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }
}
