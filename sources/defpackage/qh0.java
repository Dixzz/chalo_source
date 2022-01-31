package defpackage;

import app.zophop.R;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.ui.activities.ValidationScreen;
import java.util.Objects;

/* renamed from: qh0  reason: default package */
/* compiled from: ValidationScreen */
public class qh0 implements Runnable {
    public final /* synthetic */ MTicketTripReceipt f;
    public final /* synthetic */ ValidationScreen g;

    public qh0(ValidationScreen validationScreen, MTicketTripReceipt mTicketTripReceipt) {
        this.g = validationScreen;
        this.f = mTicketTripReceipt;
    }

    public void run() {
        xt.f3961a.g0().a();
        this.g.getWindow().clearFlags(128);
        this.g.l.removeCallbacksAndMessages(null);
        this.g.p.setMticketTripReceipt(this.f);
        ValidationScreen validationScreen = this.g;
        Objects.requireNonNull(validationScreen);
        du0 f2 = du0.f(validationScreen.getSupportFragmentManager(), validationScreen.getString(R.string.view_receipt_bottomsheet_title), validationScreen.getString(R.string.view_receipt_bottomsheet_copy), validationScreen.getString(R.string.okay), validationScreen.getString(R.string.view_receipt_caps), 1, R.drawable.ticket_punch_success, "validation screen");
        f2.setCancelable(false);
        f2.e(new mh0(validationScreen, f2));
        f2.d(new nh0(validationScreen, f2, validationScreen));
    }
}
