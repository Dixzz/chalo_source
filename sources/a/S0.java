package a;

import j$.time.chrono.b;
import j$.util.function.BiConsumer;
import j$.util.function.G;
import j$.util.function.J;
import j$.util.function.p;
import j$.util.function.q;
import j$.util.function.r;
import j$.util.function.s;
import j$.util.function.t;
import j$.util.function.u;
import j$.util.l;
import j$.util.o;
import j$.util.stream.AbstractC0180l1;
import j$.util.stream.AbstractC0207s1;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.Stream;
import java.util.stream.DoubleStream;

public final /* synthetic */ class S0 implements AbstractC0207s1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleStream f39a;

    private /* synthetic */ S0(DoubleStream doubleStream) {
        this.f39a = doubleStream;
    }

    public static /* synthetic */ AbstractC0207s1 m0(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof T0 ? ((T0) doubleStream).f41a : new S0(doubleStream);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o C(p pVar) {
        return b.q(this.f39a.reduce(G.a(pVar)));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ Object D(J j, G g, BiConsumer biConsumer) {
        return this.f39a.collect(H0.a(j), C0123z0.a(g), C0120y.a(biConsumer));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ double G(double d, p pVar) {
        return this.f39a.reduce(d, G.a(pVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 H(u uVar) {
        return m0(this.f39a.map(T.a(uVar)));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ Stream I(r rVar) {
        return Y0.m0(this.f39a.mapToObj(K.a(rVar)));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ boolean J(s sVar) {
        return this.f39a.noneMatch(M.a(sVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ boolean O(s sVar) {
        return this.f39a.allMatch(M.a(sVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ boolean W(s sVar) {
        return this.f39a.anyMatch(M.a(sVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o average() {
        return b.q(this.f39a.average());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ Stream boxed() {
        return Y0.m0(this.f39a.boxed());
    }

    @Override // j$.util.stream.AbstractC0180l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f39a.close();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ long count() {
        return this.f39a.count();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 d(q qVar) {
        return m0(this.f39a.peek(I.a(qVar)));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 distinct() {
        return m0(this.f39a.distinct());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o findAny() {
        return b.q(this.f39a.findAny());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o findFirst() {
        return b.q(this.f39a.findFirst());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ boolean isParallel() {
        return this.f39a.isParallel();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ void k0(q qVar) {
        this.f39a.forEachOrdered(I.a(qVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ void l(q qVar) {
        this.f39a.forEach(I.a(qVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 limit(long j) {
        return m0(this.f39a.limit(j));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o max() {
        return b.q(this.f39a.max());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ o min() {
        return b.q(this.f39a.min());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ C1 o(N n) {
        return U0.m0(this.f39a.mapToInt(n == null ? null : n.f29a));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 onClose(Runnable runnable) {
        return O0.m0(this.f39a.onClose(runnable));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 skip(long j) {
        return m0(this.f39a.skip(j));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 sorted() {
        return m0(this.f39a.sorted());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ double sum() {
        return this.f39a.sum();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public l summaryStatistics() {
        this.f39a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 t(s sVar) {
        return m0(this.f39a.filter(M.a(sVar)));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ double[] toArray() {
        return this.f39a.toArray();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ AbstractC0207s1 u(r rVar) {
        return m0(this.f39a.flatMap(K.a(rVar)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 unordered() {
        return O0.m0(this.f39a.unordered());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public /* synthetic */ H1 v(t tVar) {
        return W0.m0(this.f39a.mapToLong(Q.a(tVar)));
    }
}
