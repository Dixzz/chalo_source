package defpackage;

import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import com.google.android.material.textview.MaterialTextView;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment$initObservers$2$1", f = "ActiveSuperPassVisualValidationFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: i31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class i31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i31(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, k66<? super i31> k66) {
        super(2, k66);
        this.f = activeSuperPassVisualValidationFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new i31(this.f, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        i31 i31 = new i31(this.f, k66);
        s56 s56 = s56.f3190a;
        i31.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        MaterialTextView materialTextView = ActiveSuperPassVisualValidationFragment.f(this.f).n;
        materialTextView.setText(jh1.i(ui1.Q()) + ", " + ((Object) jh1.d(ui1.Q())));
        return s56.f3190a;
    }
}
