package a;

import j$.time.chrono.b;
import j$.util.function.B;
import j$.util.function.BiConsumer;
import j$.util.function.C;
import j$.util.function.D;
import j$.util.function.E;
import j$.util.function.F;
import j$.util.function.I;
import j$.util.function.J;
import j$.util.n;
import j$.util.o;
import j$.util.q;
import j$.util.stream.AbstractC0180l1;
import j$.util.stream.AbstractC0207s1;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.Stream;
import java.util.stream.LongStream;

public final /* synthetic */ class W0 implements H1 {

    /* renamed from: a */
    final /* synthetic */ LongStream f47a;

    private /* synthetic */ W0(LongStream longStream) {
        this.f47a = longStream;
    }

    public static /* synthetic */ H1 m0(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof X0 ? ((X0) longStream).f49a : new W0(longStream);
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long A(long j, B b) {
        return this.f47a.reduce(j, C0096l0.a(b));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Stream N(D d) {
        return Y0.m0(this.f47a.mapToObj(C0104p0.a(d)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ void Y(C c) {
        this.f47a.forEachOrdered(C0100n0.a(c));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ AbstractC0207s1 asDoubleStream() {
        return S0.m0(this.f47a.asDoubleStream());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ o average() {
        return b.q(this.f47a.average());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean b0(E e) {
        return this.f47a.anyMatch(C0107r0.a(e));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Stream boxed() {
        return Y0.m0(this.f47a.boxed());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean c(E e) {
        return this.f47a.noneMatch(C0107r0.a(e));
    }

    @Override // j$.util.stream.AbstractC0180l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f47a.close();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long count() {
        return this.f47a.count();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Object d0(J j, I i, BiConsumer biConsumer) {
        return this.f47a.collect(H0.a(j), D0.a(i), C0120y.a(biConsumer));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 distinct() {
        return m0(this.f47a.distinct());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ void f(C c) {
        this.f47a.forEach(C0100n0.a(c));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean f0(E e) {
        return this.f47a.allMatch(C0107r0.a(e));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ q findAny() {
        return b.s(this.f47a.findAny());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ q findFirst() {
        return b.s(this.f47a.findFirst());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 g0(E e) {
        return m0(this.f47a.filter(C0107r0.a(e)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ q i(B b) {
        return b.s(this.f47a.reduce(C0096l0.a(b)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ boolean isParallel() {
        return this.f47a.isParallel();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ AbstractC0207s1 j(C0109s0 s0Var) {
        return S0.m0(this.f47a.mapToDouble(s0Var == null ? null : s0Var.f84a));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 limit(long j) {
        return m0(this.f47a.limit(j));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ q max() {
        return b.s(this.f47a.max());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ q min() {
        return b.s(this.f47a.min());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 onClose(Runnable runnable) {
        return O0.m0(this.f47a.onClose(runnable));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 q(C c) {
        return m0(this.f47a.peek(C0100n0.a(c)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 r(D d) {
        return m0(this.f47a.flatMap(C0104p0.a(d)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 skip(long j) {
        return m0(this.f47a.skip(j));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 sorted() {
        return m0(this.f47a.sorted());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long sum() {
        return this.f47a.sum();
    }

    @Override // j$.util.stream.H1
    public n summaryStatistics() {
        this.f47a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long[] toArray() {
        return this.f47a.toArray();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 unordered() {
        return O0.m0(this.f47a.unordered());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ C1 w(C0113u0 u0Var) {
        return U0.m0(this.f47a.mapToInt(u0Var == null ? null : u0Var.f88a));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 x(F f) {
        return m0(this.f47a.map(C0119x0.a(f)));
    }
}
