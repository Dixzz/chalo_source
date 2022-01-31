package j$.util.stream;

import j$.util.function.G;

/* renamed from: j$.util.stream.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0209t implements G {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0209t f1824a = new C0209t();

    private /* synthetic */ C0209t() {
    }

    @Override // j$.util.function.G
    public final void accept(Object obj, double d) {
        double[] dArr = (double[]) obj;
        dArr[2] = dArr[2] + 1.0d;
        C0188n1.b(dArr, d);
        dArr[3] = dArr[3] + d;
    }
}
