package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: qu3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class qu3 extends lt3<Float> implements zu3<Float>, lw3, RandomAccess {
    public float[] g;
    public int h;

    static {
        new qu3(new float[0], 0).f = false;
    }

    public qu3() {
        this.g = new float[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
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
        this.g[i] = floatValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof qu3)) {
            return super.addAll(collection);
        }
        qu3 qu3 = (qu3) collection;
        int i = qu3.h;
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
            System.arraycopy(qu3.g, 0, this.g, this.h, qu3.h);
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

    public final void d(float f) {
        b();
        int i = this.h;
        float[] fArr = this.g;
        if (i == fArr.length) {
            float[] fArr2 = new float[hj1.o(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.g = fArr2;
        }
        float[] fArr3 = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        fArr3[i2] = f;
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
        if (!(obj instanceof qu3)) {
            return super.equals(obj);
        }
        qu3 qu3 = (qu3) obj;
        if (this.h != qu3.h) {
            return false;
        }
        float[] fArr = qu3.g;
        for (int i = 0; i < this.h; i++) {
            if (Float.floatToIntBits(this.g[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Float.valueOf(this.g[i]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.h; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.g[i2]);
        }
        return i;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.g[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    /* Return type fixed from 'zu3' to match base method */
    @Override // defpackage.zu3
    public final /* synthetic */ zu3<Float> j(int i) {
        if (i >= this.h) {
            return new qu3(Arrays.copyOf(this.g, i), this.h);
        }
        throw new IllegalArgumentException();
    }

    public final String k(int i) {
        return hj1.w(35, "Index:", i, ", Size:", this.h);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final /* synthetic */ Float remove(int i) {
        b();
        e(i);
        float[] fArr = this.g;
        float f = fArr[i];
        int i2 = this.h;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
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

    @Override // java.util.AbstractList, j$.util.List, java.util.List
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

    public qu3(float[] fArr, int i) {
        this.g = fArr;
        this.h = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final /* synthetic */ boolean add(Float f) {
        d(f.floatValue());
        return true;
    }
}
