package defpackage;

/* renamed from: od6  reason: default package */
/* compiled from: CoroutineContext.kt */
public final class od6<T> extends bg6<T> {
    public m66 i;
    public Object j;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public od6(defpackage.m66 r3, defpackage.k66<? super T> r4) {
        /*
            r2 = this;
            pd6 r0 = defpackage.pd6.f
            m66$a r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000c
            m66 r3 = r3.plus(r0)
        L_0x000c:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.od6.<init>(m66, k66):void");
    }

    @Override // defpackage.bg6, defpackage.ka6
    public void c0(Object obj) {
        m66 m66 = this.i;
        od6<?> od6 = null;
        if (m66 != null) {
            fg6.a(m66, this.j);
            this.i = od6;
            this.j = od6;
        }
        Object B2 = hd3.B2(obj, this.h);
        k66<T> k66 = this.h;
        m66 context = k66.getContext();
        Object b = fg6.b(context, od6);
        if (b != fg6.f1122a) {
            od6 = ib6.b(k66, context, b);
        }
        try {
            this.h.resumeWith(B2);
        } finally {
            if (od6 == null || od6.f0()) {
                fg6.a(context, b);
            }
        }
    }

    public final boolean f0() {
        if (this.i == null) {
            return false;
        }
        this.i = null;
        this.j = null;
        return true;
    }
}
