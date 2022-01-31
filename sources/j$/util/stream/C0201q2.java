package j$.util.stream;

import j$.util.function.B;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.q2  reason: case insensitive filesystem */
public class C0201q2 extends AbstractC0224w2<Long, Long, C0204r2> {
    final /* synthetic */ B b;
    final /* synthetic */ long c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0201q2(U2 u2, B b2, long j) {
        super(u2);
        this.b = b2;
        this.c = j;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0204r2(this.c, this.b);
    }
}
