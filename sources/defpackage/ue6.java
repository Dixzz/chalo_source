package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: ue6  reason: default package */
/* compiled from: SafeCollector.common.kt */
public final class ue6 implements qe6<T> {
    public final /* synthetic */ qe6 f;

    /* renamed from: ue6$a */
    /* compiled from: Collect.kt */
    public static final class a implements re6<T> {
        public final /* synthetic */ re6 f;

        @y66(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {136}, m = "emit")
        /* renamed from: ue6$a$a  reason: collision with other inner class name */
        public static final class C0059a extends w66 {
            public /* synthetic */ Object f;
            public int g;
            public final /* synthetic */ a h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0059a(a aVar, k66 k66) {
                super(k66);
                this.h = aVar;
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.g |= RtlSpacingHelper.UNDEFINED;
                return this.h.a(null, this);
            }
        }

        public a(re6 re6) {
            this.f = re6;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
        @Override // defpackage.re6
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(java.lang.Object r5, defpackage.k66 r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof defpackage.ue6.a.C0059a
                if (r0 == 0) goto L_0x0013
                r0 = r6
                ue6$a$a r0 = (defpackage.ue6.a.C0059a) r0
                int r1 = r0.g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.g = r1
                goto L_0x0018
            L_0x0013:
                ue6$a$a r0 = new ue6$a$a
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.f
                p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
                int r2 = r0.g
                r3 = 1
                if (r2 == 0) goto L_0x002f
                if (r2 != r3) goto L_0x0027
                defpackage.hd3.Y2(r6)
                goto L_0x003f
            L_0x0027:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x002f:
                defpackage.hd3.Y2(r6)
                re6 r6 = r4.f
                if (r5 == 0) goto L_0x003f
                r0.g = r3
                java.lang.Object r5 = r6.a(r5, r0)
                if (r5 != r1) goto L_0x003f
                return r1
            L_0x003f:
                s56 r5 = defpackage.s56.f3190a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ue6.a.a(java.lang.Object, k66):java.lang.Object");
        }
    }

    public ue6(qe6 qe6) {
        this.f = qe6;
    }

    @Override // defpackage.qe6
    public Object b(re6 re6, k66 k66) {
        Object b = this.f.b(new a(re6), k66);
        if (b == p66.COROUTINE_SUSPENDED) {
            return b;
        }
        return s56.f3190a;
    }
}
