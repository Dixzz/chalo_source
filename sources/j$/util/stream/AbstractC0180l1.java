package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0180l1;
import java.util.Iterator;

/* renamed from: j$.util.stream.l1  reason: case insensitive filesystem */
public interface AbstractC0180l1<T, S extends AbstractC0180l1<T, S>> extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator iterator();

    AbstractC0180l1 onClose(Runnable runnable);

    AbstractC0180l1 parallel();

    AbstractC0180l1 sequential();

    Spliterator spliterator();

    AbstractC0180l1 unordered();
}
