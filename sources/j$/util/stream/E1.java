package j$.util.stream;

import a.C0113u0;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0235z1;

class E1 extends AbstractC0235z1.k<Long> {
    final /* synthetic */ C0113u0 l;

    class a extends A2.c<Integer> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
        public void accept(long j) {
            this.f1691a.accept(E1.this.l.a(j));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    E1(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, C0113u0 u0Var) {
        super(h1Var, u2, i);
        this.l = u0Var;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        return new a(a2);
    }
}
