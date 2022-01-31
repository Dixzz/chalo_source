package j$.util.stream;

import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.List;
import java.util.Objects;

/* renamed from: j$.util.stream.b1  reason: case insensitive filesystem */
public final /* synthetic */ class C0140b1 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1771a;

    public /* synthetic */ C0140b1(List list) {
        this.f1771a = list;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f1771a.add(obj);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
