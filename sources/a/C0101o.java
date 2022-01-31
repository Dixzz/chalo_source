package a;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: a.o */
public final /* synthetic */ class C0101o implements Spliterator {

    /* renamed from: a */
    final /* synthetic */ j$.util.Spliterator f75a;

    private /* synthetic */ C0101o(j$.util.Spliterator spliterator) {
        this.f75a = spliterator;
    }

    public static /* synthetic */ Spliterator a(j$.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof C0099n ? ((C0099n) spliterator).f73a : new C0101o(spliterator);
    }

    public /* synthetic */ int characteristics() {
        return this.f75a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.f75a.estimateSize();
    }

    @Override // java.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f75a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f75a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f75a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f75a.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator
    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f75a.b(D.b(consumer));
    }

    @Override // java.util.Spliterator
    public /* synthetic */ Spliterator trySplit() {
        return a(this.f75a.trySplit());
    }
}
