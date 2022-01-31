package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: w83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class w83 extends t83<Boolean> implements RandomAccess, ja3, hm2 {
    public static final w83 i;
    public boolean[] g;
    public int h;

    static {
        w83 w83 = new w83(new boolean[0], 0);
        i = w83;
        w83.f = false;
    }

    public w83() {
        this.g = new boolean[10];
        this.h = 0;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new w83(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        boolean[] zArr = this.g;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.g, i2, zArr2, i2 + 1, this.h - i2);
            this.g = zArr2;
        }
        this.g[i2] = booleanValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Boolean bool) {
        d(bool.booleanValue());
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof w83)) {
            return super.addAll(collection);
        }
        w83 w83 = (w83) collection;
        int i2 = w83.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.g;
            if (i4 > zArr.length) {
                this.g = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(w83.g, 0, this.g, this.h, w83.h);
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

    public final void d(boolean z) {
        b();
        int i2 = this.h;
        boolean[] zArr = this.g;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.g = zArr2;
        }
        boolean[] zArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        zArr3[i3] = z;
    }

    public final void e(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w83)) {
            return super.equals(obj);
        }
        w83 w83 = (w83) obj;
        if (this.h != w83.h) {
            return false;
        }
        boolean[] zArr = w83.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        e(i2);
        return Boolean.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + ka3.b(this.g[i3]);
        }
        return i2;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == booleanValue) {
                return i3;
            }
        }
        return -1;
    }

    public final String k(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.t83, java.util.List
    public final /* bridge */ /* synthetic */ Boolean remove(int i2) {
        b();
        e(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    public final void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            boolean[] zArr = this.g;
            System.arraycopy(zArr, i3, zArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        e(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public w83(boolean[] zArr, int i2) {
        this.g = zArr;
        this.h = i2;
    }
}
