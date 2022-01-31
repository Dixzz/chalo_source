package j$.util.stream;

import j$.util.stream.A2;

abstract class E2 extends A2.c<Long> {
    protected boolean b;

    E2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public final boolean p() {
        this.b = true;
        return false;
    }
}
