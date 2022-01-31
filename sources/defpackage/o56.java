package defpackage;

import java.io.Serializable;

/* renamed from: o56  reason: default package */
/* compiled from: LazyJVM.kt */
public final class o56<T> implements j56<T>, Serializable {
    public h76<? extends T> f;
    public volatile Object g = q56.f2901a;
    public final Object h = this;

    public o56(h76 h76, Object obj, int i) {
        int i2 = i & 2;
        n86.e(h76, "initializer");
        this.f = h76;
    }

    @Override // defpackage.j56
    public T getValue() {
        T t;
        T t2 = (T) this.g;
        q56 q56 = q56.f2901a;
        if (t2 != q56) {
            return t2;
        }
        synchronized (this.h) {
            t = (T) this.g;
            if (t == q56) {
                h76<? extends T> h76 = this.f;
                n86.c(h76);
                t = (T) h76.invoke();
                this.g = t;
                this.f = null;
            }
        }
        return t;
    }

    public String toString() {
        return this.g != q56.f2901a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
