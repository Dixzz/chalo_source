package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;

/* renamed from: s41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class s41 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f3182a;

    public /* synthetic */ s41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f3182a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        FragmentManager supportFragmentManager;
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f3182a;
        Boolean bool = (Boolean) obj;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        n86.d(bool, "lShouldShow");
        if (bool.booleanValue()) {
            ve activity = confirmSuperPassPurchaseFragment.c();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                Fragment I = supportFragmentManager.I("TagConfirmationFragmentLoader");
                if (I != null) {
                    confirmSuperPassPurchaseFragment.i = (gv0) I;
                }
                if (confirmSuperPassPurchaseFragment.i == null) {
                    confirmSuperPassPurchaseFragment.i = vn.U(null, confirmSuperPassPurchaseFragment.getString(R.string.loading_pass), false, false);
                }
                gv0 gv0 = confirmSuperPassPurchaseFragment.i;
                if (gv0 != null) {
                    gv0.show(supportFragmentManager, "TagConfirmationFragmentLoader");
                    return;
                }
                return;
            }
            return;
        }
        gv0 gv02 = confirmSuperPassPurchaseFragment.i;
        if (gv02 != null) {
            gv02.dismiss();
        }
    }
}
