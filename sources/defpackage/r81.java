package defpackage;

import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.RouteStopsInfo;
import defpackage.xt;

@y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$onPayBtnClickedWithNoVerificationRequired$1", f = "MPassPurchaseSharedViewModel.kt", l = {284}, m = "invokeSuspend")
/* renamed from: r81  reason: default package */
/* compiled from: MPassPurchaseSharedViewModel.kt */
public final class r81 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ p81 h;

    @y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$onPayBtnClickedWithNoVerificationRequired$1$lProfileRequestInfoJob$1", f = "MPassPurchaseSharedViewModel.kt", l = {282}, m = "invokeSuspend")
    /* renamed from: r81$a */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super ProfileRequestInfo>, Object> {
        public int f;
        public final /* synthetic */ p81 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p81 p81, k66<? super a> k66) {
            super(2, k66);
            this.g = p81;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super ProfileRequestInfo> k66) {
            return new a(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                p81 p81 = this.g;
                this.f = 1;
                obj = p81.d(p81, this);
                if (obj == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r81(p81 p81, k66<? super r81> k66) {
        super(2, k66);
        this.h = p81;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        r81 r81 = new r81(this.h, k66);
        r81.g = obj;
        return r81;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        r81 r81 = new r81(this.h, k66);
        r81.g = mb6;
        return r81.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        String str = null;
        if (i == 0) {
            hd3.Y2(obj);
            rb6 t = hd3.t((mb6) this.g, null, null, new a(this.h, null), 3, null);
            this.f = 1;
            obj = ((sb6) t).v(this);
            if (obj == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ProfileRequestInfo profileRequestInfo = (ProfileRequestInfo) obj;
        xt.t1 t1Var = xt.f3961a;
        d20 c = t1Var.c();
        MPass mPass = this.h.g;
        RouteStopsInfo routeStopsInfo = mPass.getRouteStopsInfo();
        if (routeStopsInfo != null) {
            str = routeStopsInfo.getRouteId();
        }
        c.A(mPass, str, jh1.c(this.h.g.getStartingTime()), t1Var.L().j(), "online", profileRequestInfo);
        return s56.f3190a;
    }
}
