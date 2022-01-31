package a;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.function.J;
import j$.util.function.n;
import j$.util.stream.AbstractC0184m1;
import java.util.Set;
import java.util.stream.Collector;

public final /* synthetic */ class Q0 implements AbstractC0184m1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collector f36a;

    private /* synthetic */ Q0(Collector collector) {
        this.f36a = collector;
    }

    public static /* synthetic */ AbstractC0184m1 a(Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof R0 ? ((R0) collector).f37a : new Q0(collector);
    }

    @Override // j$.util.stream.AbstractC0184m1
    public /* synthetic */ BiConsumer accumulator() {
        return C0118x.b(this.f36a.accumulator());
    }

    @Override // j$.util.stream.AbstractC0184m1
    public /* synthetic */ Set characteristics() {
        return this.f36a.characteristics();
    }

    @Override // j$.util.stream.AbstractC0184m1
    public /* synthetic */ n combiner() {
        return B.b(this.f36a.combiner());
    }

    @Override // j$.util.stream.AbstractC0184m1
    public /* synthetic */ Function finisher() {
        return U.c(this.f36a.finisher());
    }

    @Override // j$.util.stream.AbstractC0184m1
    public /* synthetic */ J supplier() {
        return G0.a(this.f36a.supplier());
    }
}
