package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: z96  reason: default package */
/* compiled from: Sequences.kt */
public final class z96<T, R> implements w96<R> {

    /* renamed from: a  reason: collision with root package name */
    public final w96<T> f4150a;
    public final s76<T, R> b;

    /* renamed from: z96$a */
    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, c96, j$.util.Iterator {
        public final Iterator<T> f;
        public final /* synthetic */ z96 g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(z96 z96) {
            this.g = z96;
            this.f = z96.f4150a.iterator();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public R next() {
            return this.g.b.invoke(this.f.next());
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: w96<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: s76<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public z96(w96<? extends T> w96, s76<? super T, ? extends R> s76) {
        n86.e(w96, "sequence");
        n86.e(s76, "transformer");
        this.f4150a = w96;
        this.b = s76;
    }

    @Override // defpackage.w96
    public java.util.Iterator<R> iterator() {
        return new a(this);
    }
}
