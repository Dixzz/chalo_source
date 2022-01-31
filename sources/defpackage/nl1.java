package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import defpackage.or1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: nl1  reason: default package */
/* compiled from: RequestManager */
public class nl1 implements ur1 {
    public static final rs1 o;
    public static final rs1 p;
    public final gl1 f;
    public final tr1 g;
    public final zr1 h;
    public final yr1 i;
    public final bs1 j = new bs1();
    public final Runnable k;
    public final Handler l;
    public final or1 m;
    public rs1 n;

    /* renamed from: nl1$a */
    /* compiled from: RequestManager */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            nl1 nl1 = nl1.this;
            nl1.g.a(nl1);
        }
    }

    /* renamed from: nl1$b */
    /* compiled from: RequestManager */
    public class b implements Runnable {
        public final /* synthetic */ ct1 f;

        public b(ct1 ct1) {
            this.f = ct1;
        }

        public void run() {
            nl1.this.o(this.f);
        }
    }

    /* renamed from: nl1$c */
    /* compiled from: RequestManager */
    public static class c implements or1.a {

        /* renamed from: a  reason: collision with root package name */
        public final zr1 f2573a;

        public c(zr1 zr1) {
            this.f2573a = zr1;
        }
    }

    static {
        rs1 c2 = new rs1().c(Bitmap.class);
        c2.y = true;
        o = c2;
        rs1 c3 = new rs1().c(zq1.class);
        c3.y = true;
        p = c3;
        new rs1().d(gn1.b).k(kl1.LOW).p(true);
    }

    public nl1(gl1 gl1, tr1 tr1, yr1 yr1) {
        zr1 zr1 = new zr1();
        pr1 pr1 = gl1.l;
        a aVar = new a();
        this.k = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.l = handler;
        this.f = gl1;
        this.g = tr1;
        this.i = yr1;
        this.h = zr1;
        Context baseContext = gl1.h.getBaseContext();
        c cVar = new c(zr1);
        Objects.requireNonNull((rr1) pr1);
        or1 qr1 = q5.a(baseContext, "android.permission.ACCESS_NETWORK_STATE") == 0 ? new qr1(baseContext, cVar) : new vr1();
        this.m = qr1;
        if (rt1.g()) {
            handler.post(aVar);
        } else {
            tr1.a(this);
        }
        tr1.a(qr1);
        rs1 b2 = gl1.h.d.clone();
        if (!b2.y || b2.A) {
            b2.A = true;
            b2.y = true;
            this.n = b2;
            synchronized (gl1.m) {
                if (!gl1.m.contains(this)) {
                    gl1.m.add(this);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            }
            return;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public <ResourceType> ml1<ResourceType> c(Class<ResourceType> cls) {
        return new ml1<>(this.f, this, cls);
    }

    public ml1<Bitmap> j() {
        ml1<Bitmap> c2 = c(Bitmap.class);
        c2.a(o);
        return c2;
    }

    public ml1<zq1> k() {
        ml1<zq1> c2 = c(zq1.class);
        c2.a(p);
        return c2;
    }

    @Override // defpackage.ur1
    public void l() {
        this.j.l();
        bs1 bs1 = this.j;
        Objects.requireNonNull(bs1);
        Iterator it = new ArrayList(bs1.f).iterator();
        while (it.hasNext()) {
            o((ct1) it.next());
        }
        this.j.f.clear();
        zr1 zr1 = this.h;
        Iterator it2 = ((ArrayList) rt1.e(zr1.f4203a)).iterator();
        while (it2.hasNext()) {
            zr1.a((os1) it2.next());
        }
        zr1.b.clear();
        this.g.b(this);
        this.g.b(this.m);
        this.l.removeCallbacks(this.k);
        gl1 gl1 = this.f;
        synchronized (gl1.m) {
            if (gl1.m.contains(this)) {
                gl1.m.remove(this);
            } else {
                throw new IllegalStateException("Cannot register not yet registered manager");
            }
        }
    }

    @Override // defpackage.ur1
    public void m() {
        rt1.a();
        zr1 zr1 = this.h;
        zr1.c = true;
        Iterator it = ((ArrayList) rt1.e(zr1.f4203a)).iterator();
        while (it.hasNext()) {
            os1 os1 = (os1) it.next();
            if (os1.isRunning()) {
                os1.pause();
                zr1.b.add(os1);
            }
        }
        this.j.m();
    }

    @Override // defpackage.ur1
    public void n() {
        rt1.a();
        zr1 zr1 = this.h;
        zr1.c = false;
        Iterator it = ((ArrayList) rt1.e(zr1.f4203a)).iterator();
        while (it.hasNext()) {
            os1 os1 = (os1) it.next();
            if (!os1.f() && !os1.isCancelled() && !os1.isRunning()) {
                os1.e();
            }
        }
        zr1.b.clear();
        this.j.n();
    }

    public void o(ct1<?> ct1) {
        if (ct1 != null) {
            if (!rt1.h()) {
                this.l.post(new b(ct1));
            } else if (!q(ct1)) {
                gl1 gl1 = this.f;
                synchronized (gl1.m) {
                    for (nl1 nl1 : gl1.m) {
                        if (nl1.q(ct1)) {
                            return;
                        }
                    }
                    throw new IllegalStateException("Failed to remove target from managers");
                }
            }
        }
    }

    public ml1<Drawable> p(Object obj) {
        ml1<Drawable> c2 = c(Drawable.class);
        c2.m = obj;
        c2.p = true;
        return c2;
    }

    public boolean q(ct1<?> ct1) {
        os1 g2 = ct1.g();
        if (g2 == null) {
            return true;
        }
        if (!this.h.a(g2)) {
            return false;
        }
        this.j.f.remove(ct1);
        ct1.d(null);
        return true;
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.h + ", treeNode=" + this.i + "}";
    }
}
