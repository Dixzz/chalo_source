package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.J;
import j$.util.function.n;
import j$.util.stream.AbstractC0184m1;

/* renamed from: j$.util.stream.g2  reason: case insensitive filesystem */
class C0161g2 extends AbstractC0224w2<T, I, C0165h2> {
    final /* synthetic */ n b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ J d;
    final /* synthetic */ AbstractC0184m1 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0161g2(U2 u2, n nVar, BiConsumer biConsumer, J j, AbstractC0184m1 m1Var) {
        super(u2);
        this.b = nVar;
        this.c = biConsumer;
        this.d = j;
        this.e = m1Var;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0165h2(this.d, this.c, this.b);
    }

    @Override // j$.util.stream.AbstractC0224w2, j$.util.stream.g3
    public int b() {
        if (this.e.characteristics().contains(AbstractC0184m1.a.UNORDERED)) {
            return T2.r;
        }
        return 0;
    }
}
