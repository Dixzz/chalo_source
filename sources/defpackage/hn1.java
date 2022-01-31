package defpackage;

import android.os.Looper;
import android.os.MessageQueue;
import defpackage.en1;
import defpackage.jo1;
import defpackage.mn1;
import defpackage.ro1;
import defpackage.st1;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: hn1  reason: default package */
/* compiled from: Engine */
public class hn1 implements jn1, ro1.a, mn1.a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<dm1, in1<?>> f1390a = new HashMap();
    public final ln1 b = new ln1();
    public final ro1 c;
    public final b d;
    public final Map<dm1, WeakReference<mn1<?>>> e = new HashMap();
    public final un1 f;
    public final c g;
    public final a h;
    public ReferenceQueue<mn1<?>> i;

    /* renamed from: hn1$a */
    /* compiled from: Engine */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final en1.d f1391a;
        public final v7<en1<?>> b = st1.a(150, new C0026a());
        public int c;

        /* renamed from: hn1$a$a  reason: collision with other inner class name */
        /* compiled from: Engine */
        public class C0026a implements st1.b<en1<?>> {
            public C0026a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.st1.b
            public en1<?> a() {
                a aVar = a.this;
                return new en1(aVar.f1391a, aVar.b);
            }
        }

        public a(en1.d dVar) {
            this.f1391a = dVar;
        }
    }

    /* renamed from: hn1$b */
    /* compiled from: Engine */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final vo1 f1393a;
        public final vo1 b;
        public final vo1 c;
        public final jn1 d;
        public final v7<in1<?>> e = st1.a(150, new a());

        /* renamed from: hn1$b$a */
        /* compiled from: Engine */
        public class a implements st1.b<in1<?>> {
            public a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.st1.b
            public in1<?> a() {
                b bVar = b.this;
                return new in1(bVar.f1393a, bVar.b, bVar.c, bVar.d, bVar.e);
            }
        }

        public b(vo1 vo1, vo1 vo12, vo1 vo13, jn1 jn1) {
            this.f1393a = vo1;
            this.b = vo12;
            this.c = vo13;
            this.d = jn1;
        }
    }

    /* renamed from: hn1$c */
    /* compiled from: Engine */
    public static class c implements en1.d {

        /* renamed from: a  reason: collision with root package name */
        public final jo1.a f1395a;
        public volatile jo1 b;

        public c(jo1.a aVar) {
            this.f1395a = aVar;
        }

        public jo1 a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = ((mo1) this.f1395a).a();
                    }
                    if (this.b == null) {
                        this.b = new ko1();
                    }
                }
            }
            return this.b;
        }
    }

    /* renamed from: hn1$d */
    /* compiled from: Engine */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final in1<?> f1396a;
        public final ss1 b;

        public d(ss1 ss1, in1<?> in1) {
            this.b = ss1;
            this.f1396a = in1;
        }
    }

    /* renamed from: hn1$e */
    /* compiled from: Engine */
    public static class e implements MessageQueue.IdleHandler {

        /* renamed from: a  reason: collision with root package name */
        public final Map<dm1, WeakReference<mn1<?>>> f1397a;
        public final ReferenceQueue<mn1<?>> b;

        public e(Map<dm1, WeakReference<mn1<?>>> map, ReferenceQueue<mn1<?>> referenceQueue) {
            this.f1397a = map;
            this.b = referenceQueue;
        }

        public boolean queueIdle() {
            f fVar = (f) this.b.poll();
            if (fVar == null) {
                return true;
            }
            this.f1397a.remove(fVar.f1398a);
            return true;
        }
    }

    /* renamed from: hn1$f */
    /* compiled from: Engine */
    public static class f extends WeakReference<mn1<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final dm1 f1398a;

        public f(dm1 dm1, mn1<?> mn1, ReferenceQueue<? super mn1<?>> referenceQueue) {
            super(mn1, referenceQueue);
            this.f1398a = dm1;
        }
    }

    public hn1(ro1 ro1, jo1.a aVar, vo1 vo1, vo1 vo12, vo1 vo13) {
        this.c = ro1;
        c cVar = new c(aVar);
        this.g = cVar;
        this.d = new b(vo1, vo12, vo13, this);
        this.h = new a(cVar);
        this.f = new un1();
        ((qo1) ro1).d = this;
    }

    public static void b(String str, long j, dm1 dm1) {
        StringBuilder k0 = hj1.k0(str, " in ");
        k0.append(nt1.a(j));
        k0.append("ms, key: ");
        k0.append(dm1);
        k0.toString();
    }

    public final ReferenceQueue<mn1<?>> a() {
        if (this.i == null) {
            this.i = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new e(this.e, this.i));
        }
        return this.i;
    }

    public void c(in1 in1, dm1 dm1) {
        rt1.a();
        if (in1.equals(this.f1390a.get(dm1))) {
            this.f1390a.remove(dm1);
        }
    }

    public void d(dm1 dm1, mn1<?> mn1) {
        rt1.a();
        if (mn1 != null) {
            mn1.h = dm1;
            mn1.g = this;
            if (mn1.f) {
                this.e.put(dm1, new f(dm1, mn1, a()));
            }
        }
        this.f1390a.remove(dm1);
    }
}
