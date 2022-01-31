package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX WARN: Incorrect class signature, class is equals to this class: Lin2<Ljava/lang/String;>;Lj$/util/Iterator; */
/* renamed from: in2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class in2 implements Iterator, Iterator {
    @NullableDecl
    public T f;
    public int g = 2;
    public final CharSequence h;
    public int i = 0;
    public int j;

    public in2(un2 un2, CharSequence charSequence) {
        Objects.requireNonNull(un2);
        this.j = Integer.MAX_VALUE;
        this.h = charSequence;
    }

    public abstract int a(int i2);

    public abstract int b(int i2);

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i3 = this.g;
        if (i3 != 4) {
            int i4 = i3 - 1;
            T t = null;
            if (i3 == 0) {
                throw null;
            } else if (i4 == 0) {
                return true;
            } else {
                if (i4 != 2) {
                    this.g = 4;
                    int i5 = this.i;
                    while (true) {
                        int i6 = this.i;
                        if (i6 == -1) {
                            this.g = 3;
                            break;
                        }
                        int a2 = a(i6);
                        if (a2 == -1) {
                            a2 = this.h.length();
                            this.i = -1;
                            i2 = -1;
                        } else {
                            i2 = b(a2);
                            this.i = i2;
                        }
                        if (i2 == i5) {
                            int i7 = i2 + 1;
                            this.i = i7;
                            if (i7 > this.h.length()) {
                                this.i = -1;
                            }
                        } else {
                            if (i5 < a2) {
                                this.h.charAt(i5);
                            }
                            if (i5 < a2) {
                                this.h.charAt(a2 - 1);
                            }
                            int i8 = this.j;
                            if (i8 == 1) {
                                a2 = this.h.length();
                                this.i = -1;
                                if (a2 > i5) {
                                    this.h.charAt(a2 - 1);
                                }
                            } else {
                                this.j = i8 - 1;
                            }
                            t = (T) this.h.subSequence(i5, a2).toString();
                        }
                    }
                    this.f = t;
                    if (this.g != 3) {
                        this.g = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // j$.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.g = 2;
            T t = this.f;
            this.f = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
