package j$.util.stream;

import a.C0109s0;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0196p1;

class F1 extends AbstractC0196p1.i<Long> {
    final /* synthetic */ C0109s0 l;

    class a extends A2.c<Double> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
        public void accept(long j) {
            this.f1691a.accept(F1.this.l.a(j));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    F1(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, C0109s0 s0Var) {
        super(h1Var, u2, i);
        this.l = s0Var;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        return new a(a2);
    }
}
