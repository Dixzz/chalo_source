package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;

/* renamed from: ey0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ey0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f1042a;

    public /* synthetic */ ey0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f1042a = cardRechargeConfirmPaymentFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        FragmentManager supportFragmentManager;
        CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f1042a;
        Boolean bool = (Boolean) obj;
        int i = CardRechargeConfirmPaymentFragment.l;
        n86.e(cardRechargeConfirmPaymentFragment, "this$0");
        n86.d(bool, "lShouldShow");
        if (bool.booleanValue()) {
            ve activity = cardRechargeConfirmPaymentFragment.c();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                Fragment I = supportFragmentManager.I("TagConfirmationFragmentLoader");
                if (I != null) {
                    cardRechargeConfirmPaymentFragment.j = (gv0) I;
                }
                if (cardRechargeConfirmPaymentFragment.j == null) {
                    cardRechargeConfirmPaymentFragment.j = vn.U(null, cardRechargeConfirmPaymentFragment.getString(R.string.loading_pass), false, false);
                }
                gv0 gv0 = cardRechargeConfirmPaymentFragment.j;
                if (gv0 != null) {
                    gv0.show(supportFragmentManager, "TagConfirmationFragmentLoader");
                    return;
                }
                return;
            }
            return;
        }
        gv0 gv02 = cardRechargeConfirmPaymentFragment.j;
        if (gv02 != null) {
            gv02.dismiss();
        }
    }
}
