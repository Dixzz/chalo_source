package j$.util.stream;

import a.C0082e0;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0196p1;

class A1 extends AbstractC0196p1.i<Integer> {
    final /* synthetic */ C0082e0 l;

    class a extends A2.b<Double> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
        public void accept(int i) {
            this.f1690a.accept(A1.this.l.a(i));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    A1(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, C0082e0 e0Var) {
        super(h1Var, u2, i);
        this.l = e0Var;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        return new a(a2);
    }
}
