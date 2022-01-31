package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: vg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class vg3 extends tg3<Boolean> implements ci3<Boolean>, oj3, RandomAccess {
    public static final vg3 i;
    public boolean[] g;
    public int h;

    static {
        vg3 vg3 = new vg3(new boolean[0], 0);
        i = vg3;
        vg3.f = false;
    }

    public vg3() {
        this.g = new boolean[10];
        this.h = 0;
    }

    /* Return type fixed from 'ci3' to match base method */
    @Override // defpackage.ci3
    public final /* synthetic */ ci3<Boolean> H0(int i2) {
        if (i2 >= this.h) {
            return new vg3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(e(i2));
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

    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Charset charset = zh3.f4175a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof vg3)) {
            return super.addAll(collection);
        }
        vg3 vg3 = (vg3) collection;
        int i2 = vg3.h;
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
            System.arraycopy(vg3.g, 0, this.g, this.h, vg3.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    public final String e(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vg3)) {
            return super.equals(obj);
        }
        vg3 vg3 = (vg3) obj;
        if (this.h != vg3.h) {
            return false;
        }
        boolean[] zArr = vg3.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object get(int i2) {
        d(i2);
        return Boolean.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + zh3.b(this.g[i3]);
        }
        return i2;
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.h; i2++) {
            if (obj.equals(Boolean.valueOf(this.g[i2]))) {
                boolean[] zArr = this.g;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.h - i2) - 1);
                this.h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
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
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        d(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public vg3(boolean[] zArr, int i2) {
        this.g = zArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        d(i2);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, java.util.AbstractList, j$.util.List, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
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
        zArr3[i3] = booleanValue;
        return true;
    }
}
