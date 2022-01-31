package j$.util.stream;

import j$.util.function.v;
import j$.util.p;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.m2  reason: case insensitive filesystem */
public class C0185m2 extends AbstractC0224w2<Integer, p, C0189n2> {
    final /* synthetic */ v b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0185m2(U2 u2, v vVar) {
        super(u2);
        this.b = vVar;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0189n2(this.b);
    }
}
