package j$.util.stream;

import j$.util.function.I;
import j$.util.function.J;
import j$.util.function.n;

/* access modifiers changed from: package-private */
public class U1 extends AbstractC0224w2<Long, R, V1> {
    final /* synthetic */ n b;
    final /* synthetic */ I c;
    final /* synthetic */ J d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    U1(U2 u2, n nVar, I i, J j) {
        super(u2);
        this.b = nVar;
        this.c = i;
        this.d = j;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new V1(this.d, this.c, this.b);
    }
}
