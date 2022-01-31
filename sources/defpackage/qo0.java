package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;

/* renamed from: qo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f2967a;

    public /* synthetic */ qo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f2967a = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        FragmentManager supportFragmentManager;
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f2967a;
        Boolean bool = (Boolean) obj;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        n86.d(bool, "lShouldShow");
        if (bool.booleanValue()) {
            ve activity = confirmMPassPurchaseFragment.c();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                Fragment I = supportFragmentManager.I("TagConfirmationFragmentLoader");
                if (I != null) {
                    confirmMPassPurchaseFragment.i = (gv0) I;
                }
                if (confirmMPassPurchaseFragment.i == null) {
                    confirmMPassPurchaseFragment.i = vn.U(null, confirmMPassPurchaseFragment.getString(R.string.loading_pass), false, false);
                }
                gv0 gv0 = confirmMPassPurchaseFragment.i;
                if (gv0 != null) {
                    gv0.show(supportFragmentManager, "TagConfirmationFragmentLoader");
                    return;
                }
                return;
            }
            return;
        }
        gv0 gv02 = confirmMPassPurchaseFragment.i;
        if (gv02 != null) {
            gv02.dismiss();
        }
    }
}
