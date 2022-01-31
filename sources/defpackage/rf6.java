package defpackage;

import defpackage.rc6;
import java.util.concurrent.CancellationException;

/* renamed from: rf6 */
public final class rf6 {

    /* renamed from: a */
    public static final dg6 f3077a = new dg6("UNDEFINED");
    public static final dg6 b = new dg6("REUSABLE_CLAIMED");

    public static final <T> void a(k66<? super T> k66, Object obj, s76<? super Throwable, s56> s76) {
        boolean z;
        if (k66 instanceof qf6) {
            qf6 qf6 = (qf6) k66;
            Object d3 = hd3.d3(obj, s76);
            if (qf6.i.n(qf6.getContext())) {
                qf6.k = d3;
                qf6.h = 1;
                qf6.i.m(qf6.getContext(), qf6);
                return;
            }
            md6 md6 = md6.f2360a;
            bc6 a2 = md6.a();
            if (a2.K()) {
                qf6.k = d3;
                qf6.h = 1;
                a2.E(qf6);
                return;
            }
            a2.J(true);
            try {
                rc6 rc6 = (rc6) qf6.getContext().get(rc6.a.f);
                if (rc6 == null || rc6.a()) {
                    z = false;
                } else {
                    CancellationException j = rc6.j();
                    if (d3 instanceof fb6) {
                        ((fb6) d3).b.invoke(j);
                    }
                    qf6.resumeWith(hd3.Z(j));
                    z = true;
                }
                if (!z) {
                    k66<T> k662 = qf6.j;
                    Object obj2 = qf6.l;
                    m66 context = k662.getContext();
                    Object b2 = fg6.b(context, obj2);
                    od6<?> b3 = b2 != fg6.f1122a ? ib6.b(k662, context, b2) : null;
                    try {
                        qf6.j.resumeWith(obj);
                    } finally {
                        if (b3 == null || b3.f0()) {
                            fg6.a(context, b2);
                        }
                    }
                }
                do {
                } while (a2.L());
            } catch (Throwable th) {
                a2.A(true);
                throw th;
            }
            a2.A(true);
            return;
        }
        k66.resumeWith(obj);
    }

    public static /* synthetic */ void b(k66 k66, Object obj, s76 s76, int i) {
        int i2 = i & 2;
        a(k66, obj, null);
    }
}
