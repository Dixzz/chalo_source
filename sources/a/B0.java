package a;

import j$.util.function.H;
import java.util.function.ObjIntConsumer;

public final /* synthetic */ class B0 implements ObjIntConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ H f6a;

    private /* synthetic */ B0(H h) {
        this.f6a = h;
    }

    public static /* synthetic */ ObjIntConsumer a(H h) {
        if (h == null) {
            return null;
        }
        return h instanceof A0 ? ((A0) h).f4a : new B0(h);
    }

    @Override // java.util.function.ObjIntConsumer
    public /* synthetic */ void accept(Object obj, int i) {
        this.f6a.accept(obj, i);
    }
}
