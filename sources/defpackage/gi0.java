package defpackage;

import android.content.Intent;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;
import java.util.Objects;

/* renamed from: gi0  reason: default package */
/* compiled from: OnlineCardRechargeHistoryActivity.kt */
public final class gi0 extends o86 implements s76<OnlineCardRecharge, s56> {
    public final /* synthetic */ OnlineCardRechargeHistoryActivity f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public gi0(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
        super(1);
        this.f = onlineCardRechargeHistoryActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(OnlineCardRecharge onlineCardRecharge) {
        OnlineCardRecharge onlineCardRecharge2 = onlineCardRecharge;
        n86.e(onlineCardRecharge2, "it");
        OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f;
        int i = OnlineCardRechargeHistoryActivity.o;
        Objects.requireNonNull(onlineCardRechargeHistoryActivity);
        ed1 ed1 = new ed1("ocr history screen card clicked", Long.MIN_VALUE);
        gi1.f1265a.a(ed1, onlineCardRecharge2);
        ui1.m0(ed1);
        String transactionId = onlineCardRecharge2.getCardRechargePaymentProperties().getTransactionId();
        n86.e(transactionId, "lTransactionId");
        n86.e("sourceCardRechargeHistoryActivity", "lSource");
        n86.e(onlineCardRechargeHistoryActivity, "lContext");
        Intent intent = new Intent(onlineCardRechargeHistoryActivity, OnlineCardRechargeSummaryActivity.class);
        intent.putExtra("arg_transactionId", transactionId);
        intent.putExtra("arg_source", "sourceCardRechargeHistoryActivity");
        onlineCardRechargeHistoryActivity.startActivity(intent);
        return s56.f3190a;
    }
}
