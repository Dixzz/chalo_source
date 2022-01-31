package defpackage;

/* renamed from: r2  reason: default package */
/* compiled from: LongSparseArray */
public class r2<E> implements Cloneable {
    public static final Object j = new Object();
    public boolean f = false;
    public long[] g;
    public Object[] h;
    public int i;

    public r2() {
        int f2 = q2.f(10);
        this.g = new long[f2];
        this.h = new Object[f2];
    }

    public void a(long j2, E e) {
        int i2 = this.i;
        if (i2 == 0 || j2 > this.g[i2 - 1]) {
            if (this.f && i2 >= this.g.length) {
                e();
            }
            int i3 = this.i;
            if (i3 >= this.g.length) {
                int f2 = q2.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.g;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.h;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.g = jArr;
                this.h = objArr;
            }
            this.g[i3] = j2;
            this.h[i3] = e;
            this.i = i3 + 1;
            return;
        }
        j(j2, e);
    }

    public void b() {
        int i2 = this.i;
        Object[] objArr = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.i = 0;
        this.f = false;
    }

    /* renamed from: c */
    public r2<E> clone() {
        try {
            r2<E> r2Var = (r2) super.clone();
            r2Var.g = (long[]) this.g.clone();
            r2Var.h = (Object[]) this.h.clone();
            return r2Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean d(long j2) {
        if (this.f) {
            e();
        }
        return q2.b(this.g, this.i, j2) >= 0;
    }

    public final void e() {
        int i2 = this.i;
        long[] jArr = this.g;
        Object[] objArr = this.h;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != j) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f = false;
        this.i = i3;
    }

    public E f(long j2) {
        return g(j2, null);
    }

    public E g(long j2, E e) {
        int b = q2.b(this.g, this.i, j2);
        if (b >= 0) {
            Object[] objArr = this.h;
            if (objArr[b] != j) {
                return (E) objArr[b];
            }
        }
        return e;
    }

    public boolean h() {
        return l() == 0;
    }

    public long i(int i2) {
        if (this.f) {
            e();
        }
        return this.g[i2];
    }

    public void j(long j2, E e) {
        int b = q2.b(this.g, this.i, j2);
        if (b >= 0) {
            this.h[b] = e;
            return;
        }
        int i2 = ~b;
        int i3 = this.i;
        if (i2 < i3) {
            Object[] objArr = this.h;
            if (objArr[i2] == j) {
                this.g[i2] = j2;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f && i3 >= this.g.length) {
            e();
            i2 = ~q2.b(this.g, this.i, j2);
        }
        int i4 = this.i;
        if (i4 >= this.g.length) {
            int f2 = q2.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.g = jArr;
            this.h = objArr2;
        }
        int i5 = this.i;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.g;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.h;
            System.arraycopy(objArr4, i2, objArr4, i6, this.i - i2);
        }
        this.g[i2] = j2;
        this.h[i2] = e;
        this.i++;
    }

    public void k(long j2) {
        Object[] objArr;
        Object obj;
        int b = q2.b(this.g, this.i, j2);
        if (b >= 0 && (objArr = this.h)[b] != (obj = j)) {
            objArr[b] = obj;
            this.f = true;
        }
    }

    public int l() {
        if (this.f) {
            e();
        }
        return this.i;
    }

    public E m(int i2) {
        if (this.f) {
            e();
        }
        return (E) this.h[i2];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(i(i2));
            sb.append('=');
            E m = m(i2);
            if (m != this) {
                sb.append((Object) m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
