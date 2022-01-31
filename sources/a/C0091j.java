package a;

import j$.util.function.Consumer;
import j$.util.function.w;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: a.j */
public final /* synthetic */ class C0091j implements s.b {

    /* renamed from: a */
    final /* synthetic */ PrimitiveIterator.OfInt f65a;

    private /* synthetic */ C0091j(PrimitiveIterator.OfInt ofInt) {
        this.f65a = ofInt;
    }

    public static /* synthetic */ s.b a(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0093k ? ((C0093k) ofInt).f67a : new C0091j(ofInt);
    }

    @Override // j$.util.s.b
    public /* synthetic */ void c(w wVar) {
        this.f65a.forEachRemaining(Z.a(wVar));
    }

    @Override // j$.util.Iterator, j$.util.s.b
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f65a.forEachRemaining(E.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.f65a.forEachRemaining(obj);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.f65a.hasNext();
    }

    @Override // j$.util.s.b
    public /* synthetic */ int nextInt() {
        return this.f65a.nextInt();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void remove() {
        this.f65a.remove();
    }
}
