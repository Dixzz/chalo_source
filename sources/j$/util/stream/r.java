package j$.util.stream;

import j$.util.function.G;

public final /* synthetic */ class r implements G {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ r f1819a = new r();

    private /* synthetic */ r() {
    }

    @Override // j$.util.function.G
    public final void accept(Object obj, double d) {
        double[] dArr = (double[]) obj;
        C0188n1.b(dArr, d);
        dArr[2] = dArr[2] + d;
    }
}
