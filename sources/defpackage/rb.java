package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: rb  reason: default package */
/* compiled from: BooleanArrayList */
public final class rb extends pb<Boolean> implements Object, RandomAccess, ld {
    public static final rb i;
    public boolean[] g;
    public int h;

    static {
        rb rbVar = new rb(new boolean[0], 0);
        i = rbVar;
        rbVar.f = false;
    }

    public rb() {
        this.g = new boolean[10];
        this.h = 0;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.h)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        boolean[] zArr = this.g;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[hj1.o(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.g, i2, zArr2, i2 + 1, this.h - i2);
            this.g = zArr2;
        }
        this.g[i2] = booleanValue;
        this.h++;
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Charset charset = mc.f2352a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof rb)) {
            return super.addAll(collection);
        }
        rb rbVar = (rb) collection;
        int i2 = rbVar.h;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.h;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.g;
            if (i4 > zArr.length) {
                this.g = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(rbVar.g, 0, this.g, this.h, rbVar.h);
            this.h = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void d(boolean z) {
        b();
        int i2 = this.h;
        boolean[] zArr = this.g;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[hj1.o(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.g = zArr2;
        }
        boolean[] zArr3 = this.g;
        int i3 = this.h;
        this.h = i3 + 1;
        zArr3[i3] = z;
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
        if (!(obj instanceof rb)) {
            return super.equals(obj);
        }
        rb rbVar = (rb) obj;
        if (this.h != rbVar.h) {
            return false;
        }
        boolean[] zArr = rbVar.g;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i2) {
        if (i2 >= this.h) {
            return new rb(Arrays.copyOf(this.g, i2), this.h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i2) {
        e(i2);
        return Boolean.valueOf(this.g[i2]);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.h; i3++) {
            i2 = (i2 * 31) + mc.a(this.g[i3]);
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
            if (obj.equals(Boolean.valueOf(this.g[i2]))) {
                boolean[] zArr = this.g;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.h - i2) - 1);
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
            boolean[] zArr = this.g;
            System.arraycopy(zArr, i3, zArr, i2, this.h - i3);
            this.h -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        e(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.h;
    }

    public rb(boolean[] zArr, int i2) {
        this.g = zArr;
        this.h = i2;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i2) {
        b();
        e(i2);
        boolean[] zArr = this.g;
        boolean z = zArr[i2];
        int i3 = this.h;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // j$.util.Collection, java.util.Collection, java.util.AbstractList, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean add(Boolean bool) {
        d(bool.booleanValue());
        return true;
    }
}
