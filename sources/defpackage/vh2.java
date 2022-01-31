package defpackage;

import java.util.Iterator;
import java.util.Map;

/* renamed from: vh2  reason: default package */
public final class vh2 implements uh2 {
    @Override // defpackage.uh2
    public final Object b(Object obj, Object obj2) {
        th2 th2 = (th2) obj;
        th2 th22 = (th2) obj2;
        if (!th22.isEmpty()) {
            if (!th2.f) {
                th2 = th2.isEmpty() ? new th2() : new th2(th2);
            }
            th2.a();
            if (!th22.isEmpty()) {
                th2.putAll(th22);
            }
        }
        return th2;
    }

    @Override // defpackage.uh2
    public final Object c(Object obj) {
        th2 th2 = th2.g;
        return th2.isEmpty() ? new th2() : new th2(th2);
    }

    @Override // defpackage.uh2
    public final Object d(Object obj) {
        ((th2) obj).f = false;
        return obj;
    }

    @Override // defpackage.uh2
    public final int e(int i, Object obj, Object obj2) {
        th2 th2 = (th2) obj;
        if (th2.isEmpty()) {
            return 0;
        }
        Iterator it = th2.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.uh2
    public final boolean f(Object obj) {
        return !((th2) obj).f;
    }

    @Override // defpackage.uh2
    public final sh2<?, ?> g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // defpackage.uh2
    public final Map<?, ?> h(Object obj) {
        return (th2) obj;
    }

    @Override // defpackage.uh2
    public final Map<?, ?> i(Object obj) {
        return (th2) obj;
    }
}
