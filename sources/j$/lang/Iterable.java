package j$.lang;

import j$.util.DesugarCollections;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.u;
import java.util.Iterator;
import java.util.Objects;

public interface Iterable<T> {

    /* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEach(Iterable iterable, Consumer consumer) {
            if (DesugarCollections.f1644a.isInstance(iterable)) {
                DesugarCollections.c(iterable, consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }

        public static Spliterator $default$spliterator(Iterable iterable) {
            return u.o(iterable.iterator(), 0);
        }
    }

    void forEach(Consumer consumer);

    Iterator iterator();

    Spliterator spliterator();
}
