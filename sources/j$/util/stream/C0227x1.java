package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.R1;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.x1  reason: case insensitive filesystem */
public final class C0227x1<S, T> extends CountedCompleter<Void> {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final T1 f1840a;
    private Spliterator b;
    private final long c;
    private final ConcurrentHashMap d;
    private final A2 e;
    private final C0227x1 f;
    private R1 g;

    protected C0227x1(T1 t1, Spliterator spliterator, A2 a2) {
        super(null);
        this.f1840a = t1;
        this.b = spliterator;
        this.c = AbstractC0176k1.h(spliterator.estimateSize());
        this.d = new ConcurrentHashMap(Math.max(16, AbstractC0176k1.g << 1));
        this.e = a2;
        this.f = null;
    }

    C0227x1(C0227x1 x1Var, Spliterator spliterator, C0227x1 x1Var2) {
        super(x1Var);
        this.f1840a = x1Var.f1840a;
        this.b = spliterator;
        this.c = x1Var.c;
        this.d = x1Var.d;
        this.e = x1Var.e;
        this.f = x1Var2;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.b;
        long j = this.c;
        boolean z = false;
        C0227x1<S, T> x1Var = this;
        while (spliterator.estimateSize() > j && (trySplit = spliterator.trySplit()) != null) {
            C0227x1<S, T> x1Var2 = new C0227x1<>(x1Var, trySplit, x1Var.f);
            C0227x1<S, T> x1Var3 = new C0227x1<>(x1Var, spliterator, x1Var2);
            x1Var.addToPendingCount(1);
            x1Var3.addToPendingCount(1);
            x1Var.d.put(x1Var2, x1Var3);
            if (x1Var.f != null) {
                x1Var2.addToPendingCount(1);
                if (x1Var.d.replace(x1Var.f, x1Var, x1Var2)) {
                    x1Var.addToPendingCount(-1);
                } else {
                    x1Var2.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = trySplit;
                x1Var = x1Var2;
                x1Var2 = x1Var3;
            } else {
                x1Var = x1Var3;
            }
            z = !z;
            x1Var2.fork();
        }
        if (x1Var.getPendingCount() > 0) {
            C0233z zVar = C0233z.f1844a;
            T1 t1 = x1Var.f1840a;
            R1.a s0 = t1.s0(t1.p0(spliterator), zVar);
            AbstractC0164h1 h1Var = (AbstractC0164h1) x1Var.f1840a;
            Objects.requireNonNull(h1Var);
            Objects.requireNonNull(s0);
            h1Var.m0(h1Var.u0(s0), spliterator);
            x1Var.g = s0.a();
            x1Var.b = null;
        }
        x1Var.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        R1 r1 = this.g;
        if (r1 != null) {
            r1.forEach(this.e);
            this.g = null;
        } else {
            Spliterator spliterator = this.b;
            if (spliterator != null) {
                T1 t1 = this.f1840a;
                A2 a2 = this.e;
                AbstractC0164h1 h1Var = (AbstractC0164h1) t1;
                Objects.requireNonNull(h1Var);
                Objects.requireNonNull(a2);
                h1Var.m0(h1Var.u0(a2), spliterator);
                this.b = null;
            }
        }
        C0227x1 x1Var = (C0227x1) this.d.remove(this);
        if (x1Var != null) {
            x1Var.tryComplete();
        }
    }
}
