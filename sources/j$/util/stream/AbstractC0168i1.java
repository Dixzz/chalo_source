package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0168i1;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.i1  reason: case insensitive filesystem */
abstract class AbstractC0168i1<P_IN, P_OUT, R, K extends AbstractC0168i1<P_IN, P_OUT, R, K>> extends AbstractC0176k1<P_IN, P_OUT, R, K> {
    protected final AtomicReference h;
    protected volatile boolean i;

    protected AbstractC0168i1(T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.h = new AtomicReference(null);
    }

    protected AbstractC0168i1(AbstractC0168i1 i1Var, Spliterator spliterator) {
        super(i1Var, spliterator);
        this.h = i1Var.h;
    }

    @Override // j$.util.stream.AbstractC0176k1
    public Object b() {
        if (!e()) {
            return super.b();
        }
        Object obj = this.h.get();
        return obj == null ? k() : obj;
    }

    @Override // j$.util.stream.AbstractC0176k1
    public void compute() {
        Object obj;
        Spliterator trySplit;
        Spliterator spliterator = this.b;
        long estimateSize = spliterator.estimateSize();
        long j = this.c;
        if (j == 0) {
            j = AbstractC0176k1.h(estimateSize);
            this.c = j;
        }
        boolean z = false;
        AtomicReference atomicReference = this.h;
        AbstractC0168i1<P_IN, P_OUT, R, K> i1Var = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z2 = i1Var.i;
            if (!z2) {
                AbstractC0176k1 c = i1Var.c();
                while (true) {
                    AbstractC0168i1 i1Var2 = (AbstractC0168i1) c;
                    if (z2 || i1Var2 == null) {
                        break;
                    }
                    z2 = i1Var2.i;
                    c = i1Var2.c();
                }
            }
            if (z2) {
                obj = i1Var.k();
                break;
            } else if (estimateSize <= j || (trySplit = spliterator.trySplit()) == null) {
                obj = i1Var.a();
            } else {
                AbstractC0168i1<P_IN, P_OUT, R, K> i1Var3 = (AbstractC0168i1) i1Var.f(trySplit);
                i1Var.d = i1Var3;
                AbstractC0168i1<P_IN, P_OUT, R, K> i1Var4 = (AbstractC0168i1) i1Var.f(spliterator);
                i1Var.e = i1Var4;
                i1Var.setPendingCount(1);
                if (z) {
                    spliterator = trySplit;
                    i1Var = i1Var3;
                    i1Var3 = i1Var4;
                } else {
                    i1Var = i1Var4;
                }
                z = !z;
                i1Var3.fork();
                estimateSize = spliterator.estimateSize();
            }
        }
        i1Var.g(obj);
        i1Var.tryComplete();
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176k1
    public void g(Object obj) {
        if (!e()) {
            super.g(obj);
        } else if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }

    @Override // j$.util.stream.AbstractC0176k1, java.util.concurrent.ForkJoinTask, java.util.concurrent.CountedCompleter
    public Object getRawResult() {
        return b();
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.i = true;
    }

    /* access modifiers changed from: protected */
    public void j() {
        AbstractC0168i1<P_IN, P_OUT, R, K> i1Var = this;
        for (AbstractC0168i1<P_IN, P_OUT, R, K> i1Var2 = (AbstractC0168i1) c(); i1Var2 != null; i1Var2 = (AbstractC0168i1) i1Var2.c()) {
            if (i1Var2.d == i1Var) {
                AbstractC0168i1 i1Var3 = (AbstractC0168i1) i1Var2.e;
                if (!i1Var3.i) {
                    i1Var3.i();
                }
            }
            i1Var = i1Var2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object k();

    /* access modifiers changed from: protected */
    public void l(Object obj) {
        if (obj != null) {
            this.h.compareAndSet(null, obj);
        }
    }
}
