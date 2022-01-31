package defpackage;

import android.view.View;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.MTicketBookingSummary;
import defpackage.xt;

/* renamed from: he0  reason: default package */
/* compiled from: MTicketBookingSummary */
public class he0 implements View.OnClickListener {
    public final /* synthetic */ MTicketBookingSummary f;

    public he0(MTicketBookingSummary mTicketBookingSummary) {
        this.f = mTicketBookingSummary;
    }

    public void onClick(View view) {
        MTicketBookingSummary mTicketBookingSummary = this.f;
        if (!mTicketBookingSummary.m.isVisible()) {
            mTicketBookingSummary.m.show(mTicketBookingSummary.getFragmentManager(), "loader_tag");
        }
        xt.t1 t1Var = xt.f3961a;
        String B = hj1.B(t1Var);
        v40 U = t1Var.U();
        String routeId = this.f.l.getUpTripRouteStopsInfo().getRouteId();
        TransitMode transitMode = TransitMode.bus;
        U.d(routeId, B);
    }
}
