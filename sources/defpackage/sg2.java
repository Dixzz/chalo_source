package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: sg2  reason: default package */
public final class sg2 extends of2<Float> implements zg2<Float>, RandomAccess {
    public float[] g;
    public int h;

    static {
        new sg2().f = false;
    }

    public sg2() {
        this.g = new float[10];
        this.h = 0;
    }

    public sg2(float[] fArr, int i) {
        this.g = fArr;
        this.h = i;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        d(i, ((Float) obj).floatValue());
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, j$.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof sg2)) {
            return super.addAll(collection);
        }
        sg2 sg2 = (sg2) collection;
        int i = sg2.h;
        if (i == 0) {
            return false;
        }
        int i2 = this.h;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.g;
            if (i3 > fArr.length) {
                this.g = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(sg2.g, 0, this.g, this.h, sg2.h);
            this.h = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void d(int i, float f) {
        int i2;
        b();
        if (i < 0 || i > (i2 = this.h)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        float[] fArr = this.g;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.g, i, fArr2, i + 1, this.h - i);
            this.g = fArr2;
        }
        this.g[i] = f;
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
        if (!(obj instanceof sg2)) {
            return super.equals(obj);
        }
        sg2 sg2 = (sg2) obj;
        if (this.h != sg2.h) {
            return false;
        }
        float[] fArr = sg2.g;
        for (int i = 0; i < this.h; i++) {
            if (this.g[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Float.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.g[i2]);
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
        float[] fArr = this.g;
        float f = fArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // j$.util.Collection, java.util.List, j$.util.List, defpackage.of2
    public final boolean remove(Object obj) {
        b();
        for (int i = 0; i < this.h; i++) {
            if (obj.equals(Float.valueOf(this.g[i]))) {
                float[] fArr = this.g;
                System.arraycopy(fArr, i + 1, fArr, i, this.h - i);
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
            float[] fArr = this.g;
            System.arraycopy(fArr, i2, fArr, i, this.h - i2);
            this.h -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        e(i);
        float[] fArr = this.g;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    /* Return type fixed from 'zg2' to match base method */
    @Override // defpackage.zg2
    public final /* synthetic */ zg2<Float> y0(int i) {
        if (i >= this.h) {
            return new sg2(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }
}
