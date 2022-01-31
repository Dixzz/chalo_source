package a;

import j$.util.stream.AbstractC0184m1;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public final /* synthetic */ class R0 implements Collector {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractC0184m1 f37a;

    private /* synthetic */ R0(AbstractC0184m1 m1Var) {
        this.f37a = m1Var;
    }

    public static /* synthetic */ Collector a(AbstractC0184m1 m1Var) {
        if (m1Var == null) {
            return null;
        }
        return m1Var instanceof Q0 ? ((Q0) m1Var).f36a : new R0(m1Var);
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BiConsumer accumulator() {
        return C0120y.a(this.f37a.accumulator());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Set characteristics() {
        return this.f37a.characteristics();
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BinaryOperator combiner() {
        return C.a(this.f37a.combiner());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Function finisher() {
        return V.a(this.f37a.finisher());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Supplier supplier() {
        return H0.a(this.f37a.supplier());
    }
}
