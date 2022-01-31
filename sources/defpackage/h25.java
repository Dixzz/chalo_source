package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: h25  reason: default package */
/* compiled from: UnmodifiableLazyStringList */
public class h25 extends AbstractList<String> implements y05, RandomAccess, List {
    public final y05 f;

    /* renamed from: h25$a */
    /* compiled from: UnmodifiableLazyStringList */
    public class a implements ListIterator<String>, Iterator {
        public ListIterator<String> f;
        public final /* synthetic */ int g;

        public a(int i) {
            this.g = i;
            this.f = h25.this.f.listIterator(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        public boolean hasPrevious() {
            return this.f.hasPrevious();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // j$.util.Iterator, java.util.Iterator, java.util.ListIterator
        public String next() {
            return this.f.next();
        }

        public int nextIndex() {
            return this.f.nextIndex();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.ListIterator
        public String previous() {
            return this.f.previous();
        }

        public int previousIndex() {
            return this.f.previousIndex();
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.ListIterator
        public void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: h25$b */
    /* compiled from: UnmodifiableLazyStringList */
    public class b implements java.util.Iterator<String>, Iterator {
        public java.util.Iterator<String> f;

        public b() {
            this.f = h25.this.f.iterator();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // j$.util.Iterator, java.util.Iterator
        public String next() {
            return this.f.next();
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public h25(y05 y05) {
        this.f = y05;
    }

    @Override // defpackage.y05
    public void K(a05 a05) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.y05
    public Object a(int i) {
        return this.f.a(i);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public String get(int i) {
        return (String) this.f.get(i);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.List, java.util.AbstractList, j$.util.List
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    @Override // defpackage.y05
    public java.util.List<?> m() {
        return this.f.m();
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // defpackage.y05
    public y05 q() {
        return this;
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.f.size();
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }
}
