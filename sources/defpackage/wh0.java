package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;

/* renamed from: wh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wh0 implements View.OnClickListener {
    public final /* synthetic */ CardRechargeActivity f;

    public /* synthetic */ wh0(CardRechargeActivity cardRechargeActivity) {
        this.f = cardRechargeActivity;
    }

    public final void onClick(View view) {
        CardRechargeActivity cardRechargeActivity = this.f;
        int i = CardRechargeActivity.o;
        n86.e(cardRechargeActivity, "this$0");
        LinearLayout linearLayout = ((yv) cardRechargeActivity.f0()).c;
        n86.d(linearLayout, "viewBinding.connectionErrorView");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = ((yv) cardRechargeActivity.f0()).d;
        n86.d(linearLayout2, "viewBinding.skeletonLoaderLayout");
        linearLayout2.setVisibility(0);
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = cardRechargeActivity.m;
        if (cardRechargeActivitySharedViewModel != null) {
            cardRechargeActivitySharedViewModel.e(cardRechargeActivity);
        } else {
            n86.l("sharedViewModel");
            throw null;
        }
    }
}
