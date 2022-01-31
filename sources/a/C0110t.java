package a;

import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: a.t */
public final /* synthetic */ class C0110t implements Spliterator.c {

    /* renamed from: a */
    final /* synthetic */ Spliterator.OfLong f85a;

    private /* synthetic */ C0110t(Spliterator.OfLong ofLong) {
        this.f85a = ofLong;
    }

    public static /* synthetic */ Spliterator.c a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0112u ? ((C0112u) ofLong).f87a : new C0110t(ofLong);
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.f85a.tryAdvance(E.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.f85a.characteristics();
    }

    @Override // j$.util.Spliterator.c
    public /* synthetic */ void d(C c) {
        this.f85a.forEachRemaining(C0100n0.a(c));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.f85a.estimateSize();
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f85a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f85a.forEachRemaining(obj);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.f85a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.f85a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f85a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator.c
    public /* synthetic */ boolean j(C c) {
        return this.f85a.tryAdvance(C0100n0.a(c));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f85a.tryAdvance(obj);
    }
}
