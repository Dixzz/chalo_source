package j$.util.stream;

import j$.util.function.H;
import j$.util.function.J;
import j$.util.function.n;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.o2  reason: case insensitive filesystem */
public class C0193o2 extends AbstractC0224w2<Integer, R, C0197p2> {
    final /* synthetic */ n b;
    final /* synthetic */ H c;
    final /* synthetic */ J d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0193o2(U2 u2, n nVar, H h, J j) {
        super(u2);
        this.b = nVar;
        this.c = h;
        this.d = j;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0197p2(this.d, this.c, this.b);
    }
}
