package j$.util.stream;

import a.C0106q0;
import j$.util.function.C;
import j$.util.function.C0131h;
import j$.util.function.E;
import j$.util.stream.A2;
import java.util.Objects;

class K1 extends M1<Long> implements A2.g {
    final /* synthetic */ N1 c;
    final /* synthetic */ E d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    K1(N1 n1, E e) {
        super(n1);
        this.c = n1;
        this.d = e;
    }

    @Override // j$.util.function.C, j$.util.stream.M1, j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j) {
        if (!this.f1717a && ((C0106q0) this.d).b(j) == this.c.f1720a) {
            this.f1717a = true;
            this.b = this.c.b;
        }
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Long l) {
        Q1.c(this, l);
    }

    @Override // j$.util.function.C
    public C g(C c2) {
        Objects.requireNonNull(c2);
        return new C0131h(this, c2);
    }
}
