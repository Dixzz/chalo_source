package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: u96  reason: default package */
/* compiled from: Sequences.kt */
public final class u96<T> implements w96<T>, v96<T> {

    /* renamed from: a  reason: collision with root package name */
    public final w96<T> f3477a;
    public final int b;

    /* renamed from: u96$a */
    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, c96, j$.util.Iterator {
        public final Iterator<T> f;
        public int g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(u96 u96) {
            this.f = u96.f3477a.iterator();
            this.g = u96.b;
        }

        public final void a() {
            while (this.g > 0 && this.f.hasNext()) {
                this.f.next();
                this.g--;
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            a();
            return this.f.hasNext();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public T next() {
            a();
            return this.f.next();
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: w96<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public u96(w96<? extends T> w96, int i) {
        n86.e(w96, "sequence");
        this.f3477a = w96;
        this.b = i;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
        }
    }

    @Override // defpackage.v96
    public w96<T> a(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new u96(this, i) : new u96(this.f3477a, i2);
    }

    @Override // defpackage.w96
    public java.util.Iterator<T> iterator() {
        return new a(this);
    }
}
