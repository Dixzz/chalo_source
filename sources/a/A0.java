package a;

import j$.util.function.H;
import java.util.function.ObjIntConsumer;

public final /* synthetic */ class A0 implements H {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ObjIntConsumer f4a;

    private /* synthetic */ A0(ObjIntConsumer objIntConsumer) {
        this.f4a = objIntConsumer;
    }

    public static /* synthetic */ H a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        return objIntConsumer instanceof B0 ? ((B0) objIntConsumer).f6a : new A0(objIntConsumer);
    }

    @Override // j$.util.function.H
    public /* synthetic */ void accept(Object obj, int i) {
        this.f4a.accept(obj, i);
    }
}
