package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.ui.viewmodels.cardRecharge.CardRechargeAmountFragmentViewModel", f = "CardRechargeAmountFragmentViewModel.kt", l = {51, 56, 65, 69, 73, 77}, m = "processEnteredAmount")
/* renamed from: n91  reason: default package */
/* compiled from: CardRechargeAmountFragmentViewModel.kt */
public final class n91 extends w66 {
    public Object f;
    public Object g;
    public long h;
    public /* synthetic */ Object i;
    public final /* synthetic */ m91 j;
    public int k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n91(m91 m91, k66<? super n91> k66) {
        super(k66);
        this.j = m91;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= RtlSpacingHelper.UNDEFINED;
        return m91.d(this.j, null, this);
    }
}
