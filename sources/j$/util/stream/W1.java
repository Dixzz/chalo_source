package j$.util.stream;

import j$.util.function.p;

class W1 extends AbstractC0224w2<Double, Double, X1> {
    final /* synthetic */ p b;
    final /* synthetic */ double c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    W1(U2 u2, p pVar, double d) {
        super(u2);
        this.b = pVar;
        this.c = d;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new X1(this.c, this.b);
    }
}
