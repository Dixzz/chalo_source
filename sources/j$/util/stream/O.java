package j$.util.stream;

import j$.util.function.I;

public final /* synthetic */ class O implements I {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ O f1721a = new O();

    private /* synthetic */ O() {
    }

    @Override // j$.util.function.I
    public final void accept(Object obj, long j) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j;
    }
}
