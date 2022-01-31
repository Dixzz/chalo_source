package defpackage;

import defpackage.t2;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: p2  reason: default package */
/* compiled from: ArraySet */
public final class p2<E> implements Collection<E>, Set<E>, j$.util.Collection, j$.util.Set {
    public static final int[] j = new int[0];
    public static final Object[] k = new Object[0];
    public static Object[] l;
    public static int m;
    public static Object[] n;
    public static int o;
    public int[] f;
    public Object[] g;
    public int h;
    public t2<E, E> i;

    public p2() {
        this(0);
    }

    public static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (p2.class) {
                if (o < 10) {
                    objArr[0] = n;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    n = objArr;
                    o++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (p2.class) {
                if (m < 10) {
                    objArr[0] = l;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    l = objArr;
                    m++;
                }
            }
        }
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean add(E e) {
        int i2;
        int i3;
        if (e == null) {
            i3 = k();
            i2 = 0;
        } else {
            int hashCode = e.hashCode();
            i2 = hashCode;
            i3 = e(e, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.h;
        int[] iArr = this.f;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.g;
            b(i6);
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            d(iArr, objArr, this.h);
        }
        int i7 = this.h;
        if (i4 < i7) {
            int[] iArr3 = this.f;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, i4, objArr2, i8, this.h - i4);
        }
        this.f[i4] = i2;
        this.g[i4] = e;
        this.h++;
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: p2<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.h;
        int[] iArr = this.f;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.g;
            b(size);
            int i2 = this.h;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, this.h);
            }
            d(iArr, objArr, this.h);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public final void b(int i2) {
        if (i2 == 8) {
            synchronized (p2.class) {
                Object[] objArr = n;
                if (objArr != null) {
                    this.g = objArr;
                    n = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    o--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (p2.class) {
                Object[] objArr2 = l;
                if (objArr2 != null) {
                    this.g = objArr2;
                    l = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    m--;
                    return;
                }
            }
        }
        this.f = new int[i2];
        this.g = new Object[i2];
    }

    @Override // j$.util.Collection, j$.util.Set
    public void clear() {
        int i2 = this.h;
        if (i2 != 0) {
            d(this.f, this.g, i2);
            this.f = j;
            this.g = k;
            this.h = 0;
        }
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int e(Object obj, int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int a2 = q2.a(this.f, i3, i2);
        if (a2 < 0 || obj.equals(this.g[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f[i4] == i2) {
            if (obj.equals(this.g[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f[i5] == i2) {
            if (obj.equals(this.g[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.h != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                try {
                    if (!set.contains(this.g[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, j$.util.Set
    public int hashCode() {
        int[] iArr = this.f;
        int i2 = this.h;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? k() : e(obj, obj.hashCode());
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean isEmpty() {
        return this.h <= 0;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.i == null) {
            this.i = new o2(this);
        }
        t2<E, E> t2Var = this.i;
        if (t2Var.b == null) {
            t2Var.b = new t2.c();
        }
        return t2Var.b.iterator();
    }

    public final int k() {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = q2.a(this.f, i2, 0);
        if (a2 < 0 || this.g[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f[i3] == 0) {
            if (this.g[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f[i4] == 0) {
            if (this.g[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public E n(int i2) {
        Object[] objArr = this.g;
        E e = (E) objArr[i2];
        int i3 = this.h;
        if (i3 <= 1) {
            d(this.f, objArr, i3);
            this.f = j;
            this.g = k;
            this.h = 0;
        } else {
            int[] iArr = this.f;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.h = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.h - i2);
                }
                this.g[this.h] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                b(i4);
                this.h--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f, 0, i2);
                    System.arraycopy(objArr, 0, this.g, 0, i2);
                }
                int i7 = this.h;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.f, i2, i7 - i2);
                    System.arraycopy(objArr, i8, this.g, i2, this.h - i2);
                }
            }
        }
        return e;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        n(indexOf);
        return true;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(java.util.Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.h - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.g[i2])) {
                n(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // j$.util.Collection, j$.util.Set
    public int size() {
        return this.h;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public Object[] toArray() {
        int i2 = this.h;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.g, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.g[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public p2(int i2) {
        if (i2 == 0) {
            this.f = j;
            this.g = k;
        } else {
            b(i2);
        }
        this.h = 0;
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.h) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.h));
        }
        System.arraycopy(this.g, 0, tArr, 0, this.h);
        int length = tArr.length;
        int i2 = this.h;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
