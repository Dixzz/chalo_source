package j$.util.stream;

import j$.util.stream.A2;

abstract class D2 extends A2.b<Integer> {
    protected boolean b;

    D2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public final boolean p() {
        this.b = true;
        return false;
    }
}
