package defpackage;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;

/* renamed from: ml  reason: default package */
/* compiled from: CoroutinesRoom.kt */
public final class ml {
    public static final <R> qe6<R> a(wl wlVar, boolean z, String[] strArr, Callable<R> callable) {
        n86.e(wlVar, "db");
        n86.e(strArr, "tableNames");
        n86.e(callable, "callable");
        return new we6(new il(z, wlVar, strArr, callable, null));
    }

    public static final <R> Object b(wl wlVar, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, k66<? super R> k66) {
        if (wlVar.isOpen() && wlVar.inTransaction()) {
            return callable.call();
        }
        cm cmVar = (cm) k66.getContext().get(cm.f);
        kb6 Y = z ? h.Y(wlVar) : h.V(wlVar);
        sa6 sa6 = new sa6(hd3.B1(k66), 1);
        sa6.v();
        sa6.g(new kl(cancellationSignal, hd3.Y1(kc6.f, Y, null, new ll(callable, sa6, null), 2, null)));
        Object u = sa6.u();
        if (u != p66.COROUTINE_SUSPENDED) {
            return u;
        }
        n86.e(k66, "frame");
        return u;
    }

    public static final <R> Object c(wl wlVar, boolean z, Callable<R> callable, k66<? super R> k66) {
        if (wlVar.isOpen() && wlVar.inTransaction()) {
            return callable.call();
        }
        cm cmVar = (cm) k66.getContext().get(cm.f);
        return hd3.j3(z ? h.Y(wlVar) : h.V(wlVar), new jl(callable, null), k66);
    }
}
