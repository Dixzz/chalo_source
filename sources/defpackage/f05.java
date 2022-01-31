package defpackage;

import defpackage.s05;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: f05  reason: default package */
/* compiled from: DoubleArrayList */
public final class f05 extends tz4<Double> implements s05.b, RandomAccess, r15 {
    public static final f05 i;
    public double[] g;
    public int h;

    static {
        f05 f05 = new f05(new double[0], 0);
        i = f05;
        f05.f = false;
    }

    public f05() {
        this.g = new double[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i2, Object obj) {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.tz4, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = s05.f3160a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof f05)) {
            return super.addAll(collection);
        }
        f05 f05 = (f05) collection;
        int i2 = f05.h;
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
            System.arraycopy(f05.g, 0, this.g, this.h, f05.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void d(double d) {
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

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f05)) {
            return super.equals(obj);
        }
        f05 f05 = (f05) obj;
        if (this.h != f05.h) {
            return false;
        }
        double[] dArr = f05.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Double.doubleToLongBits(this.g[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Double.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + s05.b(Double.doubleToLongBits(this.g[i3]));
        }
        return i2;
    }

    public final String k(int i2) {
        StringBuilder j0 = hj1.j0("Index:", i2, ", Size:");
        j0.append(this.h);
        return j0.toString();
    }

    /* renamed from: n */
    public s05.b f(int i2) {
        if (i2 >= this.h) {
            return new f05(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4, java.util.List
    public boolean remove(Object obj) {
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

    public void removeRange(int i2, int i3) {
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
    public Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        e(i2);
        double[] dArr = this.g;
        double d = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    public f05(double[] dArr, int i2) {
        this.g = dArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i2) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.tz4, java.util.AbstractCollection, java.util.List
    public boolean add(Double d) {
        d(d.doubleValue());
        return true;
    }
}
