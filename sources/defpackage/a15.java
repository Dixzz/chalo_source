package defpackage;

import defpackage.s05;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: a15  reason: default package */
/* compiled from: LongArrayList */
public final class a15 extends tz4<Long> implements s05.i, RandomAccess, r15 {
    public static final a15 i;
    public long[] g;
    public int h;

    static {
        a15 a15 = new a15(new long[0], 0);
        i = a15;
        a15.f = false;
    }

    public a15() {
        this.g = new long[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i2, Object obj) {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.tz4, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = s05.f3160a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof a15)) {
            return super.addAll(collection);
        }
        a15 a15 = (a15) collection;
        int i2 = a15.h;
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
            System.arraycopy(a15.g, 0, this.g, this.h, a15.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void d(long j) {
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

    public final void e(int i2) {
        if (i2 < 0 || i2 >= this.h) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a15)) {
            return super.equals(obj);
        }
        a15 a15 = (a15) obj;
        if (this.h != a15.h) {
            return false;
        }
        long[] jArr = a15.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Long.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + s05.b(this.g[i3]);
        }
        return i2;
    }

    public long k(int i2) {
        e(i2);
        return this.g[i2];
    }

    public final String n(int i2) {
        StringBuilder j0 = hj1.j0("Index:", i2, ", Size:");
        j0.append(this.h);
        return j0.toString();
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4, java.util.List
    public boolean remove(Object obj) {
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

    public void removeRange(int i2, int i3) {
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

    /* renamed from: s */
    public s05.i f(int i2) {
        if (i2 >= this.h) {
            return new a15(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        e(i2);
        long[] jArr = this.g;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    public a15(long[] jArr, int i2) {
        this.g = jArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i2) {
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
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.tz4, java.util.AbstractCollection, java.util.List
    public boolean add(Long l) {
        d(l.longValue());
        return true;
    }
}
