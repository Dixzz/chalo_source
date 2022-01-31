package a;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: a.w */
public final /* synthetic */ class C0116w implements Spliterator.OfPrimitive {

    /* renamed from: a */
    final /* synthetic */ Spliterator.d f91a;

    private /* synthetic */ C0116w(Spliterator.d dVar) {
        this.f91a = dVar;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(Spliterator.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar instanceof C0114v ? ((C0114v) dVar).f89a : new C0116w(dVar);
    }

    public /* synthetic */ int characteristics() {
        return this.f91a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.f91a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f91a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f91a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f91a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f91a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f91a.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f91a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator
    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f91a.b(D.b(consumer));
    }
}
