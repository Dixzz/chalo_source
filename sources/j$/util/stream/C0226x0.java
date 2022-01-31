package j$.util.stream;

import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.x0  reason: case insensitive filesystem */
public final /* synthetic */ class C0226x0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y2 f1839a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ C0226x0(Y2 y2, Consumer consumer) {
        this.f1839a = y2;
        this.b = consumer;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f1839a.g(this.b, obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
