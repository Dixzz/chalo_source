package defpackage;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* renamed from: ba6  reason: default package */
/* compiled from: Strings.kt */
public final class ba6 implements w96<k96> {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f402a;
    public final int b;
    public final int c;
    public final w76<CharSequence, Integer, m56<Integer, Integer>> d;

    /* renamed from: ba6$a */
    /* compiled from: Strings.kt */
    public static final class a implements Iterator<k96>, c96, j$.util.Iterator {
        public int f = -1;
        public int g;
        public int h;
        public k96 i;
        public int j;
        public final /* synthetic */ ba6 k;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(ba6 ba6) {
            this.k = ba6;
            int b = l96.b(ba6.b, 0, ba6.f402a.length());
            this.g = b;
            this.h = b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if (r6 < r3) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
            // Method dump skipped, instructions count: 131
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ba6.a.a():void");
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (this.f == -1) {
                a();
            }
            return this.f == 1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // j$.util.Iterator, java.util.Iterator
        public k96 next() {
            if (this.f == -1) {
                a();
            }
            if (this.f != 0) {
                k96 k96 = this.i;
                Objects.requireNonNull(k96, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.i = null;
                this.f = -1;
                return k96;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: w76<? super java.lang.CharSequence, ? super java.lang.Integer, m56<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ba6(CharSequence charSequence, int i, int i2, w76<? super CharSequence, ? super Integer, m56<Integer, Integer>> w76) {
        n86.e(charSequence, "input");
        n86.e(w76, "getNextMatch");
        this.f402a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = w76;
    }

    @Override // defpackage.w96
    public java.util.Iterator<k96> iterator() {
        return new a(this);
    }
}
