package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: sw5  reason: default package */
/* compiled from: Observable */
public class sw5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final qw5<hx5<T>, nx5> f3266a;

    /* renamed from: sw5$a */
    /* compiled from: Observable */
    public class a implements qw5<hx5<T>, nx5> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ix5 f3267a;

        public a(ix5 ix5) {
            this.f3267a = ix5;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.qw5
        public nx5 apply(Object obj) {
            kx5 kx5 = new kx5();
            kx5.c(sw5.this.g(new rw5(this, kx5, (hx5) obj)));
            return kx5;
        }
    }

    /* renamed from: sw5$b */
    /* compiled from: Observable */
    public class b implements qw5<hx5<T>, nx5> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ix5 f3268a;

        public b(ix5 ix5) {
            this.f3268a = ix5;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.qw5
        public nx5 apply(Object obj) {
            pw5 pw5 = new pw5();
            pw5.c(((jx5) this.f3268a).a(new tw5(this, pw5, (hx5) obj)));
            return pw5;
        }
    }

    /* renamed from: sw5$c */
    /* compiled from: Observable */
    public static class c implements qw5<hx5<T>, nx5> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f3269a;

        public c(Object obj) {
            this.f3269a = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: hx5 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.qw5
        public nx5 apply(Object obj) {
            hx5 hx5 = (hx5) obj;
            hx5.b(this.f3269a);
            hx5.a();
            return new nx5();
        }
    }

    /* renamed from: sw5$d */
    /* compiled from: Observable */
    public static class d implements qw5<hx5<T>, nx5> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.qw5
        public nx5 apply(Object obj) {
            ((hx5) obj).a();
            return new nx5();
        }
    }

    /* renamed from: sw5$e */
    /* compiled from: Observable */
    public class e implements qw5<T, sw5<R>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ qw5 f3270a;

        public e(sw5 sw5, qw5 qw5) {
            this.f3270a = qw5;
        }

        @Override // defpackage.qw5
        public Object apply(Object obj) {
            return (sw5) this.f3270a.apply(obj);
        }
    }

    /* renamed from: sw5$f */
    /* compiled from: Observable */
    public static class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f3271a;
    }

    /* renamed from: sw5$g */
    /* compiled from: Observable */
    public static class g<T> {

        /* renamed from: a  reason: collision with root package name */
        public final hx5<T> f3272a;
        public final pw5 b;
        public final AtomicInteger c = new AtomicInteger(1);

        public g(hx5<T> hx5, pw5 pw5) {
            this.f3272a = hx5;
            this.b = pw5;
        }

        public void a(nx5 nx5) {
            if (this.c.decrementAndGet() == 0) {
                this.f3272a.a();
                this.b.a();
                return;
            }
            pw5 pw5 = this.b;
            synchronized (pw5) {
                if (!pw5.b()) {
                    pw5.c.remove(nx5);
                }
            }
        }
    }

    public sw5() {
        this.f3266a = null;
    }

    public static <T> sw5<T> c() {
        return new sw5<>(new d());
    }

    public static <T> sw5<T> e(T t) {
        return new sw5<>(new c(t));
    }

    public <R> sw5<R> d(qw5<T, sw5<R>> qw5) {
        e eVar = new e(this, qw5);
        return new sw5<>(new bx5(this, new pw5(), new WeakReference(this), eVar));
    }

    public sw5<T> f(ix5 ix5) {
        return new sw5<>(new a(ix5));
    }

    public nx5 g(hx5<T> hx5) {
        qw5<hx5<T>, nx5> qw5 = this.f3266a;
        if (qw5 != null) {
            return qw5.apply(hx5);
        }
        return new nx5();
    }

    public sw5<T> h(ix5 ix5) {
        return new sw5<>(new b(ix5));
    }

    public sw5(qw5<hx5<T>, nx5> qw5) {
        this.f3266a = qw5;
    }
}
