package a;

import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: a.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0087h implements s.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PrimitiveIterator.OfDouble f61a;

    private /* synthetic */ C0087h(PrimitiveIterator.OfDouble ofDouble) {
        this.f61a = ofDouble;
    }

    public static /* synthetic */ s.a a(PrimitiveIterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0089i ? ((C0089i) ofDouble).f63a : new C0087h(ofDouble);
    }

    @Override // j$.util.s.a
    public /* synthetic */ void e(q qVar) {
        this.f61a.forEachRemaining(I.a(qVar));
    }

    @Override // j$.util.Iterator, j$.util.s.a
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f61a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f61a.forEachRemaining(obj);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.f61a.hasNext();
    }

    @Override // j$.util.s.a
    public /* synthetic */ double nextDouble() {
        return this.f61a.nextDouble();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void remove() {
        this.f61a.remove();
    }
}
