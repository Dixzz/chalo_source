package a;

import j$.util.function.I;
import java.util.function.ObjLongConsumer;

public final /* synthetic */ class C0 implements I {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ObjLongConsumer f8a;

    private /* synthetic */ C0(ObjLongConsumer objLongConsumer) {
        this.f8a = objLongConsumer;
    }

    public static /* synthetic */ I a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return objLongConsumer instanceof D0 ? ((D0) objLongConsumer).f10a : new C0(objLongConsumer);
    }

    @Override // j$.util.function.I
    public /* synthetic */ void accept(Object obj, long j) {
        this.f8a.accept(obj, j);
    }
}
