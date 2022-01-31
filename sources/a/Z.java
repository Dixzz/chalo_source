package a;

import j$.util.function.w;
import java.util.function.IntConsumer;

public final /* synthetic */ class Z implements IntConsumer {

    /* renamed from: a */
    final /* synthetic */ w f52a;

    private /* synthetic */ Z(w wVar) {
        this.f52a = wVar;
    }

    public static /* synthetic */ IntConsumer a(w wVar) {
        if (wVar == null) {
            return null;
        }
        return wVar instanceof Y ? ((Y) wVar).f50a : new Z(wVar);
    }

    public /* synthetic */ void accept(int i) {
        this.f52a.accept(i);
    }

    public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a(this.f52a.l(Y.b(intConsumer)));
    }
}
