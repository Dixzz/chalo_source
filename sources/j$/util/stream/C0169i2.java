package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.J;

/* renamed from: j$.util.stream.i2  reason: case insensitive filesystem */
class C0169i2 extends AbstractC0224w2<T, R, C0173j2> {
    final /* synthetic */ BiConsumer b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ J d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0169i2(U2 u2, BiConsumer biConsumer, BiConsumer biConsumer2, J j) {
        super(u2);
        this.b = biConsumer;
        this.c = biConsumer2;
        this.d = j;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0173j2(this.d, this.c, this.b);
    }
}
