package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.en1;
import defpackage.st1;
import defpackage.vt1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: in1  reason: default package */
/* compiled from: EngineJob */
public class in1<R> implements en1.a<R>, st1.d {
    public static final Handler A = new Handler(Looper.getMainLooper(), new b());
    public static final a z = new a();
    public final List<ss1> f = new ArrayList(2);
    public final vt1 g = new vt1.b();
    public final v7<in1<?>> h;
    public final a i;
    public final jn1 j;
    public final vo1 k;
    public final vo1 l;
    public final vo1 m;
    public dm1 n;
    public boolean o;
    public boolean p;
    public rn1<?> q;
    public xl1 r;
    public boolean s;
    public nn1 t;
    public boolean u;
    public List<ss1> v;
    public mn1<?> w;
    public en1<R> x;
    public volatile boolean y;

    /* renamed from: in1$a */
    /* compiled from: EngineJob */
    public static class a {
    }

    /* renamed from: in1$b */
    /* compiled from: EngineJob */
    public static class b implements Handler.Callback {
        public boolean handleMessage(Message message) {
            in1 in1 = (in1) message.obj;
            int i = message.what;
            if (i == 1) {
                in1.g.a();
                if (in1.y) {
                    in1.q.a();
                    in1.b(false);
                } else if (in1.f.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                } else if (!in1.s) {
                    a aVar = in1.i;
                    rn1<?> rn1 = in1.q;
                    boolean z = in1.o;
                    Objects.requireNonNull(aVar);
                    mn1<?> mn1 = new mn1<>(rn1, z);
                    in1.w = mn1;
                    in1.s = true;
                    mn1.d();
                    ((hn1) in1.j).d(in1.n, in1.w);
                    for (ss1 ss1 : in1.f) {
                        List<ss1> list = in1.v;
                        if (!(list != null && list.contains(ss1))) {
                            in1.w.d();
                            ss1.c(in1.w, in1.r);
                        }
                    }
                    in1.w.e();
                    in1.b(false);
                } else {
                    throw new IllegalStateException("Already have resource");
                }
            } else if (i == 2) {
                in1.g.a();
                if (in1.y) {
                    in1.b(false);
                } else if (in1.f.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                } else if (!in1.u) {
                    in1.u = true;
                    ((hn1) in1.j).d(in1.n, null);
                    for (ss1 ss12 : in1.f) {
                        List<ss1> list2 = in1.v;
                        if (!(list2 != null && list2.contains(ss12))) {
                            ss12.b(in1.t);
                        }
                    }
                    in1.b(false);
                } else {
                    throw new IllegalStateException("Already failed once");
                }
            } else if (i == 3) {
                in1.g.a();
                if (in1.y) {
                    ((hn1) in1.j).c(in1, in1.n);
                    in1.b(false);
                } else {
                    throw new IllegalStateException("Not cancelled");
                }
            } else {
                StringBuilder i0 = hj1.i0("Unrecognized message: ");
                i0.append(message.what);
                throw new IllegalStateException(i0.toString());
            }
            return true;
        }
    }

    public in1(vo1 vo1, vo1 vo12, vo1 vo13, jn1 jn1, v7<in1<?>> v7Var) {
        a aVar = z;
        this.k = vo1;
        this.l = vo12;
        this.m = vo13;
        this.j = jn1;
        this.h = v7Var;
        this.i = aVar;
    }

    public void a(ss1 ss1) {
        rt1.a();
        this.g.a();
        if (this.s) {
            ss1.c(this.w, this.r);
        } else if (this.u) {
            ss1.b(this.t);
        } else {
            this.f.add(ss1);
        }
    }

    public final void b(boolean z2) {
        boolean a2;
        rt1.a();
        this.f.clear();
        this.n = null;
        this.w = null;
        this.q = null;
        List<ss1> list = this.v;
        if (list != null) {
            list.clear();
        }
        this.u = false;
        this.y = false;
        this.s = false;
        en1<R> en1 = this.x;
        en1.e eVar = en1.l;
        synchronized (eVar) {
            eVar.f1003a = true;
            a2 = eVar.a(z2);
        }
        if (a2) {
            en1.q();
        }
        this.x = null;
        this.t = null;
        this.r = null;
        this.h.a(this);
    }

    @Override // defpackage.st1.d
    public vt1 g() {
        return this.g;
    }
}
