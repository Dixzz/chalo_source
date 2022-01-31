package j$.util;

import j$.util.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public interface Set<E> extends Collection<E> {

    /* renamed from: j$.util.Set$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Spliterator $default$spliterator(java.util.Set set) {
            Objects.requireNonNull(set);
            return new u.i(set, 1);
        }
    }

    @Override // j$.util.Collection
    boolean add(Object obj);

    @Override // j$.util.Collection
    boolean addAll(Collection collection);

    @Override // j$.util.Collection
    void clear();

    @Override // j$.util.Collection
    boolean contains(Object obj);

    @Override // j$.util.Collection
    boolean containsAll(Collection collection);

    @Override // j$.util.Collection
    boolean equals(Object obj);

    @Override // j$.util.Collection
    int hashCode();

    @Override // j$.util.Collection
    boolean isEmpty();

    @Override // j$.util.Collection, j$.lang.Iterable
    Iterator iterator();

    @Override // j$.util.Collection
    boolean remove(Object obj);

    @Override // j$.util.Collection
    boolean removeAll(Collection collection);

    @Override // j$.util.Collection
    boolean retainAll(Collection collection);

    @Override // j$.util.Collection
    int size();

    @Override // j$.util.Collection, j$.lang.Iterable
    Spliterator spliterator();

    @Override // j$.util.Collection
    Object[] toArray();

    @Override // j$.util.Collection
    Object[] toArray(Object[] objArr);
}
