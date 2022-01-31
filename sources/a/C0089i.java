package a;

import j$.util.s;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: a.i */
public final /* synthetic */ class C0089i implements PrimitiveIterator.OfDouble {

    /* renamed from: a */
    final /* synthetic */ s.a f63a;

    private /* synthetic */ C0089i(s.a aVar) {
        this.f63a = aVar;
    }

    public static /* synthetic */ PrimitiveIterator.OfDouble a(s.a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar instanceof C0087h ? ((C0087h) aVar).f61a : new C0089i(aVar);
    }

    @Override // java.util.PrimitiveIterator, java.util.PrimitiveIterator.OfDouble
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f63a.forEachRemaining(obj);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f63a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    public /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f63a.e(H.b(doubleConsumer));
    }

    public /* synthetic */ boolean hasNext() {
        return this.f63a.hasNext();
    }

    public /* synthetic */ double nextDouble() {
        return this.f63a.nextDouble();
    }

    public /* synthetic */ void remove() {
        this.f63a.remove();
    }
}
