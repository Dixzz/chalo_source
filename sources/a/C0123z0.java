package a;

import j$.util.function.G;
import java.util.function.ObjDoubleConsumer;

/* renamed from: a.z0  reason: case insensitive filesystem */
public final /* synthetic */ class C0123z0 implements ObjDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f98a;

    private /* synthetic */ C0123z0(G g) {
        this.f98a = g;
    }

    public static /* synthetic */ ObjDoubleConsumer a(G g) {
        if (g == null) {
            return null;
        }
        return g instanceof C0121y0 ? ((C0121y0) g).f96a : new C0123z0(g);
    }

    @Override // java.util.function.ObjDoubleConsumer
    public /* synthetic */ void accept(Object obj, double d) {
        this.f98a.accept(obj, d);
    }
}
