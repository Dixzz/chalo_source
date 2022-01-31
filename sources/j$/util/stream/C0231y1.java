package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.y1  reason: case insensitive filesystem */
public final class C0231y1<S, T> extends CountedCompleter<Void> {

    /* renamed from: a  reason: collision with root package name */
    private Spliterator f1843a;
    private final A2 b;
    private final T1 c;
    private long d;

    C0231y1(T1 t1, Spliterator spliterator, A2 a2) {
        super(null);
        this.b = a2;
        this.c = t1;
        this.f1843a = spliterator;
        this.d = 0;
    }

    C0231y1(C0231y1 y1Var, Spliterator spliterator) {
        super(y1Var);
        this.f1843a = spliterator;
        this.b = y1Var.b;
        this.d = y1Var.d;
        this.c = y1Var.c;
    }

    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f1843a;
        long estimateSize = spliterator.estimateSize();
        long j = this.d;
        if (j == 0) {
            j = AbstractC0176k1.h(estimateSize);
            this.d = j;
        }
        boolean n = T2.SHORT_CIRCUIT.n(this.c.r0());
        boolean z = false;
        A2 a2 = this.b;
        C0231y1<S, T> y1Var = this;
        while (true) {
            if (n && a2.p()) {
                break;
            } else if (estimateSize <= j || (trySplit = spliterator.trySplit()) == null) {
                y1Var.c.m0(a2, spliterator);
            } else {
                C0231y1<S, T> y1Var2 = new C0231y1<>(y1Var, trySplit);
                y1Var.addToPendingCount(1);
                if (z) {
                    spliterator = trySplit;
                } else {
                    y1Var = y1Var2;
                    y1Var2 = y1Var;
                }
                z = !z;
                y1Var.fork();
                y1Var = y1Var2;
                estimateSize = spliterator.estimateSize();
            }
        }
        y1Var.c.m0(a2, spliterator);
        y1Var.f1843a = null;
        y1Var.propagateCompletion();
    }
}
