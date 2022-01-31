package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: uc  reason: default package */
/* compiled from: LongArrayList */
public final class uc extends pb<Long> implements Object, RandomAccess, ld {
    public static final uc i;
    public long[] g;
    public int h;

    static {
        uc ucVar = new uc(new long[0], 0);
        i = ucVar;
        ucVar.f = false;
    }

    public uc() {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        b();
        Charset charset = mc.f2352a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof uc)) {
            return super.addAll(collection);
        }
        uc ucVar = (uc) collection;
        int i2 = ucVar.h;
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
            System.arraycopy(ucVar.g, 0, this.g, this.h, ucVar.h);
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

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uc)) {
            return super.equals(obj);
        }
        uc ucVar = (uc) obj;
        if (this.h != ucVar.h) {
            return false;
        }
        long[] jArr = ucVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i2) {
        if (i2 >= this.h) {
            return new uc(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Long.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + mc.b(this.g[i3]);
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

    @Override // j$.util.Collection, j$.util.List, defpackage.pb, java.util.List
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

    public uc(long[] jArr, int i2) {
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
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean add(Long l) {
        d(l.longValue());
        return true;
    }
}
