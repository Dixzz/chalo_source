package j$.util.stream;

import a.L;
import j$.util.function.C0129f;
import j$.util.function.q;
import j$.util.function.s;
import j$.util.stream.A2;
import java.util.Objects;

class L1 extends M1<Double> implements A2.e {
    final /* synthetic */ N1 c;
    final /* synthetic */ s d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    L1(N1 n1, s sVar) {
        super(n1);
        this.c = n1;
        this.d = sVar;
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.M1, j$.util.stream.A2
    public void accept(double d2) {
        if (!this.f1717a && ((L) this.d).b(d2) == this.c.f1720a) {
            this.f1717a = true;
            this.b = this.c.b;
        }
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Double d2) {
        Q1.a(this, d2);
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }
}
