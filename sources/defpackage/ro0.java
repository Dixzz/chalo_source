package defpackage;

import android.view.View;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;

/* renamed from: ro0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ro0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMPassPurchaseFragment f;

    public /* synthetic */ ro0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f = confirmMPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        confirmMPassPurchaseFragment.o();
        c81 c81 = confirmMPassPurchaseFragment.h;
        if (c81 != null) {
            c81.d(true);
            confirmMPassPurchaseFragment.k().h();
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
