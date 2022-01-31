package a;

import j$.util.s;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: a.k */
public final /* synthetic */ class C0093k implements PrimitiveIterator.OfInt {

    /* renamed from: a */
    final /* synthetic */ s.b f67a;

    private /* synthetic */ C0093k(s.b bVar) {
        this.f67a = bVar;
    }

    public static /* synthetic */ PrimitiveIterator.OfInt a(s.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar instanceof C0091j ? ((C0091j) bVar).f65a : new C0093k(bVar);
    }

    @Override // java.util.PrimitiveIterator, java.util.PrimitiveIterator.OfInt
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f67a.forEachRemaining(obj);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f67a.forEachRemaining(D.b(consumer));
    }

    @Override // java.util.PrimitiveIterator.OfInt
    public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f67a.c(Y.b(intConsumer));
    }

    public /* synthetic */ boolean hasNext() {
        return this.f67a.hasNext();
    }

    public /* synthetic */ int nextInt() {
        return this.f67a.nextInt();
    }

    public /* synthetic */ void remove() {
        this.f67a.remove();
    }
}
