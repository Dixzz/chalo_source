package j$.util.stream;

import j$.util.function.G;
import j$.util.function.J;
import j$.util.function.n;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.a2  reason: case insensitive filesystem */
public class C0137a2 extends AbstractC0224w2<Double, R, C0141b2> {
    final /* synthetic */ n b;
    final /* synthetic */ G c;
    final /* synthetic */ J d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0137a2(U2 u2, n nVar, G g, J j) {
        super(u2);
        this.b = nVar;
        this.c = g;
        this.d = j;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0141b2(this.d, this.c, this.b);
    }
}
