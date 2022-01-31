package j$.util.stream;

import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.f0  reason: case insensitive filesystem */
public final /* synthetic */ class C0155f0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0155f0 f1785a = new C0155f0();

    private /* synthetic */ C0155f0() {
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
