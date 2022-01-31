package j$.util.stream;

import j$.util.function.v;

/* renamed from: j$.util.stream.k2  reason: case insensitive filesystem */
class C0177k2 extends AbstractC0224w2<Integer, Integer, C0181l2> {
    final /* synthetic */ v b;
    final /* synthetic */ int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0177k2(U2 u2, v vVar, int i) {
        super(u2);
        this.b = vVar;
        this.c = i;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0181l2(this.c, this.b);
    }
}
