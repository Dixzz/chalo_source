package a;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: a.q */
public final /* synthetic */ class C0105q implements Spliterator.OfDouble {

    /* renamed from: a */
    final /* synthetic */ Spliterator.a f79a;

    private /* synthetic */ C0105q(Spliterator.a aVar) {
        this.f79a = aVar;
    }

    public static /* synthetic */ Spliterator.OfDouble a(Spliterator.a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar instanceof C0103p ? ((C0103p) aVar).f77a : new C0105q(aVar);
    }

    public /* synthetic */ int characteristics() {
        return this.f79a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.f79a.estimateSize();
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f79a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f79a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfDouble
    public /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f79a.e(H.b(doubleConsumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f79a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f79a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f79a.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f79a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f79a.b(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfDouble
    public /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f79a.o(H.b(doubleConsumer));
    }
}
