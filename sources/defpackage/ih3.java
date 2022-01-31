package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ih3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ih3 extends tg3<Double> implements ci3<Double>, oj3, RandomAccess {
    public static final ih3 i;
    public double[] g;
    public int h;

    static {
        ih3 ih3 = new ih3(new double[0], 0);
        i = ih3;
        ih3.f = false;
    }

    public ih3() {
        this.g = new double[10];
        this.h = 0;
    }

    /* Return type fixed from 'ci3' to match base method */
    @Override // defpackage.ci3
    public final /* synthetic */ ci3<Double> H0(int i2) {
        if (i2 >= this.h) {
            return new ih3(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(e(i2));
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

    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = zh3.f4175a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof ih3)) {
            return super.addAll(collection);
        }
        ih3 ih3 = (ih3) collection;
        int i2 = ih3.h;
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
            System.arraycopy(ih3.g, 0, this.g, this.h, ih3.h);
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
        if (!(obj instanceof ih3)) {
            return super.equals(obj);
        }
        ih3 ih3 = (ih3) obj;
        if (this.h != ih3.h) {
            return false;
        }
        double[] dArr = ih3.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Double.doubleToLongBits(this.g[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object get(int i2) {
        d(i2);
        return Double.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + zh3.c(Double.doubleToLongBits(this.g[i3]));
        }
        return i2;
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.h; i2++) {
            if (obj.equals(Double.valueOf(this.g[i2]))) {
                double[] dArr = this.g;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.h - i2) - 1);
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
            double[] dArr = this.g;
            System.arraycopy(dArr, i3, dArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        d(i2);
        double[] dArr = this.g;
        double d = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public ih3(double[] dArr, int i2) {
        this.g = dArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        d(i2);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, java.util.AbstractList, j$.util.List, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Double d) {
        double doubleValue = d.doubleValue();
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
        dArr3[i3] = doubleValue;
        return true;
    }
}
