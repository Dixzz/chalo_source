package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: qv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class qv3 extends lt3<Long> implements av3, lw3, RandomAccess {
    public static final qv3 i;
    public long[] g;
    public int h;

    static {
        qv3 qv3 = new qv3(new long[0], 0);
        i = qv3;
        qv3.f = false;
    }

    public qv3() {
        this.g = new long[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(s(i2));
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof qv3)) {
            return super.addAll(collection);
        }
        qv3 qv3 = (qv3) collection;
        int i2 = qv3.h;
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
            System.arraycopy(qv3.g, 0, this.g, this.h, qv3.h);
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

    public final void d(long j) {
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

    public final long e(int i2) {
        n(i2);
        return this.g[i2];
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qv3)) {
            return super.equals(obj);
        }
        qv3 qv3 = (qv3) obj;
        if (this.h != qv3.h) {
            return false;
        }
        long[] jArr = qv3.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final Object get(int i2) {
        n(i2);
        return Long.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + tu3.a(this.g[i3]);
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

    /* renamed from: k */
    public final av3 j(int i2) {
        if (i2 >= this.h) {
            return new qv3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    public final void n(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(s(i2));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final /* synthetic */ Long remove(int i2) {
        b();
        n(i2);
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

    public final String s(int i2) {
        return hj1.w(35, "Index:", i2, ", Size:", this.h);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        n(i2);
        long[] jArr = this.g;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public qv3(long[] jArr, int i2) {
        this.g = jArr;
        this.h = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Long l) {
        d(l.longValue());
        return true;
    }
}
