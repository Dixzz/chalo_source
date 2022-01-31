package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: p93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p93 extends t83<Double> implements RandomAccess, ja3, hm2 {
    public static final p93 i;
    public double[] g;
    public int h;

    static {
        p93 p93 = new p93(new double[0], 0);
        i = p93;
        p93.f = false;
    }

    public p93() {
        this.g = new double[10];
        this.h = 0;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new p93(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        double[] dArr = this.g;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.g, i2, dArr2, i2 + 1, this.h - i2);
            this.g = dArr2;
        }
        this.g[i2] = doubleValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Double d) {
        d(d.doubleValue());
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof p93)) {
            return super.addAll(collection);
        }
        p93 p93 = (p93) collection;
        int i2 = p93.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.g;
            if (i4 > dArr.length) {
                this.g = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(p93.g, 0, this.g, this.h, p93.h);
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

    public final void d(double d) {
        b();
        int i2 = this.h;
        double[] dArr = this.g;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.g = dArr2;
        }
        double[] dArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        dArr3[i3] = d;
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
        if (!(obj instanceof p93)) {
            return super.equals(obj);
        }
        p93 p93 = (p93) obj;
        if (this.h != p93.h) {
            return false;
        }
        double[] dArr = p93.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Double.doubleToLongBits(this.g[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        e(i2);
        return Double.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + ka3.a(Double.doubleToLongBits(this.g[i3]));
        }
        return i2;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == doubleValue) {
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
    public final /* bridge */ /* synthetic */ Double remove(int i2) {
        b();
        e(i2);
        double[] dArr = this.g;
        double d = dArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    public final void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            double[] dArr = this.g;
            System.arraycopy(dArr, i3, dArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        e(i2);
        double[] dArr = this.g;
        double d = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public p93(double[] dArr, int i2) {
        this.g = dArr;
        this.h = i2;
    }
}
