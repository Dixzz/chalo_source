package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: z93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z93 extends t83<Float> implements RandomAccess, ja3, hm2 {
    public static final z93 i;
    public float[] g;
    public int h;

    static {
        z93 z93 = new z93(new float[0], 0);
        i = z93;
        z93.f = false;
    }

    public z93() {
        this.g = new float[10];
        this.h = 0;
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i2) {
        if (i2 >= this.h) {
            return new z93(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        float[] fArr = this.g;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.g, i2, fArr2, i2 + 1, this.h - i2);
            this.g = fArr2;
        }
        this.g[i2] = floatValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Float f) {
        d(f.floatValue());
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof z93)) {
            return super.addAll(collection);
        }
        z93 z93 = (z93) collection;
        int i2 = z93.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.g;
            if (i4 > fArr.length) {
                this.g = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(z93.g, 0, this.g, this.h, z93.h);
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

    public final void d(float f) {
        b();
        int i2 = this.h;
        float[] fArr = this.g;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.g = fArr2;
        }
        float[] fArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        fArr3[i3] = f;
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
        if (!(obj instanceof z93)) {
            return super.equals(obj);
        }
        z93 z93 = (z93) obj;
        if (this.h != z93.h) {
            return false;
        }
        float[] fArr = z93.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Float.floatToIntBits(this.g[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        e(i2);
        return Float.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.g[i3]);
        }
        return i2;
    }

    @Override // j$.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == floatValue) {
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
    public final /* bridge */ /* synthetic */ Float remove(int i2) {
        b();
        e(i2);
        float[] fArr = this.g;
        float f = fArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    public final void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            float[] fArr = this.g;
            System.arraycopy(fArr, i3, fArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        e(i2);
        float[] fArr = this.g;
        float f = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f);
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.h;
    }

    public z93(float[] fArr, int i2) {
        this.g = fArr;
        this.h = i2;
    }
}
