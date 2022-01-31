package a;

import j$.util.function.I;
import java.util.function.ObjLongConsumer;

public final /* synthetic */ class D0 implements ObjLongConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ I f10a;

    private /* synthetic */ D0(I i) {
        this.f10a = i;
    }

    public static /* synthetic */ ObjLongConsumer a(I i) {
        if (i == null) {
            return null;
        }
        return i instanceof C0 ? ((C0) i).f8a : new D0(i);
    }

    @Override // java.util.function.ObjLongConsumer
    public /* synthetic */ void accept(Object obj, long j) {
        this.f10a.accept(obj, j);
    }
}
