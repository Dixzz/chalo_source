package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.ui.activities.SuperPassBookingSuccessActivity;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import java.util.Objects;

/* renamed from: u41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u41 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f3450a;

    public /* synthetic */ u41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f3450a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        Intent intent;
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f3450a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        if (activityResult.f == -1 && (intent = activityResult.g) != null) {
            if (n86.a(intent.getStringExtra("arg_paymentMode"), SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                SuperPassPurchaseSharedViewModel l = confirmSuperPassPurchaseFragment.l();
                Context requireContext = confirmSuperPassPurchaseFragment.requireContext();
                n86.d(requireContext, "requireContext()");
                Objects.requireNonNull(l);
                n86.e(requireContext, "lContext");
                String userId = l.k.getUserId();
                SuperPassOrderDetails superPassOrderDetails = l.q;
                n86.c(superPassOrderDetails);
                y60.h(userId, superPassOrderDetails.getTransactionId(), requireContext);
                return;
            }
            boolean z = true;
            if (n86.a(intent.getStringExtra("arg_paymentMode"), "online")) {
                String stringExtra = intent.getStringExtra("arg_qrCode");
                if (stringExtra == null) {
                    stringExtra = new String();
                }
                String stringExtra2 = intent.getStringExtra("arg_tone");
                if (stringExtra2 == null) {
                    stringExtra2 = new String();
                }
                SuperPassPurchaseSharedViewModel l2 = confirmSuperPassPurchaseFragment.l();
                Context requireContext2 = confirmSuperPassPurchaseFragment.requireContext();
                n86.d(requireContext2, "requireContext()");
                l2.onPaymentCompleted(stringExtra, stringExtra2, "online", requireContext2);
                ba1 ba1 = confirmSuperPassPurchaseFragment.h;
                if (ba1 != null) {
                    ba1.d(false);
                    Context requireContext3 = confirmSuperPassPurchaseFragment.requireContext();
                    n86.d(requireContext3, "requireContext()");
                    SuperPassOrderDetails superPassOrderDetails2 = confirmSuperPassPurchaseFragment.l().q;
                    n86.c(superPassOrderDetails2);
                    String transactionId = superPassOrderDetails2.getTransactionId();
                    String productSubType = confirmSuperPassPurchaseFragment.l().l.getSuperPassProductConfigurationProperties().getProductSubType();
                    long j = confirmSuperPassPurchaseFragment.l().m;
                    n86.e(requireContext3, "lContext");
                    n86.e("sourceSuperPassPurchaseFragment", "lSource");
                    n86.e(transactionId, "lSuperPassId");
                    n86.e(productSubType, "lSuperPassSubType");
                    if (j > ui1.Q()) {
                        z = false;
                    }
                    Intent N0 = hj1.N0(requireContext3, SuperPassBookingSuccessActivity.class, "arg_source", "sourceSuperPassPurchaseFragment");
                    N0.putExtra("arg_superPassId", transactionId);
                    N0.putExtra("arg_superPassSubType", productSubType);
                    N0.putExtra("arg_canActivate", z);
                    requireContext3.startActivity(N0);
                    ve activity = confirmSuperPassPurchaseFragment.c();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                n86.l("viewModel");
                throw null;
            }
            ba1 ba12 = confirmSuperPassPurchaseFragment.h;
            if (ba12 != null) {
                ba12.d(true);
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}
