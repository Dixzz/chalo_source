package j$.util.stream;

import j$.util.Optional;
import j$.util.function.n;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.e2  reason: case insensitive filesystem */
public class C0153e2 extends AbstractC0224w2<T, Optional<T>, C0157f2> {
    final /* synthetic */ n b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0153e2(U2 u2, n nVar) {
        super(u2);
        this.b = nVar;
    }

    @Override // j$.util.stream.AbstractC0224w2
    public AbstractC0216u2 a() {
        return new C0157f2(this.b);
    }
}
