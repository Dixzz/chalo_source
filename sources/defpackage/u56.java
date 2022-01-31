package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: u56  reason: default package */
/* compiled from: AbstractCollection.kt */
public abstract class u56<E> implements Collection<E>, c96, j$.util.Collection {

    /* renamed from: u56$a */
    /* compiled from: AbstractCollection.kt */
    public static final class a extends o86 implements s76<E, CharSequence> {
        public final /* synthetic */ u56 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u56 u56) {
            super(1);
            this.f = u56;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.s76
        public CharSequence invoke(Object obj) {
            return obj == this.f ? "(this Collection)" : String.valueOf(obj);
        }
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int b();

    @Override // j$.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = ((v56) this).iterator();
        while (it.hasNext()) {
            if (n86.a(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        n86.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection
    public boolean isEmpty() {
        return b() == 0;
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean removeAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.Collection, java.util.Collection
    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }

    @Override // j$.util.Collection
    public Object[] toArray() {
        return i86.a(this);
    }

    public String toString() {
        return y56.m(this, ", ", "[", "]", 0, null, new a(this), 24);
    }

    @Override // j$.util.Collection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        n86.e(tArr, "array");
        return (T[]) i86.b(this, tArr);
    }
}
