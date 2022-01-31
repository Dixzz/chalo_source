package defpackage;

import android.view.View;
import app.zophop.ui.activities.UserProfileActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;

/* renamed from: xh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xh0 implements View.OnClickListener {
    public final /* synthetic */ OnlineCardRechargeHistoryActivity f;

    public /* synthetic */ xh0(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
        this.f = onlineCardRechargeHistoryActivity;
    }

    public final void onClick(View view) {
        OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f;
        int i = OnlineCardRechargeHistoryActivity.o;
        n86.e(onlineCardRechargeHistoryActivity, "this$0");
        ed1 ed1 = new ed1("ocr history screen login clicked", Long.MIN_VALUE);
        ed1.a("source", "sourceCardRechargeHistoryActivity");
        ui1.m0(ed1);
        onlineCardRechargeHistoryActivity.n.a(UserProfileActivity.h0(onlineCardRechargeHistoryActivity), null);
    }
}
