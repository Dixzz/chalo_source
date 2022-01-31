package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ic  reason: default package */
/* compiled from: FloatArrayList */
public final class ic extends pb<Float> implements Object, RandomAccess, ld {
    public static final ic i;
    public float[] g;
    public int h;

    static {
        ic icVar = new ic(new float[0], 0);
        i = icVar;
        icVar.f = false;
    }

    public ic() {
        this.g = new float[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i2, Object obj) {
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

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        b();
        Charset charset = mc.f2352a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof ic)) {
            return super.addAll(collection);
        }
        ic icVar = (ic) collection;
        int i2 = icVar.h;
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
            System.arraycopy(icVar.g, 0, this.g, this.h, icVar.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void d(float f) {
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

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ic)) {
            return super.equals(obj);
        }
        ic icVar = (ic) obj;
        if (this.h != icVar.h) {
            return false;
        }
        float[] fArr = icVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (Float.floatToIntBits(this.g[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i2) {
        if (i2 >= this.h) {
            return new ic(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Float.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.g[i3]);
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
            if (obj.equals(Float.valueOf(this.g[i2]))) {
                float[] fArr = this.g;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.h - i2) - 1);
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
            float[] fArr = this.g;
            System.arraycopy(fArr, i3, fArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        e(i2);
        float[] fArr = this.g;
        float f = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    public ic(float[] fArr, int i2) {
        this.g = fArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i2) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean add(Float f) {
        d(f.floatValue());
        return true;
    }
}
