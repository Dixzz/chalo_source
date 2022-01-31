package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: pe6  reason: default package */
/* compiled from: Flow.kt */
public abstract class pe6<T> implements qe6<T> {

    @y66(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {212}, m = "collect")
    /* renamed from: pe6$a */
    /* compiled from: Flow.kt */
    public static final class a extends w66 {
        public Object f;
        public /* synthetic */ Object g;
        public final /* synthetic */ pe6<T> h;
        public int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(pe6<T> pe6, k66<? super a> k66) {
            super(k66);
            this.h = pe6;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RtlSpacingHelper.UNDEFINED;
            return this.h.b(null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // defpackage.qe6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(defpackage.re6<? super T> r7, defpackage.k66<? super defpackage.s56> r8) {
        /*
            r6 = this;
            s56 r0 = defpackage.s56.f3190a
            boolean r1 = r8 instanceof defpackage.pe6.a
            if (r1 == 0) goto L_0x0015
            r1 = r8
            pe6$a r1 = (defpackage.pe6.a) r1
            int r2 = r1.i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.i = r2
            goto L_0x001a
        L_0x0015:
            pe6$a r1 = new pe6$a
            r1.<init>(r6, r8)
        L_0x001a:
            java.lang.Object r8 = r1.g
            p66 r2 = defpackage.p66.COROUTINE_SUSPENDED
            int r3 = r1.i
            r4 = 1
            if (r3 == 0) goto L_0x0037
            if (r3 != r4) goto L_0x002f
            java.lang.Object r7 = r1.f
            if6 r7 = (defpackage.if6) r7
            defpackage.hd3.Y2(r8)     // Catch:{ all -> 0x002d }
            goto L_0x0058
        L_0x002d:
            r8 = move-exception
            goto L_0x0060
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            defpackage.hd3.Y2(r8)
            if6 r8 = new if6
            m66 r3 = r1.getContext()
            r8.<init>(r7, r3)
            r1.f = r8     // Catch:{ all -> 0x005c }
            r1.i = r4     // Catch:{ all -> 0x005c }
            r7 = r6
            we6 r7 = (defpackage.we6) r7     // Catch:{ all -> 0x005c }
            w76<re6<? super T>, k66<? super s56>, java.lang.Object> r7 = r7.f     // Catch:{ all -> 0x005c }
            java.lang.Object r7 = r7.invoke(r8, r1)     // Catch:{ all -> 0x005c }
            if (r7 != r2) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r7 = r0
        L_0x0054:
            if (r7 != r2) goto L_0x0057
            return r2
        L_0x0057:
            r7 = r8
        L_0x0058:
            r7.releaseIntercepted()
            return r0
        L_0x005c:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0060:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pe6.b(re6, k66):java.lang.Object");
    }
}
