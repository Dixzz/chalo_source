package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.room.ProductRepository;

public class MTicketNotificationRouter extends au {
    public MTicket k;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        g30 g30 = new g30(getIntent());
        if (g30.a()) {
            MTicket mTicket = new ProductRepository(getApplicationContext()).getCurrentTicket(g30.f1208a.get("pass_info")).getmTicket();
            this.k = mTicket;
            if (mTicket != null) {
                ed1 ed1 = new ed1("mticket notification is read", Long.MIN_VALUE);
                vn.a(ed1, mTicket);
                jz5.b().g(ed1);
            }
        }
        MTicket mTicket2 = this.k;
        if (mTicket2 == null) {
            startActivity(new Intent(this, HomeActivity.class));
        } else if (mTicket2.isMTicketExpired()) {
            MTicketBookingSummary.i0(this, mTicket2, "notification");
        } else if (!mTicket2.isUpTripActivated()) {
            ActivateMTicketScreen.h0(this, mTicket2, "notification", true);
        } else if (mTicket2.isMTicketActive()) {
            ActiveMTicketScreen.i0(this, mTicket2, "notification", true);
        } else {
            MTicketBookingSummary.i0(this, mTicket2, "notification");
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, defpackage.au
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
