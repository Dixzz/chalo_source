package defpackage;

import java.io.Serializable;

/* renamed from: t56  reason: default package */
/* compiled from: Lazy.kt */
public final class t56<T> implements j56<T>, Serializable {
    public h76<? extends T> f;
    public Object g = q56.f2901a;

    public t56(h76<? extends T> h76) {
        n86.e(h76, "initializer");
        this.f = h76;
    }

    @Override // defpackage.j56
    public T getValue() {
        if (this.g == q56.f2901a) {
            h76<? extends T> h76 = this.f;
            n86.c(h76);
            this.g = h76.invoke();
            this.f = null;
        }
        return (T) this.g;
    }

    public String toString() {
        return this.g != q56.f2901a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
