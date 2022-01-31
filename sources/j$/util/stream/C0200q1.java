package j$.util.stream;

import a.N;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0235z1;

/* renamed from: j$.util.stream.q1  reason: case insensitive filesystem */
class C0200q1 extends AbstractC0235z1.k<Double> {
    final /* synthetic */ N l;

    /* renamed from: j$.util.stream.q1$a */
    class a extends A2.a<Integer> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
        public void accept(double d) {
            this.f1689a.accept(C0200q1.this.l.a(d));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0200q1(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, N n) {
        super(h1Var, u2, i);
        this.l = n;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public A2 G0(int i, A2 a2) {
        return new a(a2);
    }
}
