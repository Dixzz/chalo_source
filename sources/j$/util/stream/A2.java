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

/* access modifiers changed from: package-private */
public interface A2<T> extends Consumer<T> {

    public static abstract class a<E_OUT> implements e {

        /* renamed from: a  reason: collision with root package name */
        protected final A2 f1689a;

        public a(A2 a2) {
            Objects.requireNonNull(a2);
            this.f1689a = a2;
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

        /* renamed from: b */
        public /* synthetic */ void accept(Double d) {
            Q1.a(this, d);
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.f1689a.m();
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.f1689a.n(j);
        }

        @Override // j$.util.stream.A2
        public boolean p() {
            return this.f1689a.p();
        }
    }

    public static abstract class b<E_OUT> implements f {

        /* renamed from: a  reason: collision with root package name */
        protected final A2 f1690a;

        public b(A2 a2) {
            Objects.requireNonNull(a2);
            this.f1690a = a2;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        /* renamed from: b */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.f1690a.m();
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.f1690a.n(j);
        }

        @Override // j$.util.stream.A2
        public boolean p() {
            return this.f1690a.p();
        }
    }

    public static abstract class c<E_OUT> implements g {

        /* renamed from: a  reason: collision with root package name */
        protected final A2 f1691a;

        public c(A2 a2) {
            Objects.requireNonNull(a2);
            this.f1691a = a2;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        /* renamed from: b */
        public /* synthetic */ void accept(Long l) {
            Q1.c(this, l);
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.f1691a.m();
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.f1691a.n(j);
        }

        @Override // j$.util.stream.A2
        public boolean p() {
            return this.f1691a.p();
        }
    }

    public static abstract class d<T, E_OUT> implements A2<T> {

        /* renamed from: a  reason: collision with root package name */
        protected final A2 f1692a;

        public d(A2 a2) {
            Objects.requireNonNull(a2);
            this.f1692a = a2;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
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
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.f1692a.m();
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.f1692a.n(j);
        }

        @Override // j$.util.stream.A2
        public boolean p() {
            return this.f1692a.p();
        }
    }

    public interface e extends A2<Double>, q {
        @Override // j$.util.function.q, j$.util.stream.A2
        void accept(double d);
    }

    public interface f extends A2<Integer>, w {
        @Override // j$.util.function.w, j$.util.stream.A2
        void accept(int i);
    }

    public interface g extends A2<Long>, C {
        @Override // j$.util.function.C, j$.util.stream.A2
        void accept(long j);
    }

    void accept(double d2);

    void accept(int i);

    void accept(long j);

    void m();

    void n(long j);

    boolean p();
}
