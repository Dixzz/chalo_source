package defpackage;

import defpackage.sw5;

/* renamed from: rw5  reason: default package */
/* compiled from: Observable */
public class rw5 implements hx5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kx5 f3141a;
    public final /* synthetic */ hx5 b;
    public final /* synthetic */ sw5.a c;

    /* renamed from: rw5$a */
    /* compiled from: Observable */
    public class a implements Runnable {
        public final /* synthetic */ Object f;

        public a(Object obj) {
            this.f = obj;
        }

        public void run() {
            if (!rw5.this.f3141a.b()) {
                rw5.this.b.b(this.f);
            }
        }
    }

    /* renamed from: rw5$b */
    /* compiled from: Observable */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (!rw5.this.f3141a.b()) {
                rw5.this.b.a();
            }
        }
    }

    public rw5(sw5.a aVar, kx5 kx5, hx5 hx5) {
        this.c = aVar;
        this.f3141a = kx5;
        this.b = hx5;
    }

    @Override // defpackage.hx5
    public void a() {
        ((jx5) this.c.f3267a).a(new b());
    }

    @Override // defpackage.hx5
    public void b(T t) {
        ((jx5) this.c.f3267a).a(new a(t));
    }
}
