package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ti3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ti3 extends tg3<Long> implements ci3<Long>, oj3, RandomAccess {
    public static final ti3 i;
    public long[] g;
    public int h;

    static {
        ti3 ti3 = new ti3(new long[0], 0);
        i = ti3;
        ti3.f = false;
    }

    public ti3() {
        this.g = new long[10];
        this.h = 0;
    }

    /* Return type fixed from 'ci3' to match base method */
    @Override // defpackage.ci3
    public final /* synthetic */ ci3<Long> H0(int i2) {
        if (i2 >= this.h) {
            return new ti3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        long[] jArr = this.g;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.g, i2, jArr2, i2 + 1, this.h - i2);
            this.g = jArr2;
        }
        this.g[i2] = longValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = zh3.f4175a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof ti3)) {
            return super.addAll(collection);
        }
        ti3 ti3 = (ti3) collection;
        int i2 = ti3.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.g;
            if (i4 > jArr.length) {
                this.g = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(ti3.g, 0, this.g, this.h, ti3.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final long d(int i2) {
        e(i2);
        return this.g[i2];
    }

    public final void e(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ti3)) {
            return super.equals(obj);
        }
        ti3 ti3 = (ti3) obj;
        if (this.h != ti3.h) {
            return false;
        }
        long[] jArr = ti3.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final Object get(int i2) {
        e(i2);
        return Long.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + zh3.c(this.g[i3]);
        }
        return i2;
    }

    public final String k(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.h; i2++) {
            if (obj.equals(Long.valueOf(this.g[i2]))) {
                long[] jArr = this.g;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.h - i2) - 1);
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
            long[] jArr = this.g;
            System.arraycopy(jArr, i3, jArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        e(i2);
        long[] jArr = this.g;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public ti3(long[] jArr, int i2) {
        this.g = jArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        e(i2);
        long[] jArr = this.g;
        long j = jArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, java.util.AbstractList, j$.util.List, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Long l) {
        long longValue = l.longValue();
        b();
        int i2 = this.h;
        long[] jArr = this.g;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.g = jArr2;
        }
        long[] jArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        jArr3[i3] = longValue;
        return true;
    }
}
