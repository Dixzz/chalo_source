package j$.util;

import j$.util.function.Consumer;
import java.util.Objects;

public interface Iterator<E> {

    /* renamed from: j$.util.Iterator$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEachRemaining(java.util.Iterator it, Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }

        public static void a(java.util.Iterator it) {
            throw new UnsupportedOperationException("remove");
        }
    }

    void forEachRemaining(Consumer consumer);

    boolean hasNext();

    Object next();

    void remove();
}
