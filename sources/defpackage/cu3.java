package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: cu3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class cu3 extends lt3<Double> implements zu3<Double>, lw3, RandomAccess {
    public double[] g;
    public int h;

    static {
        new cu3(new double[0], 0).f = false;
    }

    public cu3() {
        this.g = new double[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
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
        this.g[i] = doubleValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof cu3)) {
            return super.addAll(collection);
        }
        cu3 cu3 = (cu3) collection;
        int i = cu3.h;
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
            System.arraycopy(cu3.g, 0, this.g, this.h, cu3.h);
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

    public final void d(double d) {
        b();
        int i = this.h;
        double[] dArr = this.g;
        if (i == dArr.length) {
            double[] dArr2 = new double[hj1.o(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.g = dArr2;
        }
        double[] dArr3 = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        dArr3[i2] = d;
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
        if (!(obj instanceof cu3)) {
            return super.equals(obj);
        }
        cu3 cu3 = (cu3) obj;
        if (this.h != cu3.h) {
            return false;
        }
        double[] dArr = cu3.g;
        for (int i = 0; i < this.h; i++) {
            if (Double.doubleToLongBits(this.g[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Double.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + tu3.a(Double.doubleToLongBits(this.g[i2]));
        }
        return i;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.g[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    /* Return type fixed from 'zu3' to match base method */
    @Override // defpackage.zu3
    public final /* synthetic */ zu3<Double> j(int i) {
        if (i >= this.h) {
            return new cu3(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final /* synthetic */ Double remove(int i) {
        b();
        e(i);
        double[] dArr = this.g;
        double d = dArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
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

    @Override // java.util.AbstractList, j$.util.List, java.util.List
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

    public cu3(double[] dArr, int i) {
        this.g = dArr;
        this.h = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Double d) {
        d(d.doubleValue());
        return true;
    }
}
