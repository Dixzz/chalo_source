package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0176k1;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.k1  reason: case insensitive filesystem */
public abstract class AbstractC0176k1<P_IN, P_OUT, R, K extends AbstractC0176k1<P_IN, P_OUT, R, K>> extends CountedCompleter<R> {
    static final int g = (ForkJoinPool.getCommonPoolParallelism() << 2);

    /* renamed from: a  reason: collision with root package name */
    protected final T1 f1803a;
    protected Spliterator b;
    protected long c;
    protected AbstractC0176k1 d;
    protected AbstractC0176k1 e;
    private Object f;

    protected AbstractC0176k1(T1 t1, Spliterator spliterator) {
        super(null);
        this.f1803a = t1;
        this.b = spliterator;
        this.c = 0;
    }

    protected AbstractC0176k1(AbstractC0176k1 k1Var, Spliterator spliterator) {
        super(k1Var);
        this.b = spliterator;
        this.f1803a = k1Var.f1803a;
        this.c = k1Var.c;
    }

    public static long h(long j) {
        long j2 = j / ((long) g);
        if (j2 > 0) {
            return j2;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    /* access modifiers changed from: protected */
    public Object b() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public AbstractC0176k1 c() {
        return (AbstractC0176k1) getCompleter();
    }

    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.b;
        long estimateSize = spliterator.estimateSize();
        long j = this.c;
        if (j == 0) {
            j = h(estimateSize);
            this.c = j;
        }
        boolean z = false;
        AbstractC0176k1<P_IN, P_OUT, R, K> k1Var = this;
        while (estimateSize > j && (trySplit = spliterator.trySplit()) != null) {
            AbstractC0176k1<P_IN, P_OUT, R, K> f2 = k1Var.f(trySplit);
            k1Var.d = f2;
            AbstractC0176k1<P_IN, P_OUT, R, K> f3 = k1Var.f(spliterator);
            k1Var.e = f3;
            k1Var.setPendingCount(1);
            if (z) {
                spliterator = trySplit;
                k1Var = f2;
                f2 = f3;
            } else {
                k1Var = f3;
            }
            z = !z;
            f2.fork();
            estimateSize = spliterator.estimateSize();
        }
        k1Var.g(k1Var.a());
        k1Var.tryComplete();
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return this.d == null;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return c() == null;
    }

    /* access modifiers changed from: protected */
    public abstract AbstractC0176k1 f(Spliterator spliterator);

    /* access modifiers changed from: protected */
    public void g(Object obj) {
        this.f = obj;
    }

    @Override // java.util.concurrent.ForkJoinTask, java.util.concurrent.CountedCompleter
    public Object getRawResult() {
        return this.f;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.b = null;
        this.e = null;
        this.d = null;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.ForkJoinTask, java.util.concurrent.CountedCompleter
    public void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
