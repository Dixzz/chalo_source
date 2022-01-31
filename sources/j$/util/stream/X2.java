package j$.util.stream;

import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import java.util.Objects;

abstract class X2 {

    /* renamed from: a  reason: collision with root package name */
    int f1759a;

    static final class a extends d<q> implements q {
        final double[] c;

        a(int i) {
            this.c = new double[i];
        }

        @Override // j$.util.function.q
        public void accept(double d) {
            double[] dArr = this.c;
            int i = this.b;
            this.b = i + 1;
            dArr[i] = d;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.X2.d
        public void b(Object obj, long j) {
            q qVar = (q) obj;
            for (int i = 0; ((long) i) < j; i++) {
                qVar.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }
    }

    static final class b extends d<w> implements w {
        final int[] c;

        b(int i) {
            this.c = new int[i];
        }

        @Override // j$.util.function.w
        public void accept(int i) {
            int[] iArr = this.c;
            int i2 = this.b;
            this.b = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.X2.d
        public void b(Object obj, long j) {
            w wVar = (w) obj;
            for (int i = 0; ((long) i) < j; i++) {
                wVar.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }
    }

    static final class c extends d<C> implements C {
        final long[] c;

        c(int i) {
            this.c = new long[i];
        }

        @Override // j$.util.function.C
        public void accept(long j) {
            long[] jArr = this.c;
            int i = this.b;
            this.b = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.stream.X2.d
        public void b(Object obj, long j) {
            C c2 = (C) obj;
            for (int i = 0; ((long) i) < j; i++) {
                c2.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.C
        public C g(C c2) {
            Objects.requireNonNull(c2);
            return new C0131h(this, c2);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class d<T_CONS> extends X2 {
        int b;

        d() {
        }

        /* access modifiers changed from: package-private */
        public abstract void b(Object obj, long j);
    }

    static final class e<T> extends X2 implements Consumer<T> {
        final Object[] b;

        e(int i) {
            this.b = new Object[i];
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            Object[] objArr = this.b;
            int i = this.f1759a;
            this.f1759a = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }
    }

    X2() {
    }
}
