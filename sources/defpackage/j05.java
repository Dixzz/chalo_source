package defpackage;

import defpackage.m05;
import defpackage.m05.a;
import java.io.IOException;
import java.util.Map;

/* renamed from: j05  reason: default package */
/* compiled from: ExtensionSchema */
public abstract class j05<T extends m05.a<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(i05 i05, j15 j15, int i);

    public abstract m05<T> c(Object obj);

    public abstract m05<T> d(Object obj);

    public abstract boolean e(j15 j15);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(w15 w15, Object obj, i05 i05, m05<T> m05, UB ub, e25<UT, UB> e25) throws IOException;

    public abstract void h(w15 w15, Object obj, i05 i05, m05<T> m05) throws IOException;

    public abstract void i(a05 a05, Object obj, i05 i05, m05<T> m05) throws IOException;

    public abstract void j(n25 n25, Map.Entry<?, ?> entry) throws IOException;
}
