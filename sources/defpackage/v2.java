package defpackage;

/* renamed from: v2  reason: default package */
/* compiled from: SparseArrayCompat */
public class v2<E> implements Cloneable {
    public static final Object j = new Object();
    public boolean f = false;
    public int[] g;
    public Object[] h;
    public int i;

    public v2() {
        int e = q2.e(10);
        this.g = new int[e];
        this.h = new Object[e];
    }

    public void a(int i2, E e) {
        int i3 = this.i;
        if (i3 == 0 || i2 > this.g[i3 - 1]) {
            if (this.f && i3 >= this.g.length) {
                c();
            }
            int i4 = this.i;
            if (i4 >= this.g.length) {
                int e2 = q2.e(i4 + 1);
                int[] iArr = new int[e2];
                Object[] objArr = new Object[e2];
                int[] iArr2 = this.g;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.h;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.g = iArr;
                this.h = objArr;
            }
            this.g[i4] = i2;
            this.h[i4] = e;
            this.i = i4 + 1;
            return;
        }
        g(i2, e);
    }

    /* renamed from: b */
    public v2<E> clone() {
        try {
            v2<E> v2Var = (v2) super.clone();
            v2Var.g = (int[]) this.g.clone();
            v2Var.h = (Object[]) this.h.clone();
            return v2Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void c() {
        int i2 = this.i;
        int[] iArr = this.g;
        Object[] objArr = this.h;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != j) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f = false;
        this.i = i3;
    }

    public E d(int i2) {
        return e(i2, null);
    }

    public E e(int i2, E e) {
        int a2 = q2.a(this.g, this.i, i2);
        if (a2 >= 0) {
            Object[] objArr = this.h;
            if (objArr[a2] != j) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    public int f(int i2) {
        if (this.f) {
            c();
        }
        return this.g[i2];
    }

    public void g(int i2, E e) {
        int a2 = q2.a(this.g, this.i, i2);
        if (a2 >= 0) {
            this.h[a2] = e;
            return;
        }
        int i3 = ~a2;
        int i4 = this.i;
        if (i3 < i4) {
            Object[] objArr = this.h;
            if (objArr[i3] == j) {
                this.g[i3] = i2;
                objArr[i3] = e;
                return;
            }
        }
        if (this.f && i4 >= this.g.length) {
            c();
            i3 = ~q2.a(this.g, this.i, i2);
        }
        int i5 = this.i;
        if (i5 >= this.g.length) {
            int e2 = q2.e(i5 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.g = iArr;
            this.h = objArr2;
        }
        int i6 = this.i;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.g;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.h;
            System.arraycopy(objArr4, i3, objArr4, i7, this.i - i3);
        }
        this.g[i3] = i2;
        this.h[i3] = e;
        this.i++;
    }

    public int h() {
        if (this.f) {
            c();
        }
        return this.i;
    }

    public E i(int i2) {
        if (this.f) {
            c();
        }
        return (E) this.h[i2];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            E i3 = i(i2);
            if (i3 != this) {
                sb.append((Object) i3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
