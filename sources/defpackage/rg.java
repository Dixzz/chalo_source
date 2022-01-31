package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import com.razorpay.AnalyticsConstants;
import defpackage.rc6;

/* renamed from: rg  reason: default package */
/* compiled from: CoroutineLiveData.kt */
public final class rg<T> extends mh<T> {
    public og<T> m;

    /* renamed from: rg$a */
    /* compiled from: CoroutineLiveData.kt */
    public static final class a extends o86 implements h76<s56> {
        public final /* synthetic */ rg f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(rg rgVar) {
            super(0);
            this.f = rgVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public s56 invoke() {
            this.f.m = null;
            return s56.f3190a;
        }
    }

    @y66(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {234}, m = "clearSource$lifecycle_livedata_ktx_release")
    /* renamed from: rg$b */
    /* compiled from: CoroutineLiveData.kt */
    public static final class b extends w66 {
        public /* synthetic */ Object f;
        public int g;
        public final /* synthetic */ rg h;
        public Object i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(rg rgVar, k66 k66) {
            super(k66);
            this.h = rgVar;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= RtlSpacingHelper.UNDEFINED;
            return this.h.n(this);
        }
    }

    public rg(m66 m66, long j, w76<? super kh<T>, ? super k66<? super s56>, ? extends Object> w76) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        n86.e(w76, "block");
        int i = rc6.e;
        kd6 kd6 = new kd6((rc6) m66.get(rc6.a.f));
        xb6 xb6 = xb6.f3911a;
        this.m = new og<>(this, w76, j, hd3.a(xf6.c.A().plus(m66).plus(kd6)), new a(this));
    }

    @Override // androidx.lifecycle.LiveData, defpackage.mh
    public void h() {
        super.h();
        og<T> ogVar = this.m;
        if (ogVar != null) {
            rc6 rc6 = ogVar.b;
            if (rc6 != null) {
                ec6.j(rc6, null, 1, null);
            }
            ogVar.b = null;
            if (ogVar.f2687a == null) {
                ogVar.f2687a = hd3.Y1(ogVar.f, null, null, new ng(ogVar, null), 3, null);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData, defpackage.mh
    public void i() {
        super.i();
        og<T> ogVar = this.m;
        if (ogVar == null) {
            return;
        }
        if (ogVar.b == null) {
            mb6 mb6 = ogVar.f;
            xb6 xb6 = xb6.f3911a;
            ogVar.b = hd3.Y1(mb6, xf6.c.A(), null, new mg(ogVar, null), 2, null);
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(defpackage.k66<? super defpackage.s56> r6) {
        /*
            r5 = this;
            s56 r0 = defpackage.s56.f3190a
            boolean r1 = r6 instanceof defpackage.rg.b
            if (r1 == 0) goto L_0x0015
            r1 = r6
            rg$b r1 = (defpackage.rg.b) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.g = r2
            goto L_0x001a
        L_0x0015:
            rg$b r1 = new rg$b
            r1.<init>(r5, r6)
        L_0x001a:
            java.lang.Object r6 = r1.f
            p66 r2 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r1.g
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r1 = r1.i
            rg r1 = (defpackage.rg) r1
            defpackage.hd3.Y2(r6)
            goto L_0x0039
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            defpackage.hd3.Y2(r6)
            r1 = r5
        L_0x0039:
            java.util.Objects.requireNonNull(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rg.n(k66):java.lang.Object");
    }
}
