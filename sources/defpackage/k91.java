package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "app.zophop.ui.viewmodels.cardRecharge.CardDetailsFragmentViewModel", f = "CardDetailsFragmentViewModel.kt", l = {133, 134, 138, 139, 143, 144, 152, 156, 160}, m = "processEnteredCardNo")
/* renamed from: k91  reason: default package */
/* compiled from: CardDetailsFragmentViewModel.kt */
public final class k91 extends w66 {
    public Object f;
    public Object g;
    public /* synthetic */ Object h;
    public final /* synthetic */ h91 i;
    public int j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k91(h91 h91, k66<? super k91> k66) {
        super(k66);
        this.i = h91;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= RtlSpacingHelper.UNDEFINED;
        return h91.d(this.i, null, false, this);
    }
}
