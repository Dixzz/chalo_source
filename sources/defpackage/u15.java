package defpackage;

import defpackage.s05;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: u15  reason: default package */
/* compiled from: ProtobufArrayList */
public final class u15<E> extends tz4<E> implements RandomAccess {
    public static final u15<Object> i;
    public E[] g;
    public int h;

    static {
        u15<Object> u15 = new u15<>(new Object[0], 0);
        i = u15;
        u15.f = false;
    }

    public u15(E[] eArr, int i2) {
        this.g = eArr;
        this.h = i2;
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.tz4
    public boolean add(E e) {
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
        StringBuilder j0 = hj1.j0("Index:", i2, ", Size:");
        j0.append(this.h);
        return j0.toString();
    }

    @Override // defpackage.s05.j
    public s05.j f(int i2) {
        if (i2 >= this.h) {
            return new u15(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public E get(int i2) {
        d(i2);
        return this.g[i2];
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public E remove(int i2) {
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
    public E set(int i2, E e) {
        b();
        d(i2);
        E[] eArr = this.g;
        E e2 = eArr[i2];
        eArr[i2] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public void add(int i2, E e) {
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
