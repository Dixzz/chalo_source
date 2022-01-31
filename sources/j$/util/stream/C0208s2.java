package j$.util.stream;

import j$.util.function.B;
import j$.util.q;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.s2  reason: case insensitive filesystem */
public class C0208s2 extends AbstractC0224w2<Long, q, C0212t2> {
    final /* synthetic */ B b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0208s2(U2 u2, B b2) {
        super(u2);
        this.b = b2;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0212t2(this.b);
    }
}
