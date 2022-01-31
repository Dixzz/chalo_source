package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: qj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class qj3<E> extends tg3<E> implements RandomAccess {
    public static final qj3<Object> i;
    public E[] g;
    public int h;

    static {
        qj3<Object> qj3 = new qj3<>(new Object[0], 0);
        i = qj3;
        qj3.f = false;
    }

    public qj3(E[] eArr, int i2) {
        this.g = eArr;
        this.h = i2;
    }

    @Override // defpackage.ci3
    public final /* synthetic */ ci3 H0(int i2) {
        if (i2 >= this.h) {
            return new qj3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // j$.util.Collection, defpackage.tg3, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List
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

    @Override // java.util.List, java.util.AbstractList, j$.util.List
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
}
