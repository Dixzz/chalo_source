package a;

import j$.time.chrono.b;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.J;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.n;
import j$.util.function.x;
import j$.util.stream.AbstractC0180l1;
import j$.util.stream.AbstractC0184m1;
import j$.util.stream.AbstractC0207s1;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;

public final /* synthetic */ class Y0 implements Stream {

    /* renamed from: a */
    final /* synthetic */ java.util.stream.Stream f51a;

    private /* synthetic */ Y0(java.util.stream.Stream stream) {
        this.f51a = stream;
    }

    public static /* synthetic */ Stream m0(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Z0 ? ((Z0) stream).f53a : new Y0(stream);
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ AbstractC0207s1 B(Function function) {
        return S0.m0(this.f51a.flatMapToDouble(V.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream P(Predicate predicate) {
        return m0(this.f51a.filter(F0.a(predicate)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream S(Consumer consumer) {
        return m0(this.f51a.peek(E.a(consumer)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object T(AbstractC0184m1 m1Var) {
        return this.f51a.collect(R0.a(m1Var));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean U(Predicate predicate) {
        return this.f51a.allMatch(F0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ H1 V(Function function) {
        return W0.m0(this.f51a.flatMapToLong(V.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean a(Predicate predicate) {
        return this.f51a.anyMatch(F0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean c0(Predicate predicate) {
        return this.f51a.noneMatch(F0.a(predicate));
    }

    @Override // j$.util.stream.AbstractC0180l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f51a.close();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ long count() {
        return this.f51a.count();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream distinct() {
        return m0(this.f51a.distinct());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ C1 e(Function function) {
        return U0.m0(this.f51a.flatMapToInt(V.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ H1 e0(ToLongFunction toLongFunction) {
        return W0.m0(this.f51a.mapToLong(N0.a(toLongFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional findAny() {
        return b.p(this.f51a.findAny());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional findFirst() {
        return b.p(this.f51a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void forEach(Consumer consumer) {
        this.f51a.forEach(E.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void g(Consumer consumer) {
        this.f51a.forEachOrdered(E.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ AbstractC0207s1 h0(ToDoubleFunction toDoubleFunction) {
        return S0.m0(this.f51a.mapToDouble(J0.a(toDoubleFunction)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ boolean isParallel() {
        return this.f51a.isParallel();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ Iterator iterator() {
        return this.f51a.iterator();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object k(J j, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f51a.collect(H0.a(j), C0120y.a(biConsumer), C0120y.a(biConsumer2));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object l0(Object obj, n nVar) {
        return this.f51a.reduce(obj, C.a(nVar));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream limit(long j) {
        return m0(this.f51a.limit(j));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ C1 m(ToIntFunction toIntFunction) {
        return U0.m0(this.f51a.mapToInt(L0.a(toIntFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional max(Comparator comparator) {
        return b.p(this.f51a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional min(Comparator comparator) {
        return b.p(this.f51a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream n(Function function) {
        return m0(this.f51a.map(V.a(function)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 onClose(Runnable runnable) {
        return O0.m0(this.f51a.onClose(runnable));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream p(Function function) {
        return m0(this.f51a.flatMap(V.a(function)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 parallel() {
        return O0.m0(this.f51a.parallel());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional s(n nVar) {
        return b.p(this.f51a.reduce(C.a(nVar)));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 sequential() {
        return O0.m0(this.f51a.sequential());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream skip(long j) {
        return m0(this.f51a.skip(j));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted() {
        return m0(this.f51a.sorted());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted(Comparator comparator) {
        return m0(this.f51a.sorted(comparator));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ Spliterator spliterator() {
        return C0099n.a(this.f51a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray() {
        return this.f51a.toArray();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray(x xVar) {
        return this.f51a.toArray(C0076b0.a(xVar));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 unordered() {
        return O0.m0(this.f51a.unordered());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object z(Object obj, BiFunction biFunction, n nVar) {
        return this.f51a.reduce(obj, A.a(biFunction), C.a(nVar));
    }
}
