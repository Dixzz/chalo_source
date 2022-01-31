package defpackage;

import defpackage.gc;
import defpackage.gc.a;
import java.io.IOException;
import java.util.Map;

/* renamed from: dc  reason: default package */
/* compiled from: ExtensionSchema */
public abstract class dc<T extends gc.a<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(cc ccVar, dd ddVar, int i);

    public abstract gc<T> c(Object obj);

    public abstract gc<T> d(Object obj);

    public abstract boolean e(dd ddVar);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(qd qdVar, Object obj, cc ccVar, gc<T> gcVar, UB ub, yd<UT, UB> ydVar) throws IOException;

    public abstract void h(qd qdVar, Object obj, cc ccVar, gc<T> gcVar) throws IOException;

    public abstract void i(ub ubVar, Object obj, cc ccVar, gc<T> gcVar) throws IOException;

    public abstract void j(he heVar, Map.Entry<?, ?> entry) throws IOException;
}
