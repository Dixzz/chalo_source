package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.ui.activities.MTicketBookingSummary;
import app.zophop.ui.activities.MTicketTripReceiptActivity;

/* renamed from: ie0  reason: default package */
/* compiled from: MTicketBookingSummary */
public class ie0 implements View.OnClickListener {
    public final /* synthetic */ Context f;
    public final /* synthetic */ MTicketBookingSummary g;

    public ie0(MTicketBookingSummary mTicketBookingSummary, Context context) {
        this.g = mTicketBookingSummary;
        this.f = context;
    }

    public void onClick(View view) {
        MTicketTripReceiptActivity.t0("MTicketBookingSummaryActivity", this.g.l, this.f);
    }
}
