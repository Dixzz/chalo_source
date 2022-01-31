package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: eg2  reason: default package */
public final class eg2 extends of2<Double> implements zg2<Double>, RandomAccess {
    public double[] g;
    public int h;

    static {
        new eg2().f = false;
    }

    public eg2() {
        this.g = new double[10];
        this.h = 0;
    }

    public eg2(double[] dArr, int i) {
        this.g = dArr;
        this.h = i;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        d(i, ((Double) obj).doubleValue());
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof eg2)) {
            return super.addAll(collection);
        }
        eg2 eg2 = (eg2) collection;
        int i = eg2.h;
        if (i == 0) {
            return false;
        }
        int i2 = this.h;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.g;
            if (i3 > dArr.length) {
                this.g = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(eg2.g, 0, this.g, this.h, eg2.h);
            this.h = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void d(int i, double d) {
        int i2;
        b();
        if (i < 0 || i > (i2 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        double[] dArr = this.g;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.g, i, dArr2, i + 1, this.h - i);
            this.g = dArr2;
        }
        this.g[i] = d;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.h) {
            throw new IndexOutOfBoundsException(k(i));
        }
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eg2)) {
            return super.equals(obj);
        }
        eg2 eg2 = (eg2) obj;
        if (this.h != eg2.h) {
            return false;
        }
        double[] dArr = eg2.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Double.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + wg2.c(Double.doubleToLongBits(this.g[i2]));
        }
        return i;
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        e(i);
        double[] dArr = this.g;
        double d = dArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, i2 - i);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List, defpackage.of2
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Double.valueOf(this.g[i]))) {
                double[] dArr = this.g;
                System.arraycopy(dArr, i + 1, dArr, i, this.h - i);
                this.h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        b();
        if (i2 >= i) {
            double[] dArr = this.g;
            System.arraycopy(dArr, i2, dArr, i, this.h - i2);
            this.h -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        e(i);
        double[] dArr = this.g;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    /* Return type fixed from 'zg2' to match base method */
    @Override // defpackage.zg2
    public final /* synthetic */ zg2<Double> y0(int i) {
        if (i >= this.h) {
            return new eg2(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }
}
