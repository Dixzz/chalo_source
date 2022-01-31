package j$.util.stream;

import j$.util.Optional;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.o;
import j$.util.p;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.u1  reason: case insensitive filesystem */
abstract class AbstractC0215u1<T, O> implements h3<T, O> {

    /* renamed from: a  reason: collision with root package name */
    boolean f1830a;
    Object b;

    /* renamed from: j$.util.stream.u1$a */
    static final class a extends AbstractC0215u1<Double, o> implements A2.e {
        a() {
        }

        @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2, j$.util.stream.AbstractC0215u1
        public void accept(double d) {
            accept(Double.valueOf(d));
        }

        @Override // j$.util.function.J
        public Object get() {
            if (this.f1830a) {
                return o.d(((Double) this.b).doubleValue());
            }
            return null;
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }
    }

    /* renamed from: j$.util.stream.u1$b */
    static final class b extends AbstractC0215u1<Integer, p> implements A2.f {
        b() {
        }

        @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2, j$.util.stream.AbstractC0215u1
        public void accept(int i) {
            accept(Integer.valueOf(i));
        }

        @Override // j$.util.function.J
        public Object get() {
            if (this.f1830a) {
                return p.d(((Integer) this.b).intValue());
            }
            return null;
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }
    }

    /* renamed from: j$.util.stream.u1$c */
    static final class c extends AbstractC0215u1<Long, j$.util.q> implements A2.g {
        c() {
        }

        @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2, j$.util.stream.AbstractC0215u1
        public void accept(long j) {
            accept(Long.valueOf(j));
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }

        @Override // j$.util.function.J
        public Object get() {
            if (this.f1830a) {
                return j$.util.q.d(((Long) this.b).longValue());
            }
            return null;
        }
    }

    /* renamed from: j$.util.stream.u1$d */
    static final class d<T> extends AbstractC0215u1<T, Optional<T>> {
        d() {
        }

        @Override // j$.util.function.J
        public Object get() {
            if (this.f1830a) {
                return Optional.d(this.b);
            }
            return null;
        }
    }

    AbstractC0215u1() {
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.chrono.b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(int i) {
        j$.time.chrono.b.a(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        j$.time.chrono.b.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (!this.f1830a) {
            this.f1830a = true;
            this.b = obj;
        }
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
    }

    @Override // j$.util.stream.A2
    public boolean p() {
        return this.f1830a;
    }
}
