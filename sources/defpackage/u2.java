package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: u2  reason: default package */
/* compiled from: SimpleArrayMap */
public class u2<K, V> {
    public static Object[] i;
    public static int j;
    public static Object[] k;
    public static int l;
    public int[] f;
    public Object[] g;
    public int h;

    public u2() {
        this.f = q2.f2886a;
        this.g = q2.c;
        this.h = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (u2.class) {
                if (l < 10) {
                    objArr[0] = k;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    k = objArr;
                    l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (u2.class) {
                if (j < 10) {
                    objArr[0] = i;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    i = objArr;
                    j++;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (u2.class) {
                Object[] objArr = k;
                if (objArr != null) {
                    this.g = objArr;
                    k = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    l--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (u2.class) {
                Object[] objArr2 = i;
                if (objArr2 != null) {
                    this.g = objArr2;
                    i = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    j--;
                    return;
                }
            }
        }
        this.f = new int[i2];
        this.g = new Object[(i2 << 1)];
    }

    public void b(int i2) {
        int i3 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i2) {
            Object[] objArr = this.g;
            a(i2);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i3);
                System.arraycopy(objArr, 0, this.g, 0, i3 << 1);
            }
            c(iArr, objArr, i3);
        }
        if (this.h != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.h;
        if (i2 > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = q2.f2886a;
            this.g = q2.c;
            this.h = 0;
            c(iArr, objArr, i2);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public int d(Object obj, int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a2 = q2.a(this.f, i3, i2);
            if (a2 < 0 || obj.equals(this.g[a2 << 1])) {
                return a2;
            }
            int i4 = a2 + 1;
            while (i4 < i3 && this.f[i4] == i2) {
                if (obj.equals(this.g[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            int i5 = a2 - 1;
            while (i5 >= 0 && this.f[i5] == i2) {
                if (obj.equals(this.g[i5 << 1])) {
                    return i5;
                }
                i5--;
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u2) {
            u2 u2Var = (u2) obj;
            if (this.h != u2Var.h) {
                return false;
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                try {
                    K h2 = h(i2);
                    V l2 = l(i2);
                    Object obj2 = u2Var.get(h2);
                    if (l2 == null) {
                        if (obj2 != null || !u2Var.containsKey(h2)) {
                            return false;
                        }
                    } else if (!l2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.h != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.h; i3++) {
                try {
                    K h3 = h(i3);
                    V l3 = l(i3);
                    Object obj3 = map.get(h3);
                    if (l3 == null) {
                        if (obj3 != null || !map.containsKey(h3)) {
                            return false;
                        }
                    } else if (!l3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        try {
            int a2 = q2.a(this.f, i2, 0);
            if (a2 < 0 || this.g[a2 << 1] == null) {
                return a2;
            }
            int i3 = a2 + 1;
            while (i3 < i2 && this.f[i3] == 0) {
                if (this.g[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            int i4 = a2 - 1;
            while (i4 >= 0 && this.f[i4] == 0) {
                if (this.g[i4 << 1] == null) {
                    return i4;
                }
                i4--;
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int g(Object obj) {
        int i2 = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int e = e(obj);
        return e >= 0 ? (V) this.g[(e << 1) + 1] : v;
    }

    public K h(int i2) {
        return (K) this.g[i2 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i2 = this.h;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: u2<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public void i(u2<? extends K, ? extends V> u2Var) {
        int i2 = u2Var.h;
        b(this.h + i2);
        if (this.h != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(u2Var.h(i3), u2Var.l(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(u2Var.f, 0, this.f, 0, i2);
            System.arraycopy(u2Var.g, 0, this.g, 0, i2 << 1);
            this.h = i2;
        }
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V j(int i2) {
        Object[] objArr = this.g;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.h;
        int i5 = 0;
        if (i4 <= 1) {
            c(this.f, objArr, i4);
            this.f = q2.f2886a;
            this.g = q2.c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f;
            int i7 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i8 = i2 + 1;
                    int i9 = i6 - i2;
                    System.arraycopy(iArr, i8, iArr, i2, i9);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i3, i9 << 1);
                }
                Object[] objArr3 = this.g;
                int i10 = i6 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                if (i4 > 8) {
                    i7 = i4 + (i4 >> 1);
                }
                a(i7);
                if (i4 == this.h) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.f, 0, i2);
                        System.arraycopy(objArr, 0, this.g, 0, i3);
                    }
                    if (i2 < i6) {
                        int i11 = i2 + 1;
                        int i12 = i6 - i2;
                        System.arraycopy(iArr, i11, this.f, i2, i12);
                        System.arraycopy(objArr, i11 << 1, this.g, i3, i12 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i5 = i6;
        }
        if (i4 == this.h) {
            this.h = i5;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V k(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V l(int i2) {
        return (V) this.g[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int i3;
        int i4 = this.h;
        if (k2 == null) {
            i3 = f();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = d(k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i5];
            objArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        int[] iArr = this.f;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.g;
            a(i7);
            if (i4 == this.h) {
                int[] iArr2 = this.f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
                }
                c(iArr, objArr2, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.h - i6) << 1);
        }
        int i9 = this.h;
        if (i4 == i9) {
            int[] iArr4 = this.f;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr4 = this.g;
                int i10 = i6 << 1;
                objArr4[i10] = k2;
                objArr4[i10 + 1] = v;
                this.h = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V orDefault = getOrDefault(k2, null);
        return orDefault == null ? put(k2, v) : orDefault;
    }

    public V remove(Object obj) {
        int e = e(obj);
        if (e >= 0) {
            return j(e);
        }
        return null;
    }

    public V replace(K k2, V v) {
        int e = e(k2);
        if (e >= 0) {
            return k(e, v);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K h2 = h(i2);
            if (h2 != this) {
                sb.append((Object) h2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l2 = l(i2);
            if (l2 != this) {
                sb.append((Object) l2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int e = e(obj);
        if (e < 0) {
            return false;
        }
        V l2 = l(e);
        if (obj2 != l2 && (obj2 == null || !obj2.equals(l2))) {
            return false;
        }
        j(e);
        return true;
    }

    public boolean replace(K k2, V v, V v2) {
        int e = e(k2);
        if (e < 0) {
            return false;
        }
        V l2 = l(e);
        if (l2 != v && (v == null || !v.equals(l2))) {
            return false;
        }
        k(e, v2);
        return true;
    }

    public u2(int i2) {
        if (i2 == 0) {
            this.f = q2.f2886a;
            this.g = q2.c;
        } else {
            a(i2);
        }
        this.h = 0;
    }
}
