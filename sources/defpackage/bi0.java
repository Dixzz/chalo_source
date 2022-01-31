package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargePaymentSuccessActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;

/* renamed from: bi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bi0 implements View.OnClickListener {
    public final /* synthetic */ OnlineCardRechargePaymentSuccessActivity f;

    public /* synthetic */ bi0(OnlineCardRechargePaymentSuccessActivity onlineCardRechargePaymentSuccessActivity) {
        this.f = onlineCardRechargePaymentSuccessActivity;
    }

    public final void onClick(View view) {
        OnlineCardRechargePaymentSuccessActivity onlineCardRechargePaymentSuccessActivity = this.f;
        int i = OnlineCardRechargePaymentSuccessActivity.n;
        n86.e(onlineCardRechargePaymentSuccessActivity, "this$0");
        ed1 ed1 = new ed1("ocr payment success recharge details clicked", Long.MIN_VALUE);
        String str = onlineCardRechargePaymentSuccessActivity.l;
        if (str != null) {
            ed1.a("cardTransactionId", str);
            ui1.m0(ed1);
            String str2 = onlineCardRechargePaymentSuccessActivity.l;
            if (str2 != null) {
                n86.e(str2, "lTransactionId");
                n86.e("sourceOnlineCardRechargePaymentSuccessActivity", "lSource");
                n86.e(onlineCardRechargePaymentSuccessActivity, "lContext");
                Intent intent = new Intent(onlineCardRechargePaymentSuccessActivity, OnlineCardRechargeSummaryActivity.class);
                intent.putExtra("arg_transactionId", str2);
                intent.putExtra("arg_source", "sourceOnlineCardRechargePaymentSuccessActivity");
                onlineCardRechargePaymentSuccessActivity.startActivity(intent);
                return;
            }
            n86.l("transactionId");
            throw null;
        }
        n86.l("transactionId");
        throw null;
    }
}
