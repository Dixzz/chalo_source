package j$.util.stream;

import j$.util.function.H;

public final /* synthetic */ class L implements H {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ L f1713a = new L();

    private /* synthetic */ L() {
    }

    @Override // j$.util.function.H
    public final void accept(Object obj, int i) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + ((long) i);
    }
}
