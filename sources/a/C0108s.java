package a;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: a.s */
public final /* synthetic */ class C0108s implements Spliterator.OfInt {

    /* renamed from: a */
    final /* synthetic */ Spliterator.b f83a;

    private /* synthetic */ C0108s(Spliterator.b bVar) {
        this.f83a = bVar;
    }

    public static /* synthetic */ Spliterator.OfInt a(Spliterator.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar instanceof r ? ((r) bVar).f81a : new C0108s(bVar);
    }

    public /* synthetic */ int characteristics() {
        return this.f83a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.f83a.estimateSize();
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f83a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f83a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfInt
    public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f83a.c(Y.b(intConsumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f83a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f83a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f83a.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f83a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f83a.b(D.b(consumer));
    }

    @Override // java.util.Spliterator.OfInt
    public /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f83a.h(Y.b(intConsumer));
    }
}
