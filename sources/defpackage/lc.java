package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: lc  reason: default package */
/* compiled from: IntArrayList */
public final class lc extends pb<Integer> implements Object, RandomAccess, ld {
    public static final lc i;
    public int[] g;
    public int h;

    static {
        lc lcVar = new lc(new int[0], 0);
        i = lcVar;
        lcVar.f = false;
    }

    public lc() {
        this.g = new int[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i2, Object obj) {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        Charset charset = mc.f2352a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof lc)) {
            return super.addAll(collection);
        }
        lc lcVar = (lc) collection;
        int i2 = lcVar.h;
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
            System.arraycopy(lcVar.g, 0, this.g, this.h, lcVar.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void d(int i2) {
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

    public final void e(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lc)) {
            return super.equals(obj);
        }
        lc lcVar = (lc) obj;
        if (this.h != lcVar.h) {
            return false;
        }
        int[] iArr = lcVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i2) {
        if (i2 >= this.h) {
            return new lc(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Integer.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + this.g[i3];
        }
        return i2;
    }

    public int k(int i2) {
        e(i2);
        return this.g[i2];
    }

    public final String n(int i2) {
        StringBuilder j0 = hj1.j0("Index:", i2, ", Size:");
        j0.append(this.h);
        return j0.toString();
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.h; i2++) {
            if (obj.equals(Integer.valueOf(this.g[i2]))) {
                int[] iArr = this.g;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.h - i2) - 1);
                this.h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
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
    public Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        e(i2);
        int[] iArr = this.g;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    public lc(int[] iArr, int i2) {
        this.g = iArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i2) {
        b();
        e(i2);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean add(Integer num) {
        d(num.intValue());
        return true;
    }
}
