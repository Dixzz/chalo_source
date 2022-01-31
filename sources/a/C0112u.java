package a;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: a.u */
public final /* synthetic */ class C0112u implements Spliterator.OfLong {

    /* renamed from: a */
    final /* synthetic */ Spliterator.c f87a;

    private /* synthetic */ C0112u(Spliterator.c cVar) {
        this.f87a = cVar;
    }

    public static /* synthetic */ Spliterator.OfLong a(Spliterator.c cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar instanceof C0110t ? ((C0110t) cVar).f85a : new C0112u(cVar);
    }

    public /* synthetic */ int characteristics() {
        return this.f87a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.f87a.estimateSize();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f87a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f87a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfLong
    public /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f87a.d(C0098m0.b(longConsumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f87a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f87a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f87a.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f87a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f87a.b(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfLong
    public /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f87a.j(C0098m0.b(longConsumer));
    }
}
