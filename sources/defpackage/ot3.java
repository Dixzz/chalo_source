package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ot3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ot3 extends lt3<Boolean> implements zu3<Boolean>, lw3, RandomAccess {
    public boolean[] g;
    public int h;

    static {
        new ot3(new boolean[0], 0).f = false;
    }

    public ot3() {
        this.g = new boolean[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
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
        this.g[i] = booleanValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof ot3)) {
            return super.addAll(collection);
        }
        ot3 ot3 = (ot3) collection;
        int i = ot3.h;
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
            System.arraycopy(ot3.g, 0, this.g, this.h, ot3.h);
            this.h = i3;
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
        int i = this.h;
        boolean[] zArr = this.g;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[hj1.o(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.g = zArr2;
        }
        boolean[] zArr3 = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        zArr3[i2] = z;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.h) {
            throw new IndexOutOfBoundsException(k(i));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ot3)) {
            return super.equals(obj);
        }
        ot3 ot3 = (ot3) obj;
        if (this.h != ot3.h) {
            return false;
        }
        boolean[] zArr = ot3.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + tu3.b(this.g[i2]);
        }
        return i;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.g[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    /* Return type fixed from 'zu3' to match base method */
    @Override // defpackage.zu3
    public final /* synthetic */ zu3<Boolean> j(int i) {
        if (i >= this.h) {
            return new ot3(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final /* synthetic */ Boolean remove(int i) {
        b();
        e(i);
        boolean[] zArr = this.g;
        boolean z = zArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
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

    @Override // java.util.AbstractList, j$.util.List, java.util.List
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

    public ot3(boolean[] zArr, int i) {
        this.g = zArr;
        this.h = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Boolean bool) {
        d(bool.booleanValue());
        return true;
    }
}
