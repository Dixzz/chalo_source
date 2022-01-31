package j$.util.stream;

import a.N;
import j$.util.Spliterator;
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
import j$.util.s;

/* renamed from: j$.util.stream.s1  reason: case insensitive filesystem */
public interface AbstractC0207s1 extends AbstractC0180l1<Double, AbstractC0207s1> {
    o C(p pVar);

    Object D(J j, G g, BiConsumer biConsumer);

    double G(double d, p pVar);

    AbstractC0207s1 H(u uVar);

    Stream I(r rVar);

    boolean J(s sVar);

    boolean O(s sVar);

    boolean W(s sVar);

    o average();

    Stream boxed();

    long count();

    AbstractC0207s1 d(q qVar);

    AbstractC0207s1 distinct();

    o findAny();

    o findFirst();

    @Override // j$.util.stream.AbstractC0180l1
    s.a iterator();

    void k0(q qVar);

    void l(q qVar);

    AbstractC0207s1 limit(long j);

    o max();

    o min();

    C1 o(N n);

    @Override // j$.util.stream.AbstractC0180l1
    AbstractC0207s1 parallel();

    @Override // j$.util.stream.AbstractC0180l1
    AbstractC0207s1 sequential();

    AbstractC0207s1 skip(long j);

    AbstractC0207s1 sorted();

    @Override // j$.util.stream.AbstractC0180l1
    Spliterator.a spliterator();

    double sum();

    l summaryStatistics();

    AbstractC0207s1 t(j$.util.function.s sVar);

    double[] toArray();

    AbstractC0207s1 u(r rVar);

    H1 v(t tVar);
}
