package defpackage;

import android.content.Context;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: uu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class uu0 extends o86 implements h76<s56> {
    public final /* synthetic */ HomeScreenMainFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uu0(HomeScreenMainFragment homeScreenMainFragment) {
        super(0);
        this.f = homeScreenMainFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        Context requireContext = this.f.requireContext();
        n86.d(requireContext, "requireContext()");
        CardRechargeActivity.s0("sourceHomeScreen", requireContext);
        return s56.f3190a;
    }
}
