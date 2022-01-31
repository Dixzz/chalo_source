package a;

import j$.util.function.q;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class I implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f19a;

    private /* synthetic */ I(q qVar) {
        this.f19a = qVar;
    }

    public static /* synthetic */ DoubleConsumer a(q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar instanceof H ? ((H) qVar).f17a : new I(qVar);
    }

    public /* synthetic */ void accept(double d) {
        this.f19a.accept(d);
    }

    public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a(this.f19a.k(H.b(doubleConsumer)));
    }
}
