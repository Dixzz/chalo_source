package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0124a;
import j$.util.m;
import java.util.Objects;

/* renamed from: j$.util.stream.a1  reason: case insensitive filesystem */
public final /* synthetic */ class C0136a1 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0136a1 f1768a = new C0136a1();

    private /* synthetic */ C0136a1() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0124a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((m) obj).b((m) obj2);
    }
}
