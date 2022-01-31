package j$.util.stream;

import j$.time.chrono.b;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.C0128e;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class Y2<T> implements Spliterator<T>, Consumer<T> {
    private static final Object d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Spliterator f1762a;
    private final ConcurrentHashMap b;
    private Object c;

    Y2(Spliterator spliterator) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1762a = spliterator;
        this.b = concurrentHashMap;
    }

    private Y2(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f1762a = spliterator;
        this.b = concurrentHashMap;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.c = obj;
    }

    @Override // j$.util.Spliterator
    public boolean b(Consumer consumer) {
        while (this.f1762a.b(this)) {
            ConcurrentHashMap concurrentHashMap = this.b;
            Object obj = this.c;
            if (obj == null) {
                obj = d;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.c);
                this.c = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public int characteristics() {
        return (this.f1762a.characteristics() & -16469) | 1;
    }

    @Override // j$.util.Spliterator
    public long estimateSize() {
        return this.f1762a.estimateSize();
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        this.f1762a.forEachRemaining(new C0226x0(this, consumer));
    }

    public void g(Consumer consumer, Object obj) {
        if (this.b.putIfAbsent(obj != null ? obj : d, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        return this.f1762a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return b.g(this);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return b.h(this, i);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        Spliterator trySplit = this.f1762a.trySplit();
        if (trySplit != null) {
            return new Y2(trySplit, this.b);
        }
        return null;
    }
}
