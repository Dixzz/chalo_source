package a;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: a.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0099n implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.Spliterator f73a;

    private /* synthetic */ C0099n(java.util.Spliterator spliterator) {
        this.f73a = spliterator;
    }

    public static /* synthetic */ Spliterator a(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof C0101o ? ((C0101o) spliterator).f75a : new C0099n(spliterator);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.f73a.tryAdvance(E.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.f73a.characteristics();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.f73a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f73a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f73a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f73a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f73a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Spliterator trySplit() {
        return a(this.f73a.trySplit());
    }
}
