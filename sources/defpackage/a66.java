package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: a66  reason: default package */
/* compiled from: Collections.kt */
public final class a66 implements ListIterator, c96, Iterator {
    public static final a66 f = new a66();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    @Override // j$.util.Iterator, java.util.Iterator, java.util.ListIterator
    public Object next() {
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return -1;
    }

    @Override // j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
