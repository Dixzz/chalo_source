package a;

import j$.util.function.q;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class H implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleConsumer f17a;

    private /* synthetic */ H(DoubleConsumer doubleConsumer) {
        this.f17a = doubleConsumer;
    }

    public static /* synthetic */ q b(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof I ? ((I) doubleConsumer).f19a : new H(doubleConsumer);
    }

    @Override // j$.util.function.q
    public /* synthetic */ void accept(double d) {
        this.f17a.accept(d);
    }

    @Override // j$.util.function.q
    public /* synthetic */ q k(q qVar) {
        return b(this.f17a.andThen(I.a(qVar)));
    }
}
