package defpackage;

import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;
import com.google.android.material.textview.MaterialTextView;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment$initObservers$2$1", f = "ActiveSuperPassFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: u21  reason: default package */
/* compiled from: ActiveSuperPassFragment.kt */
public final class u21 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ActiveSuperPassFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u21(ActiveSuperPassFragment activeSuperPassFragment, k66<? super u21> k66) {
        super(2, k66);
        this.f = activeSuperPassFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new u21(this.f, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        u21 u21 = new u21(this.f, k66);
        s56 s56 = s56.f3190a;
        u21.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        MaterialTextView materialTextView = ActiveSuperPassFragment.f(this.f).m;
        materialTextView.setText(jh1.i(ui1.Q()) + ", " + ((Object) jh1.d(ui1.Q())));
        return s56.f3190a;
    }
}
