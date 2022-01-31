package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRechargeOrderDetails;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargePaymentSuccessActivity;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;

/* renamed from: dy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dy0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f903a;

    public /* synthetic */ dy0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f903a = cardRechargeConfirmPaymentFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        Intent intent;
        CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f903a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = CardRechargeConfirmPaymentFragment.l;
        n86.e(cardRechargeConfirmPaymentFragment, "this$0");
        if (activityResult.f == -1 && (intent = activityResult.g) != null) {
            if (n86.a(intent.getStringExtra("arg_paymentMode"), "online")) {
                CardRechargeActivitySharedViewModel l = cardRechargeConfirmPaymentFragment.l();
                o91 o91 = cardRechargeConfirmPaymentFragment.h;
                if (o91 != null) {
                    l.onPaymentCompleted(o91.f, "online");
                    o91 o912 = cardRechargeConfirmPaymentFragment.h;
                    if (o912 != null) {
                        o912.d(false);
                        Context requireContext = cardRechargeConfirmPaymentFragment.requireContext();
                        n86.d(requireContext, "requireContext()");
                        OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails = cardRechargeConfirmPaymentFragment.l().l;
                        n86.c(onlineCardRechargeOrderDetails);
                        String transactionId = onlineCardRechargeOrderDetails.getTransactionId();
                        o91 o913 = cardRechargeConfirmPaymentFragment.h;
                        if (o913 != null) {
                            String rechargeDelayCopy = o913.f.getRechargeDelayCopy();
                            n86.e(requireContext, "lContext");
                            n86.e("sourceCardRechargeConfirmPaymentScreen", "lSource");
                            n86.e(transactionId, "lTransactionId");
                            n86.e(rechargeDelayCopy, "lRechargeDelayCopy");
                            Intent N0 = hj1.N0(requireContext, OnlineCardRechargePaymentSuccessActivity.class, "arg_source", "sourceCardRechargeConfirmPaymentScreen");
                            N0.putExtra("arg_transactionId", transactionId);
                            N0.putExtra("arg_rechargeDelayCopy", rechargeDelayCopy);
                            requireContext.startActivity(N0);
                            ve activity = cardRechargeConfirmPaymentFragment.c();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        n86.l("viewModel");
                        throw null;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                n86.l("viewModel");
                throw null;
            }
            o91 o914 = cardRechargeConfirmPaymentFragment.h;
            if (o914 != null) {
                o914.d(true);
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}
