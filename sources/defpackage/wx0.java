package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: wx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wx0 implements View.OnClickListener {
    public final /* synthetic */ CardDetailsFragment f;

    public /* synthetic */ wx0(CardDetailsFragment cardDetailsFragment) {
        this.f = cardDetailsFragment;
    }

    public final void onClick(View view) {
        CardDetailsFragment cardDetailsFragment = this.f;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        if (cardDetailsFragment.c() != null) {
            hj1.P0("ocr cardDetails see all clicked", Long.MIN_VALUE, "source", "sourceCardDetailsScreen");
            Context requireContext = cardDetailsFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            OnlineCardRechargeHistoryActivity.u0("sourceCardDetailsScreen", requireContext);
        }
    }
}
