package defpackage;

import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: v56  reason: default package */
/* compiled from: AbstractList.kt */
public abstract class v56<E> extends u56<E> implements List<E>, c96, j$.util.List {

    /* renamed from: v56$a */
    /* compiled from: AbstractList.kt */
    public class a implements Iterator<E>, c96, j$.util.Iterator {
        public int f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f < v56.this.b();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public E next() {
            if (hasNext()) {
                v56 v56 = v56.this;
                int i = this.f;
                this.f = i + 1;
                return (E) v56.get(i);
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: v56$b */
    /* compiled from: AbstractList.kt */
    public class b extends v56<E>.a implements ListIterator<E>, c96, j$.util.Iterator {
        public b(int i) {
            super();
            int b = v56.this.b();
            if (i < 0 || i > b) {
                throw new IndexOutOfBoundsException(hj1.L("index: ", i, ", size: ", b));
            }
            this.f = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return this.f > 0;
        }

        public int nextIndex() {
            return this.f;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                v56 v56 = v56.this;
                int i = this.f - 1;
                this.f = i;
                return (E) v56.get(i);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: v56$c */
    /* compiled from: AbstractList.kt */
    public static final class c<E> extends v56<E> implements RandomAccess {
        public int f;
        public final v56<E> g;
        public final int h;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: v56<? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(v56<? extends E> v56, int i, int i2) {
            n86.e(v56, "list");
            this.g = v56;
            this.h = i;
            int b = v56.b();
            if (i < 0 || i2 > b) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + b);
            } else if (i <= i2) {
                this.f = i2 - i;
            } else {
                throw new IllegalArgumentException(hj1.L("fromIndex: ", i, " > toIndex: ", i2));
            }
        }

        @Override // defpackage.u56
        public int b() {
            return this.f;
        }

        @Override // java.util.List, defpackage.v56, j$.util.List
        public E get(int i) {
            int i2 = this.f;
            if (i >= 0 && i < i2) {
                return this.g.get(this.h + i);
            }
            throw new IndexOutOfBoundsException(hj1.L("index: ", i, ", size: ", i2));
        }
    }

    @Override // java.util.List, j$.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        n86.e(this, "c");
        n86.e(collection, "other");
        if (size() != collection.size()) {
            return false;
        }
        java.util.Iterator<E> it = collection.iterator();
        for (E e : this) {
            if (!n86.a(e, it.next())) {
            }
        }
        return true;
        return false;
    }

    @Override // java.util.List, j$.util.List
    public abstract E get(int i);

    @Override // j$.util.Collection, j$.util.List
    public int hashCode() {
        n86.e(this, "c");
        java.util.Iterator<E> it = iterator();
        int i = 1;
        while (it.hasNext()) {
            E next = it.next();
            i = (i * 31) + (next != null ? next.hashCode() : 0);
        }
        return i;
    }

    @Override // j$.util.List
    public int indexOf(Object obj) {
        java.util.Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (n86.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new a();
    }

    @Override // j$.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (n86.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator() {
        return new b(0);
    }

    @Override // java.util.List, j$.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, j$.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.List, j$.util.List
    public java.util.List<E> subList(int i, int i2) {
        return new c(this, i, i2);
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator(int i) {
        return new b(i);
    }
}
