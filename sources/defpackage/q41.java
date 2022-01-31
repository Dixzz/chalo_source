package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import java.util.List;

/* renamed from: q41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q41 implements View.OnClickListener {
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;

    public /* synthetic */ q41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f = confirmSuperPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        ed1 ed1 = new ed1("mPass proof submit button clicked", Long.MIN_VALUE);
        confirmSuperPassPurchaseFragment.j(ed1);
        confirmSuperPassPurchaseFragment.k(ed1);
        ui1.m0(ed1);
        zz zzVar = new zz("submit proof for verification clicked", null, 2);
        zzVar.a("product type", confirmSuperPassPurchaseFragment.l().l.getSuperPassProductConfigurationProperties().getProductType());
        zzVar.a("product subType", confirmSuperPassPurchaseFragment.l().l.getSuperPassProductConfigurationProperties().getProductSubType());
        ui1.l0(zzVar);
        ed1 ed12 = new ed1("terms and conditions open", Long.MIN_VALUE);
        confirmSuperPassPurchaseFragment.k(ed12);
        ui1.m0(ed12);
        ve activity = confirmSuperPassPurchaseFragment.c();
        if (activity != null) {
            on0 on0 = on0.g;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            List<String> productTermsAndConditions = confirmSuperPassPurchaseFragment.l().l.getSuperPassProductConfigurationProperties().getProductTermsAndConditions();
            if (productTermsAndConditions == null) {
                productTermsAndConditions = b66.f;
            }
            on0.d(supportFragmentManager, productTermsAndConditions, new z51(confirmSuperPassPurchaseFragment));
        }
    }
}
