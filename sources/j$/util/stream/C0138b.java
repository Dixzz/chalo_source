package j$.util.stream;

import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0138b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A2 f1769a;

    public /* synthetic */ C0138b(A2 a2) {
        this.f1769a = a2;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f1769a.accept(obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
