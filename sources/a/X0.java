package a;

import j$.time.chrono.b;
import j$.util.stream.H1;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class X0 implements LongStream {

    /* renamed from: a */
    final /* synthetic */ H1 f49a;

    private /* synthetic */ X0(H1 h1) {
        this.f49a = h1;
    }

    public static /* synthetic */ LongStream m0(H1 h1) {
        if (h1 == null) {
            return null;
        }
        return h1 instanceof W0 ? ((W0) h1).f47a : new X0(h1);
    }

    public /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.f49a.f0(C0106q0.a(longPredicate));
    }

    public /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.f49a.b0(C0106q0.a(longPredicate));
    }

    public /* synthetic */ DoubleStream asDoubleStream() {
        return T0.m0(this.f49a.asDoubleStream());
    }

    public /* synthetic */ OptionalDouble average() {
        return b.u(this.f49a.average());
    }

    @Override // java.util.stream.LongStream
    public /* synthetic */ Stream boxed() {
        return Z0.m0(this.f49a.boxed());
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f49a.close();
    }

    @Override // java.util.stream.LongStream
    public /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f49a.d0(G0.a(supplier), C0.a(objLongConsumer), C0118x.b(biConsumer));
    }

    public /* synthetic */ long count() {
        return this.f49a.count();
    }

    public /* synthetic */ LongStream distinct() {
        return m0(this.f49a.distinct());
    }

    public /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return m0(this.f49a.g0(C0106q0.a(longPredicate)));
    }

    public /* synthetic */ OptionalLong findAny() {
        return b.w(this.f49a.findAny());
    }

    public /* synthetic */ OptionalLong findFirst() {
        return b.w(this.f49a.findFirst());
    }

    @Override // java.util.stream.LongStream
    public /* synthetic */ LongStream flatMap(LongFunction longFunction) {
        return m0(this.f49a.r(C0102o0.a(longFunction)));
    }

    public /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f49a.f(C0098m0.b(longConsumer));
    }

    public /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f49a.Y(C0098m0.b(longConsumer));
    }

    public /* synthetic */ boolean isParallel() {
        return this.f49a.isParallel();
    }

    public /* synthetic */ LongStream limit(long j) {
        return m0(this.f49a.limit(j));
    }

    public /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return m0(this.f49a.x(C0117w0.c(longUnaryOperator)));
    }

    public /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return T0.m0(this.f49a.j(C0109s0.b(longToDoubleFunction)));
    }

    public /* synthetic */ IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return V0.m0(this.f49a.w(C0113u0.b(longToIntFunction)));
    }

    @Override // java.util.stream.LongStream
    public /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return Z0.m0(this.f49a.N(C0102o0.a(longFunction)));
    }

    public /* synthetic */ OptionalLong max() {
        return b.w(this.f49a.max());
    }

    public /* synthetic */ OptionalLong min() {
        return b.w(this.f49a.min());
    }

    public /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.f49a.c(C0106q0.a(longPredicate));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return P0.m0(this.f49a.onClose(runnable));
    }

    public /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return m0(this.f49a.q(C0098m0.b(longConsumer)));
    }

    public /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.f49a.A(j, C0094k0.a(longBinaryOperator));
    }

    public /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return b.w(this.f49a.i(C0094k0.a(longBinaryOperator)));
    }

    public /* synthetic */ LongStream skip(long j) {
        return m0(this.f49a.skip(j));
    }

    public /* synthetic */ LongStream sorted() {
        return m0(this.f49a.sorted());
    }

    public /* synthetic */ long sum() {
        return this.f49a.sum();
    }

    public LongSummaryStatistics summaryStatistics() {
        this.f49a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public /* synthetic */ long[] toArray() {
        return this.f49a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return P0.m0(this.f49a.unordered());
    }
}
