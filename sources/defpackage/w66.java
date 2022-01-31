package defpackage;

import defpackage.l66;
import defpackage.m66;

/* renamed from: w66  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class w66 extends u66 {
    private final m66 _context;
    private transient k66<Object> intercepted;

    public w66(k66<Object> k66, m66 m66) {
        super(k66);
        this._context = m66;
    }

    @Override // defpackage.k66
    public m66 getContext() {
        m66 m66 = this._context;
        n86.c(m66);
        return m66;
    }

    public final k66<Object> intercepted() {
        k66<Object> k66 = this.intercepted;
        if (k66 == null) {
            m66 context = getContext();
            int i = l66.c;
            l66 l66 = (l66) context.get(l66.a.f);
            if (l66 == null || (k66 = l66.f(this)) == null) {
                k66 = this;
            }
            this.intercepted = k66;
        }
        return k66;
    }

    @Override // defpackage.u66
    public void releaseIntercepted() {
        k66<?> k66 = this.intercepted;
        if (!(k66 == null || k66 == this)) {
            m66 context = getContext();
            int i = l66.c;
            m66.a aVar = context.get(l66.a.f);
            n86.c(aVar);
            ((l66) aVar).e(k66);
        }
        this.intercepted = v66.f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public w66(k66<Object> k66) {
        this(k66, k66 != null ? k66.getContext() : null);
    }
}
