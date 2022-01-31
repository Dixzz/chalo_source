package a;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: a.v */
public final /* synthetic */ class C0114v implements Spliterator.d {

    /* renamed from: a */
    final /* synthetic */ Spliterator.OfPrimitive f89a;

    private /* synthetic */ C0114v(Spliterator.OfPrimitive ofPrimitive) {
        this.f89a = ofPrimitive;
    }

    public static /* synthetic */ Spliterator.d a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof C0116w ? ((C0116w) ofPrimitive).f91a : new C0114v(ofPrimitive);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.f89a.tryAdvance(E.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.f89a.characteristics();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.f89a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f89a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f89a.forEachRemaining(obj);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f89a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f89a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f89a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f89a.tryAdvance(obj);
    }
}
