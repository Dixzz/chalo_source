package defpackage;

import app.zophop.models.mTicketing.ProfileRequestInfo;

@y66(c = "app.zophop.ui.viewmodels.MPassPurchaseSharedViewModel$onProofSubmitBtnClicked$1", f = "MPassPurchaseSharedViewModel.kt", l = {301}, m = "invokeSuspend")
/* renamed from: s81  reason: default package */
/* compiled from: MPassPurchaseSharedViewModel.kt */
public final class s81 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public Object f;
    public int g;
    public final /* synthetic */ p81 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s81(p81 p81, k66<? super s81> k66) {
        super(2, k66);
        this.h = p81;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new s81(this.h, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new s81(this.h, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        t20 t20;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.g;
        if (i == 0) {
            hd3.Y2(obj);
            t20 L = xt.f3961a.L();
            p81 p81 = this.h;
            this.f = L;
            this.g = 1;
            Object d = p81.d(p81, this);
            if (d == p66) {
                return p66;
            }
            t20 = L;
            obj = d;
        } else if (i == 1) {
            t20 = (t20) this.f;
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        t20.b((ProfileRequestInfo) obj);
        return s56.f3190a;
    }
}
