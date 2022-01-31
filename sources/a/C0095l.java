package a;

import j$.util.function.C;
import j$.util.function.Consumer;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: a.l */
public final /* synthetic */ class C0095l implements s.c {

    /* renamed from: a */
    final /* synthetic */ PrimitiveIterator.OfLong f69a;

    private /* synthetic */ C0095l(PrimitiveIterator.OfLong ofLong) {
        this.f69a = ofLong;
    }

    public static /* synthetic */ s.c a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0097m ? ((C0097m) ofLong).f71a : new C0095l(ofLong);
    }

    @Override // j$.util.s.c
    public /* synthetic */ void d(C c) {
        this.f69a.forEachRemaining(C0100n0.a(c));
    }

    @Override // j$.util.Iterator, j$.util.s.c
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f69a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f69a.forEachRemaining(obj);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.f69a.hasNext();
    }

    @Override // j$.util.s.c
    public /* synthetic */ long nextLong() {
        return this.f69a.nextLong();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void remove() {
        this.f69a.remove();
    }
}
