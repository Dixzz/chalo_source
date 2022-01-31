package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: zb  reason: default package */
/* compiled from: DoubleArrayList */
public final class zb extends pb<Double> implements Object, RandomAccess, ld {
    public static final zb i;
    public double[] g;
    public int h;

    static {
        zb zbVar = new zb(new double[0], 0);
        i = zbVar;
        zbVar.f = false;
    }

    public zb() {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        b();
        Charset charset = mc.f2352a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof zb)) {
            return super.addAll(collection);
        }
        zb zbVar = (zb) collection;
        int i2 = zbVar.h;
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
            System.arraycopy(zbVar.g, 0, this.g, this.h, zbVar.h);
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

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zb)) {
            return super.equals(obj);
        }
        zb zbVar = (zb) obj;
        if (this.h != zbVar.h) {
            return false;
        }
        double[] dArr = zbVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Double.doubleToLongBits(this.g[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i2) {
        if (i2 >= this.h) {
            return new zb(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Double.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + mc.b(Double.doubleToLongBits(this.g[i3]));
        }
        return i2;
    }

    public final String k(int i2) {
        StringBuilder j0 = hj1.j0("Index:", i2, ", Size:");
        j0.append(this.h);
        return j0.toString();
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb, java.util.List
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

    public zb(double[] dArr, int i2) {
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
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean add(Double d) {
        d(d.doubleValue());
        return true;
    }
}
