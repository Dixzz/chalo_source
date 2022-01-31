package defpackage;

import defpackage.rc6;
import java.util.concurrent.CancellationException;

/* renamed from: vb6  reason: default package */
/* compiled from: DispatchedTask.kt */
public abstract class vb6<T> extends sg6 {
    public int h;

    public vb6(int i) {
        this.h = i;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract k66<T> b();

    public Throwable c(Object obj) {
        eb6 eb6 = obj instanceof eb6 ? (eb6) obj : null;
        if (eb6 == null) {
            return null;
        }
        return eb6.f955a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                hd3.l(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            n86.c(th);
            hd3.x1(b().getContext(), new ob6("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object i();

    public final void run() {
        rc6 rc6;
        Object obj = s56.f3190a;
        tg6 tg6 = this.g;
        try {
            qf6 qf6 = (qf6) b();
            k66<T> k66 = qf6.j;
            Object obj2 = qf6.l;
            m66 context = k66.getContext();
            Object b = fg6.b(context, obj2);
            od6<?> b2 = b != fg6.f1122a ? ib6.b(k66, context, b) : null;
            try {
                m66 context2 = k66.getContext();
                Object i = i();
                Throwable c = c(i);
                if (c != null || !hd3.D1(this.h)) {
                    rc6 = null;
                } else {
                    int i2 = rc6.e;
                    rc6 = (rc6) context2.get(rc6.a.f);
                }
                if (rc6 != null && !rc6.a()) {
                    CancellationException j = rc6.j();
                    a(i, j);
                    k66.resumeWith(hd3.Z(j));
                } else if (c != null) {
                    k66.resumeWith(hd3.Z(c));
                } else {
                    k66.resumeWith(e(i));
                }
                try {
                    tg6.h();
                } catch (Throwable th) {
                    obj = hd3.Z(th);
                }
                f(null, n56.a(obj));
                return;
            } finally {
                if (b2 == null || b2.f0()) {
                    fg6.a(context, b);
                }
            }
        } catch (Throwable th2) {
            obj = hd3.Z(th2);
        }
        f(th, n56.a(obj));
    }
}
