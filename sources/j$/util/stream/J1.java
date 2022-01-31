package j$.util.stream;

import a.C0078c0;
import j$.util.function.C0130g;
import j$.util.function.w;
import j$.util.function.y;
import j$.util.stream.A2;
import java.util.Objects;

class J1 extends M1<Integer> implements A2.f {
    final /* synthetic */ N1 c;
    final /* synthetic */ y d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    J1(N1 n1, y yVar) {
        super(n1);
        this.c = n1;
        this.d = yVar;
    }

    @Override // j$.util.stream.A2.f, j$.util.stream.M1, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        if (!this.f1717a && ((C0078c0) this.d).b(i) == this.c.f1720a) {
            this.f1717a = true;
            this.b = this.c.b;
        }
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Integer num) {
        Q1.b(this, num);
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }
}
