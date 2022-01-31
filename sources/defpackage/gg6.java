package defpackage;

import defpackage.cc6;
import defpackage.hg6;
import java.lang.Comparable;
import java.util.Arrays;

/* renamed from: gg6  reason: default package */
/* compiled from: ThreadSafeHeap.kt */
public class gg6<T extends hg6 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    public T[] f1258a;

    public final void a(T t) {
        cc6.b bVar = (cc6.b) t;
        bVar.a(this);
        T[] tArr = this.f1258a;
        if (tArr == null) {
            tArr = (T[]) new hg6[4];
            this.f1258a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, this._size * 2);
            n86.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((hg6[]) copyOf);
            this.f1258a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        bVar.h = i;
        f(i);
    }

    public final T b() {
        T[] tArr = this.f1258a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final boolean c() {
        return this._size == 0;
    }

    public final T d(int i) {
        T[] tArr = this.f1258a;
        n86.c(tArr);
        this._size--;
        if (i < this._size) {
            g(i, this._size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                n86.c(t);
                T t2 = tArr[i2];
                n86.c(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    g(i, i2);
                    f(i2);
                }
            }
            while (true) {
                int i3 = (i * 2) + 1;
                if (i3 >= this._size) {
                    break;
                }
                T[] tArr2 = this.f1258a;
                n86.c(tArr2);
                int i4 = i3 + 1;
                if (i4 < this._size) {
                    T t3 = tArr2[i4];
                    n86.c(t3);
                    T t4 = tArr2[i3];
                    n86.c(t4);
                    if (((Comparable) t3).compareTo(t4) < 0) {
                        i3 = i4;
                    }
                }
                T t5 = tArr2[i];
                n86.c(t5);
                T t6 = tArr2[i3];
                n86.c(t6);
                if (((Comparable) t5).compareTo(t6) <= 0) {
                    break;
                }
                g(i, i3);
                i = i3;
            }
        }
        T t7 = tArr[this._size];
        n86.c(t7);
        t7.a(null);
        t7.g(-1);
        tArr[this._size] = null;
        return t7;
    }

    public final T e() {
        T d;
        synchronized (this) {
            d = this._size > 0 ? d(0) : null;
        }
        return d;
    }

    public final void f(int i) {
        while (i > 0) {
            T[] tArr = this.f1258a;
            n86.c(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            n86.c(t);
            T t2 = tArr[i];
            n86.c(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                g(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void g(int i, int i2) {
        T[] tArr = this.f1258a;
        n86.c(tArr);
        T t = tArr[i2];
        n86.c(t);
        T t2 = tArr[i];
        n86.c(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.g(i);
        t2.g(i2);
    }
}
