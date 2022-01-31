package a;

import j$.util.function.w;
import java.util.function.IntConsumer;

public final /* synthetic */ class Y implements w {

    /* renamed from: a */
    final /* synthetic */ IntConsumer f50a;

    private /* synthetic */ Y(IntConsumer intConsumer) {
        this.f50a = intConsumer;
    }

    public static /* synthetic */ w b(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return intConsumer instanceof Z ? ((Z) intConsumer).f52a : new Y(intConsumer);
    }

    @Override // j$.util.function.w
    public /* synthetic */ void accept(int i) {
        this.f50a.accept(i);
    }

    @Override // j$.util.function.w
    public /* synthetic */ w l(w wVar) {
        return b(this.f50a.andThen(Z.a(wVar)));
    }
}
