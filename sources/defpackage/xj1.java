package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: xj1  reason: default package */
/* compiled from: RequestQueue */
public class xj1 {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f3932a = new AtomicInteger();
    public final Set<wj1<?>> b = new HashSet();
    public final PriorityBlockingQueue<wj1<?>> c = new PriorityBlockingQueue<>();
    public final PriorityBlockingQueue<wj1<?>> d = new PriorityBlockingQueue<>();
    public final jj1 e;
    public final qj1 f;
    public final zj1 g;
    public final rj1[] h;
    public lj1 i;
    public final List<c> j = new ArrayList();

    /* renamed from: xj1$a */
    /* compiled from: RequestQueue */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f3933a;

        public a(xj1 xj1, Object obj) {
            this.f3933a = obj;
        }

        @Override // defpackage.xj1.b
        public boolean a(wj1<?> wj1) {
            return wj1.s == this.f3933a;
        }
    }

    /* renamed from: xj1$b */
    /* compiled from: RequestQueue */
    public interface b {
        boolean a(wj1<?> wj1);
    }

    /* renamed from: xj1$c */
    /* compiled from: RequestQueue */
    public interface c<T> {
        void a(wj1<T> wj1);
    }

    public xj1(jj1 jj1, qj1 qj1) {
        oj1 oj1 = new oj1(new Handler(Looper.getMainLooper()));
        this.e = jj1;
        this.f = qj1;
        this.h = new rj1[4];
        this.g = oj1;
    }

    public <T> wj1<T> a(wj1<T> wj1) {
        wj1.m = this;
        synchronized (this.b) {
            this.b.add(wj1);
        }
        wj1.l = Integer.valueOf(this.f3932a.incrementAndGet());
        wj1.a("add-to-queue");
        if (!wj1.n) {
            this.d.add(wj1);
            return wj1;
        }
        this.c.add(wj1);
        return wj1;
    }

    public void b(b bVar) {
        synchronized (this.b) {
            for (wj1<?> wj1 : this.b) {
                if (bVar.a(wj1)) {
                    wj1.c();
                }
            }
        }
    }

    public void c(Object obj) {
        if (obj != null) {
            b(new a(this, obj));
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }
}
