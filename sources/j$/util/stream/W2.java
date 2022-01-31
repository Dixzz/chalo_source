package j$.util.stream;

import j$.time.chrono.b;
import j$.util.Spliterator;
import j$.util.function.J;
import j$.util.function.o;
import j$.util.stream.AbstractC0172j1;
import java.util.Comparator;

abstract class W2<P_IN, P_OUT, T_BUFFER extends AbstractC0172j1> implements Spliterator<P_OUT> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f1755a;
    final T1 b;
    private J c;
    Spliterator d;
    A2 e;
    o f;
    long g;
    AbstractC0172j1 h;
    boolean i;

    W2(T1 t1, Spliterator spliterator, boolean z) {
        this.b = t1;
        this.c = null;
        this.d = spliterator;
        this.f1755a = z;
    }

    W2(T1 t1, J j, boolean z) {
        this.b = t1;
        this.c = j;
        this.d = null;
        this.f1755a = z;
    }

    private boolean f() {
        while (this.h.count() == 0) {
            if (this.e.p() || !this.f.a()) {
                if (this.i) {
                    return false;
                }
                this.e.m();
                this.i = true;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        AbstractC0172j1 j1Var = this.h;
        boolean z = false;
        if (j1Var != null) {
            long j = this.g + 1;
            this.g = j;
            if (j < j1Var.count()) {
                z = true;
            }
            if (z) {
                return z;
            }
            this.g = 0;
            this.h.clear();
            return f();
        } else if (this.i) {
            return false;
        } else {
            g();
            i();
            this.g = 0;
            this.e.n(this.d.getExactSizeIfKnown());
            return f();
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        g();
        int w = T2.w(this.b.r0()) & T2.f;
        return (w & 64) != 0 ? (w & -16449) | (this.d.characteristics() & 16448) : w;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        g();
        return this.d.estimateSize();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (this.d == null) {
            this.d = (Spliterator) this.c.get();
            this.c = null;
        }
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        if (b.h(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        g();
        if (T2.SIZED.n(this.b.r0())) {
            return this.d.getExactSizeIfKnown();
        }
        return -1;
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i2) {
        return b.h(this, i2);
    }

    /* access modifiers changed from: package-private */
    public abstract void i();

    /* access modifiers changed from: package-private */
    public abstract W2 k(Spliterator spliterator);

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.d);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.f1755a || this.i) {
            return null;
        }
        g();
        Spliterator trySplit = this.d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return k(trySplit);
    }
}
