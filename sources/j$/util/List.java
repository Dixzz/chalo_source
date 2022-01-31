package j$.util;

import j$.util.function.UnaryOperator;
import j$.util.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

public interface List<E> extends Collection<E> {

    /* renamed from: j$.util.List$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (DesugarCollections.b.isInstance(list)) {
                DesugarCollections.e(list, unaryOperator);
                return;
            }
            Objects.requireNonNull(unaryOperator);
            ListIterator<E> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set((E) unaryOperator.apply(listIterator.next()));
            }
        }

        public static void $default$sort(java.util.List list, Comparator comparator) {
            if (DesugarCollections.b.isInstance(list)) {
                DesugarCollections.f(list, comparator);
                return;
            }
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator<E> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }

        public static Spliterator $default$spliterator(java.util.List list) {
            Objects.requireNonNull(list);
            return new u.i(list, 16);
        }
    }

    void add(int i, Object obj);

    @Override // j$.util.Collection
    boolean add(Object obj);

    boolean addAll(int i, Collection collection);

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

    Object get(int i);

    @Override // j$.util.Collection
    int hashCode();

    int indexOf(Object obj);

    @Override // j$.util.Collection
    boolean isEmpty();

    @Override // j$.util.Collection, j$.lang.Iterable
    Iterator iterator();

    int lastIndexOf(Object obj);

    ListIterator listIterator();

    ListIterator listIterator(int i);

    Object remove(int i);

    @Override // j$.util.Collection
    boolean remove(Object obj);

    @Override // j$.util.Collection
    boolean removeAll(Collection collection);

    void replaceAll(UnaryOperator unaryOperator);

    @Override // j$.util.Collection
    boolean retainAll(Collection collection);

    Object set(int i, Object obj);

    @Override // j$.util.Collection
    int size();

    void sort(Comparator comparator);

    @Override // j$.util.Collection, j$.lang.Iterable
    Spliterator spliterator();

    java.util.List subList(int i, int i2);

    @Override // j$.util.Collection
    Object[] toArray();

    @Override // j$.util.Collection
    Object[] toArray(Object[] objArr);
}
