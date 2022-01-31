package a;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.q;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: a.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0103p implements Spliterator.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Spliterator.OfDouble f77a;

    private /* synthetic */ C0103p(Spliterator.OfDouble ofDouble) {
        this.f77a = ofDouble;
    }

    public static /* synthetic */ Spliterator.a a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0105q ? ((C0105q) ofDouble).f79a : new C0103p(ofDouble);
    }

    @Override // j$.util.Spliterator.a, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.f77a.tryAdvance(E.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.f77a.characteristics();
    }

    @Override // j$.util.Spliterator.a
    public /* synthetic */ void e(q qVar) {
        this.f77a.forEachRemaining(I.a(qVar));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.f77a.estimateSize();
    }

    @Override // j$.util.Spliterator.a, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f77a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f77a.forEachRemaining(obj);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f77a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f77a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f77a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator.a
    public /* synthetic */ boolean o(q qVar) {
        return this.f77a.tryAdvance(I.a(qVar));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f77a.tryAdvance(obj);
    }
}
