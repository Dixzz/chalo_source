package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;

/* renamed from: n41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n41 implements View.OnClickListener {
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;

    public /* synthetic */ n41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f = confirmSuperPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        confirmSuperPassPurchaseFragment.o();
        ba1 ba1 = confirmSuperPassPurchaseFragment.h;
        if (ba1 != null) {
            ba1.d(true);
            SuperPassPurchaseSharedViewModel l = confirmSuperPassPurchaseFragment.l();
            Context requireContext = confirmSuperPassPurchaseFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            l.h(requireContext);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
