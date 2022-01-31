package a;

import j$.time.chrono.b;
import j$.util.stream.C1;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class V0 implements IntStream {

    /* renamed from: a */
    final /* synthetic */ C1 f45a;

    private /* synthetic */ V0(C1 c1) {
        this.f45a = c1;
    }

    public static /* synthetic */ IntStream m0(C1 c1) {
        if (c1 == null) {
            return null;
        }
        return c1 instanceof U0 ? ((U0) c1).f43a : new V0(c1);
    }

    public /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
        return this.f45a.L(C0078c0.a(intPredicate));
    }

    public /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
        return this.f45a.b(C0078c0.a(intPredicate));
    }

    public /* synthetic */ DoubleStream asDoubleStream() {
        return T0.m0(this.f45a.asDoubleStream());
    }

    public /* synthetic */ LongStream asLongStream() {
        return X0.m0(this.f45a.asLongStream());
    }

    public /* synthetic */ OptionalDouble average() {
        return b.u(this.f45a.average());
    }

    @Override // java.util.stream.IntStream
    public /* synthetic */ Stream boxed() {
        return Z0.m0(this.f45a.boxed());
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f45a.close();
    }

    @Override // java.util.stream.IntStream
    public /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return this.f45a.j0(G0.a(supplier), A0.a(objIntConsumer), C0118x.b(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.f45a.count();
    }

    public /* synthetic */ IntStream distinct() {
        return m0(this.f45a.distinct());
    }

    public /* synthetic */ IntStream filter(IntPredicate intPredicate) {
        return m0(this.f45a.X(C0078c0.a(intPredicate)));
    }

    public /* synthetic */ OptionalInt findAny() {
        return b.v(this.f45a.findAny());
    }

    public /* synthetic */ OptionalInt findFirst() {
        return b.v(this.f45a.findFirst());
    }

    @Override // java.util.stream.IntStream
    public /* synthetic */ IntStream flatMap(IntFunction intFunction) {
        return m0(this.f45a.M(C0074a0.a(intFunction)));
    }

    public /* synthetic */ void forEach(IntConsumer intConsumer) {
        this.f45a.Q(Y.b(intConsumer));
    }

    public /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
        this.f45a.E(Y.b(intConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.f45a.isParallel();
    }

    public /* synthetic */ IntStream limit(long j) {
        return m0(this.f45a.limit(j));
    }

    public /* synthetic */ IntStream map(IntUnaryOperator intUnaryOperator) {
        return m0(this.f45a.y(C0090i0.b(intUnaryOperator)));
    }

    public /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
        return T0.m0(this.f45a.i0(C0082e0.b(intToDoubleFunction)));
    }

    public /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
        return X0.m0(this.f45a.h(C0086g0.a(intToLongFunction)));
    }

    @Override // java.util.stream.IntStream
    public /* synthetic */ Stream mapToObj(IntFunction intFunction) {
        return Z0.m0(this.f45a.F(C0074a0.a(intFunction)));
    }

    public /* synthetic */ OptionalInt max() {
        return b.v(this.f45a.max());
    }

    public /* synthetic */ OptionalInt min() {
        return b.v(this.f45a.min());
    }

    public /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
        return this.f45a.R(C0078c0.a(intPredicate));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return P0.m0(this.f45a.onClose(runnable));
    }

    public /* synthetic */ IntStream peek(IntConsumer intConsumer) {
        return m0(this.f45a.a0(Y.b(intConsumer)));
    }

    public /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
        return this.f45a.K(i, W.a(intBinaryOperator));
    }

    public /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        return b.v(this.f45a.Z(W.a(intBinaryOperator)));
    }

    public /* synthetic */ IntStream skip(long j) {
        return m0(this.f45a.skip(j));
    }

    public /* synthetic */ IntStream sorted() {
        return m0(this.f45a.sorted());
    }

    public /* synthetic */ int sum() {
        return this.f45a.sum();
    }

    public IntSummaryStatistics summaryStatistics() {
        this.f45a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
    }

    public /* synthetic */ int[] toArray() {
        return this.f45a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return P0.m0(this.f45a.unordered());
    }
}
