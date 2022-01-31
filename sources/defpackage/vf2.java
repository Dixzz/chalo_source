package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: vf2  reason: default package */
public final class vf2 implements Iterator, j$.util.Iterator {
    public int f = 0;
    public final int g;
    public final /* synthetic */ uf2 h;

    public vf2(uf2 uf2) {
        this.h = uf2;
        this.g = uf2.size();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f < this.g;
    }

    @Override // j$.util.Iterator, java.util.Iterator
    public final Object next() {
        try {
            uf2 uf2 = this.h;
            int i = this.f;
            this.f = i + 1;
            return Byte.valueOf(uf2.s(i));
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
