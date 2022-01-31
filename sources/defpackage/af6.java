package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: af6  reason: default package */
/* compiled from: Share.kt */
public final class af6<T> implements re6<T> {

    @y66(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {410, 414}, m = "onSubscription")
    /* renamed from: af6$a */
    /* compiled from: Share.kt */
    public static final class a extends w66 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public final /* synthetic */ af6<T> i;
        public int j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(af6<T> af6, k66<? super a> k66) {
            super(k66);
            this.i = af6;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RtlSpacingHelper.UNDEFINED;
            return this.i.b(this);
        }
    }

    @Override // defpackage.re6
    public Object a(T t, k66<? super s56> k66) {
        throw null;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(defpackage.k66<? super defpackage.s56> r6) {
        /*
            r5 = this;
            s56 r0 = defpackage.s56.f3190a
            boolean r1 = r6 instanceof defpackage.af6.a
            if (r1 == 0) goto L_0x0015
            r1 = r6
            af6$a r1 = (defpackage.af6.a) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.j = r2
            goto L_0x001a
        L_0x0015:
            af6$a r1 = new af6$a
            r1.<init>(r5, r6)
        L_0x001a:
            java.lang.Object r6 = r1.h
            p66 r2 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r1.j
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r3) goto L_0x0034
            r1 = 2
            if (r2 != r1) goto L_0x002c
            defpackage.hd3.Y2(r6)
            return r0
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r1.g
            if6 r2 = (defpackage.if6) r2
            java.lang.Object r1 = r1.f
            af6 r1 = (defpackage.af6) r1
            defpackage.hd3.Y2(r6)     // Catch:{ all -> 0x005a }
            r2.releaseIntercepted()
            java.util.Objects.requireNonNull(r1)
            return r0
        L_0x0046:
            defpackage.hd3.Y2(r6)
            m66 r6 = r1.getContext()
            if6 r2 = new if6
            r0 = 0
            r2.<init>(r0, r6)
            r1.f = r5
            r1.g = r2
            r1.j = r3
            throw r0
        L_0x005a:
            r6 = move-exception
            r2.releaseIntercepted()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.af6.b(k66):java.lang.Object");
    }
}
