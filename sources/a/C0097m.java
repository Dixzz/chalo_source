package a;

import j$.util.s;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: a.m */
public final /* synthetic */ class C0097m implements PrimitiveIterator.OfLong {

    /* renamed from: a */
    final /* synthetic */ s.c f71a;

    private /* synthetic */ C0097m(s.c cVar) {
        this.f71a = cVar;
    }

    public static /* synthetic */ PrimitiveIterator.OfLong a(s.c cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar instanceof C0095l ? ((C0095l) cVar).f69a : new C0097m(cVar);
    }

    @Override // java.util.PrimitiveIterator, java.util.PrimitiveIterator.OfLong
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f71a.forEachRemaining(obj);
    }

    @Override // java.util.Iterator, java.util.PrimitiveIterator.OfLong
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f71a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f71a.d(C0098m0.b(longConsumer));
    }

    public /* synthetic */ boolean hasNext() {
        return this.f71a.hasNext();
    }

    public /* synthetic */ long nextLong() {
        return this.f71a.nextLong();
    }

    public /* synthetic */ void remove() {
        this.f71a.remove();
    }
}
