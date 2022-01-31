package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: km2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class km2<E> extends t83<E> implements RandomAccess {
    public static final km2<Object> i;
    public E[] g;
    public int h;

    static {
        km2<Object> km2 = new km2<>(new Object[0], 0);
        i = km2;
        km2.f = false;
    }

    public km2(E[] eArr, int i2) {
        this.g = eArr;
        this.h = i2;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new km2(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final void add(int i2, E e) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(e(i2));
        }
        E[] eArr = this.g;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = (E[]) new Object[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.g, i2, eArr2, i2 + 1, this.h - i2);
            this.g = eArr2;
        }
        this.g[i2] = e;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    public final String e(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final E get(int i2) {
        d(i2);
        return this.g[i2];
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List, defpackage.t83
    public final E remove(int i2) {
        b();
        d(i2);
        E[] eArr = this.g;
        E e = eArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final E set(int i2, E e) {
        b();
        d(i2);
        E[] eArr = this.g;
        E e2 = eArr[i2];
        eArr[i2] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83
    public final boolean add(E e) {
        b();
        int i2 = this.h;
        E[] eArr = this.g;
        if (i2 == eArr.length) {
            this.g = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        eArr2[i3] = e;
        ((AbstractList) this).modCount++;
        return true;
    }
}
