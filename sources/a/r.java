package a;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.w;
import java.util.Comparator;
import java.util.Spliterator;

public final /* synthetic */ class r implements Spliterator.b {

    /* renamed from: a */
    final /* synthetic */ Spliterator.OfInt f81a;

    private /* synthetic */ r(Spliterator.OfInt ofInt) {
        this.f81a = ofInt;
    }

    public static /* synthetic */ Spliterator.b a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0108s ? ((C0108s) ofInt).f83a : new r(ofInt);
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.f81a.tryAdvance(E.a(consumer));
    }

    @Override // j$.util.Spliterator.b
    public /* synthetic */ void c(w wVar) {
        this.f81a.forEachRemaining(Z.a(wVar));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.f81a.characteristics();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.f81a.estimateSize();
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f81a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f81a.forEachRemaining(obj);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f81a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f81a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator.b
    public /* synthetic */ boolean h(w wVar) {
        return this.f81a.tryAdvance(Z.a(wVar));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f81a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f81a.tryAdvance(obj);
    }
}
