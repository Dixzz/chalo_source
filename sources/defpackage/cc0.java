package defpackage;

import android.view.View;
import app.zophop.ui.activities.ActiveMTicketScreen;
import app.zophop.ui.activities.MTicketBookingSummary;

/* renamed from: cc0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class cc0 implements View.OnClickListener {
    public final /* synthetic */ ActiveMTicketScreen f;

    public cc0(ActiveMTicketScreen activeMTicketScreen) {
        this.f = activeMTicketScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog view summary clicked", Long.MIN_VALUE));
        ActiveMTicketScreen activeMTicketScreen = this.f;
        MTicketBookingSummary.i0(activeMTicketScreen, activeMTicketScreen.k, "validation Screen");
        this.f.finish();
    }
}
