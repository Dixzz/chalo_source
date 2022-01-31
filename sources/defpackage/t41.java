package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import java.util.List;

/* renamed from: t41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t41 implements View.OnClickListener {
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;

    public /* synthetic */ t41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f = confirmSuperPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        confirmSuperPassPurchaseFragment.o();
        ed1 ed1 = new ed1("terms and conditions open", Long.MIN_VALUE);
        confirmSuperPassPurchaseFragment.k(ed1);
        ui1.m0(ed1);
        ve activity = confirmSuperPassPurchaseFragment.c();
        if (activity != null) {
            on0 on0 = on0.g;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            List<String> productTermsAndConditions = confirmSuperPassPurchaseFragment.l().l.getSuperPassProductConfigurationProperties().getProductTermsAndConditions();
            if (productTermsAndConditions == null) {
                productTermsAndConditions = b66.f;
            }
            on0.d(supportFragmentManager, productTermsAndConditions, new y51(confirmSuperPassPurchaseFragment));
        }
    }
}
