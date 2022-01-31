package defpackage;

import android.view.View;
import androidx.lifecycle.LiveData;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;

/* renamed from: di0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class di0 implements View.OnClickListener {
    public final /* synthetic */ OnlineCardRechargeSummaryActivity f;

    public /* synthetic */ di0(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity) {
        this.f = onlineCardRechargeSummaryActivity;
    }

    public final void onClick(View view) {
        OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity = this.f;
        int i = OnlineCardRechargeSummaryActivity.l;
        n86.e(onlineCardRechargeSummaryActivity, "this$0");
        ed1 ed1 = new ed1("ocr fare split expanded", Long.MIN_VALUE);
        ed1.a("source", "sourceOnlineCardRechargePaymentSummaryActivity");
        ui1.m0(ed1);
        q91 q91 = onlineCardRechargeSummaryActivity.k;
        if (q91 != null) {
            wh whVar = q91.d;
            Object value = q91.h.getValue();
            n86.d(value, "<get-isFareLayoutExpanded>(...)");
            Object d = ((LiveData) value).d();
            n86.c(d);
            whVar.b("keyFareLayoutExpansionState", Boolean.valueOf(!((Boolean) d).booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
