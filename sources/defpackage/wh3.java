package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: wh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class wh3 extends tg3<Integer> implements ci3<Integer>, oj3, RandomAccess {
    public int[] g;
    public int h;

    static {
        new wh3(new int[0], 0).f = false;
    }

    public wh3() {
        this.g = new int[10];
        this.h = 0;
    }

    /* Return type fixed from 'ci3' to match base method */
    @Override // defpackage.ci3
    public final /* synthetic */ ci3<Integer> H0(int i) {
        if (i >= this.h) {
            return new wh3(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i < 0 || i > (i2 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        int[] iArr = this.g;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.g, i, iArr2, i + 1, this.h - i);
            this.g = iArr2;
        }
        this.g[i] = intValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        Charset charset = zh3.f4175a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof wh3)) {
            return super.addAll(collection);
        }
        wh3 wh3 = (wh3) collection;
        int i = wh3.h;
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
            System.arraycopy(wh3.g, 0, this.g, this.h, wh3.h);
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

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wh3)) {
            return super.equals(obj);
        }
        wh3 wh3 = (wh3) obj;
        if (this.h != wh3.h) {
            return false;
        }
        int[] iArr = wh3.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final Object get(int i) {
        e(i);
        return Integer.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
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

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Integer.valueOf(this.g[i]))) {
                int[] iArr = this.g;
                System.arraycopy(iArr, i + 1, iArr, i, (this.h - i) - 1);
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

    @Override // java.util.AbstractList, j$.util.List, java.util.List
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

    public wh3(int[] iArr, int i) {
        this.g = iArr;
        this.h = i;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        e(i);
        int[] iArr = this.g;
        int i2 = iArr[i];
        int i3 = this.h;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, java.util.AbstractList, j$.util.List, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Integer num) {
        int intValue = num.intValue();
        b();
        int i = this.h;
        int[] iArr = this.g;
        if (i == iArr.length) {
            int[] iArr2 = new int[hj1.o(i, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.g = iArr2;
        }
        int[] iArr3 = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        iArr3[i2] = intValue;
        return true;
    }
}
