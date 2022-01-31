package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: e86  reason: default package */
/* compiled from: ArrayIterator.kt */
public final class e86<T> implements Iterator<T>, c96, j$.util.Iterator {
    public int f;
    public final T[] g;

    public e86(T[] tArr) {
        n86.e(tArr, "array");
        this.g = tArr;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return this.f < this.g.length;
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.g;
            int i = this.f;
            this.f = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
