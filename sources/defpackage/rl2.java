package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: rl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class rl2 extends t83<Long> implements RandomAccess, ja3, hm2 {
    public static final rl2 i;
    public long[] g;
    public int h;

    static {
        rl2 rl2 = new rl2(new long[0], 0);
        i = rl2;
        rl2.f = false;
    }

    public rl2() {
        this.g = new long[10];
        this.h = 0;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new rl2(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(n(i2));
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Long l) {
        e(l.longValue());
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof rl2)) {
            return super.addAll(collection);
        }
        rl2 rl2 = (rl2) collection;
        int i2 = rl2.h;
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
            System.arraycopy(rl2.g, 0, this.g, this.h, rl2.h);
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

    public final long d(int i2) {
        k(i2);
        return this.g[i2];
    }

    public final void e(long j) {
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
        jArr3[i3] = j;
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rl2)) {
            return super.equals(obj);
        }
        rl2 rl2 = (rl2) obj;
        if (this.h != rl2.h) {
            return false;
        }
        long[] jArr = rl2.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        k(i2);
        return Long.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + ka3.a(this.g[i3]);
        }
        return i2;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == longValue) {
                return i3;
            }
        }
        return -1;
    }

    public final void k(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    public final String n(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.t83, java.util.List
    public final /* bridge */ /* synthetic */ Long remove(int i2) {
        b();
        k(i2);
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
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        k(i2);
        long[] jArr = this.g;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public rl2(long[] jArr, int i2) {
        this.g = jArr;
        this.h = i2;
    }
}
