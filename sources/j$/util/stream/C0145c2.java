package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.n;

/* renamed from: j$.util.stream.c2  reason: case insensitive filesystem */
class C0145c2 extends AbstractC0224w2<T, U, C0149d2> {
    final /* synthetic */ n b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ Object d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0145c2(U2 u2, n nVar, BiFunction biFunction, Object obj) {
        super(u2);
        this.b = nVar;
        this.c = biFunction;
        this.d = obj;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0149d2(this.d, this.c, this.b);
    }
}
