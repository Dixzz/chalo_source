package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;

/* renamed from: yh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yh0 implements View.OnClickListener {
    public final /* synthetic */ OnlineCardRechargeHistoryActivity f;

    public /* synthetic */ yh0(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
        this.f = onlineCardRechargeHistoryActivity;
    }

    public final void onClick(View view) {
        OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f;
        int i = OnlineCardRechargeHistoryActivity.o;
        n86.e(onlineCardRechargeHistoryActivity, "this$0");
        ed1 ed1 = new ed1("ocr history screen recharge btn clicked", Long.MIN_VALUE);
        ed1.a("source", "sourceCardRechargeHistoryActivity");
        ui1.m0(ed1);
        n86.e("sourceCardRechargeHistoryActivity", "lSource");
        n86.e(onlineCardRechargeHistoryActivity, "lContext");
        Intent intent = new Intent(onlineCardRechargeHistoryActivity, CardRechargeActivity.class);
        intent.putExtra("arg_source", "sourceCardRechargeHistoryActivity");
        onlineCardRechargeHistoryActivity.startActivity(intent);
    }
}
