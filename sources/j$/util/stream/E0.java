package j$.util.stream;

import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

public final /* synthetic */ class E0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ E0 f1700a = new E0();

    private /* synthetic */ E0() {
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
