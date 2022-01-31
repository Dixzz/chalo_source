package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0182m implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f1807a;
    public final /* synthetic */ ConcurrentHashMap b;

    public /* synthetic */ C0182m(AtomicBoolean atomicBoolean, ConcurrentHashMap concurrentHashMap) {
        this.f1807a = atomicBoolean;
        this.b = concurrentHashMap;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        AtomicBoolean atomicBoolean = this.f1807a;
        ConcurrentHashMap concurrentHashMap = this.b;
        if (obj == null) {
            atomicBoolean.set(true);
        } else {
            concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
        }
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }
}
