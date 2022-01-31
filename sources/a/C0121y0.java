package a;

import j$.util.function.G;
import java.util.function.ObjDoubleConsumer;

/* renamed from: a.y0 */
public final /* synthetic */ class C0121y0 implements G {

    /* renamed from: a */
    final /* synthetic */ ObjDoubleConsumer f96a;

    private /* synthetic */ C0121y0(ObjDoubleConsumer objDoubleConsumer) {
        this.f96a = objDoubleConsumer;
    }

    public static /* synthetic */ G a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return objDoubleConsumer instanceof C0123z0 ? ((C0123z0) objDoubleConsumer).f98a : new C0121y0(objDoubleConsumer);
    }

    @Override // j$.util.function.G
    public /* synthetic */ void accept(Object obj, double d) {
        this.f96a.accept(obj, d);
    }
}
