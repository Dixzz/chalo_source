package defpackage;

import android.view.View;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargePaymentSuccessActivity;

/* renamed from: ci0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ci0 implements View.OnClickListener {
    public final /* synthetic */ OnlineCardRechargePaymentSuccessActivity f;

    public /* synthetic */ ci0(OnlineCardRechargePaymentSuccessActivity onlineCardRechargePaymentSuccessActivity) {
        this.f = onlineCardRechargePaymentSuccessActivity;
    }

    public final void onClick(View view) {
        OnlineCardRechargePaymentSuccessActivity onlineCardRechargePaymentSuccessActivity = this.f;
        int i = OnlineCardRechargePaymentSuccessActivity.n;
        n86.e(onlineCardRechargePaymentSuccessActivity, "this$0");
        ed1 ed1 = new ed1("ocr payment success ok clicked", Long.MIN_VALUE);
        String str = onlineCardRechargePaymentSuccessActivity.l;
        if (str != null) {
            ed1.a("cardTransactionId", str);
            ui1.m0(ed1);
            onlineCardRechargePaymentSuccessActivity.onBackPressed();
            return;
        }
        n86.l("transactionId");
        throw null;
    }
}
