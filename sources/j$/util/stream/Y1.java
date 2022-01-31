package j$.util.stream;

import j$.util.function.p;
import j$.util.o;

/* access modifiers changed from: package-private */
public class Y1 extends AbstractC0224w2<Double, o, Z1> {
    final /* synthetic */ p b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Y1(U2 u2, p pVar) {
        super(u2);
        this.b = pVar;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new Z1(this.b);
    }
}
