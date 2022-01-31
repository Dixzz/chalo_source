package a;

import j$.time.chrono.b;
import j$.util.function.A;
import j$.util.function.BiConsumer;
import j$.util.function.H;
import j$.util.function.J;
import j$.util.function.v;
import j$.util.function.w;
import j$.util.function.x;
import j$.util.function.y;
import j$.util.function.z;
import j$.util.m;
import j$.util.o;
import j$.util.p;
import j$.util.stream.AbstractC0180l1;
import j$.util.stream.AbstractC0207s1;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.Stream;
import java.util.stream.IntStream;

public final /* synthetic */ class U0 implements C1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntStream f43a;

    private /* synthetic */ U0(IntStream intStream) {
        this.f43a = intStream;
    }

    public static /* synthetic */ C1 m0(IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof V0 ? ((V0) intStream).f45a : new U0(intStream);
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ void E(w wVar) {
        this.f43a.forEachOrdered(Z.a(wVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Stream F(x xVar) {
        return Y0.m0(this.f43a.mapToObj(C0076b0.a(xVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int K(int i, v vVar) {
        return this.f43a.reduce(i, X.a(vVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean L(y yVar) {
        return this.f43a.allMatch(C0080d0.a(yVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 M(x xVar) {
        return m0(this.f43a.flatMap(C0076b0.a(xVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ void Q(w wVar) {
        this.f43a.forEach(Z.a(wVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean R(y yVar) {
        return this.f43a.noneMatch(C0080d0.a(yVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 X(y yVar) {
        return m0(this.f43a.filter(C0080d0.a(yVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ p Z(v vVar) {
        return b.r(this.f43a.reduce(X.a(vVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 a0(w wVar) {
        return m0(this.f43a.peek(Z.a(wVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ AbstractC0207s1 asDoubleStream() {
        return S0.m0(this.f43a.asDoubleStream());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ H1 asLongStream() {
        return W0.m0(this.f43a.asLongStream());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ o average() {
        return b.q(this.f43a.average());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean b(y yVar) {
        return this.f43a.anyMatch(C0080d0.a(yVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Stream boxed() {
        return Y0.m0(this.f43a.boxed());
    }

    @Override // j$.util.stream.AbstractC0180l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f43a.close();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ long count() {
        return this.f43a.count();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 distinct() {
        return m0(this.f43a.distinct());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ p findAny() {
        return b.r(this.f43a.findAny());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ p findFirst() {
        return b.r(this.f43a.findFirst());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ H1 h(z zVar) {
        return W0.m0(this.f43a.mapToLong(C0088h0.a(zVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ AbstractC0207s1 i0(C0082e0 e0Var) {
        return S0.m0(this.f43a.mapToDouble(e0Var == null ? null : e0Var.f58a));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ boolean isParallel() {
        return this.f43a.isParallel();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Object j0(J j, H h, BiConsumer biConsumer) {
        return this.f43a.collect(H0.a(j), B0.a(h), C0120y.a(biConsumer));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 limit(long j) {
        return m0(this.f43a.limit(j));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ p max() {
        return b.r(this.f43a.max());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ p min() {
        return b.r(this.f43a.min());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 onClose(Runnable runnable) {
        return O0.m0(this.f43a.onClose(runnable));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 skip(long j) {
        return m0(this.f43a.skip(j));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 sorted() {
        return m0(this.f43a.sorted());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int sum() {
        return this.f43a.sum();
    }

    @Override // j$.util.stream.C1
    public m summaryStatistics() {
        this.f43a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int[] toArray() {
        return this.f43a.toArray();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 unordered() {
        return O0.m0(this.f43a.unordered());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 y(A a2) {
        return m0(this.f43a.map(C0092j0.a(a2)));
    }
}
