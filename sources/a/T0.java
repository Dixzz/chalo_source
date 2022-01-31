package a;

import j$.time.chrono.b;
import j$.util.stream.AbstractC0207s1;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class T0 implements DoubleStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractC0207s1 f41a;

    private /* synthetic */ T0(AbstractC0207s1 s1Var) {
        this.f41a = s1Var;
    }

    public static /* synthetic */ DoubleStream m0(AbstractC0207s1 s1Var) {
        if (s1Var == null) {
            return null;
        }
        return s1Var instanceof S0 ? ((S0) s1Var).f39a : new T0(s1Var);
    }

    public /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.f41a.O(L.a(doublePredicate));
    }

    public /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.f41a.W(L.a(doublePredicate));
    }

    public /* synthetic */ OptionalDouble average() {
        return b.u(this.f41a.average());
    }

    @Override // java.util.stream.DoubleStream
    public /* synthetic */ Stream boxed() {
        return Z0.m0(this.f41a.boxed());
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f41a.close();
    }

    @Override // java.util.stream.DoubleStream
    public /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f41a.D(G0.a(supplier), C0121y0.a(objDoubleConsumer), C0118x.b(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.f41a.count();
    }

    public /* synthetic */ DoubleStream distinct() {
        return m0(this.f41a.distinct());
    }

    public /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return m0(this.f41a.t(L.a(doublePredicate)));
    }

    public /* synthetic */ OptionalDouble findAny() {
        return b.u(this.f41a.findAny());
    }

    public /* synthetic */ OptionalDouble findFirst() {
        return b.u(this.f41a.findFirst());
    }

    @Override // java.util.stream.DoubleStream
    public /* synthetic */ DoubleStream flatMap(DoubleFunction doubleFunction) {
        return m0(this.f41a.u(J.a(doubleFunction)));
    }

    public /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f41a.l(H.b(doubleConsumer));
    }

    public /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f41a.k0(H.b(doubleConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.f41a.isParallel();
    }

    public /* synthetic */ DoubleStream limit(long j) {
        return m0(this.f41a.limit(j));
    }

    public /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return m0(this.f41a.H(S.b(doubleUnaryOperator)));
    }

    public /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return V0.m0(this.f41a.o(N.b(doubleToIntFunction)));
    }

    public /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return X0.m0(this.f41a.v(P.a(doubleToLongFunction)));
    }

    @Override // java.util.stream.DoubleStream
    public /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return Z0.m0(this.f41a.I(J.a(doubleFunction)));
    }

    public /* synthetic */ OptionalDouble max() {
        return b.u(this.f41a.max());
    }

    public /* synthetic */ OptionalDouble min() {
        return b.u(this.f41a.min());
    }

    public /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.f41a.J(L.a(doublePredicate));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return P0.m0(this.f41a.onClose(runnable));
    }

    public /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return m0(this.f41a.d(H.b(doubleConsumer)));
    }

    public /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f41a.G(d, F.a(doubleBinaryOperator));
    }

    public /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return b.u(this.f41a.C(F.a(doubleBinaryOperator)));
    }

    public /* synthetic */ DoubleStream skip(long j) {
        return m0(this.f41a.skip(j));
    }

    public /* synthetic */ DoubleStream sorted() {
        return m0(this.f41a.sorted());
    }

    public /* synthetic */ double sum() {
        return this.f41a.sum();
    }

    public DoubleSummaryStatistics summaryStatistics() {
        this.f41a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public /* synthetic */ double[] toArray() {
        return this.f41a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return P0.m0(this.f41a.unordered());
    }
}
