package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.ui.activities.BookingSuccessActivity;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import app.zophop.ui.activities.MTicketBookingSummary;
import app.zophop.ui.activities.ScanPayBookingSummary;

/* renamed from: nc0  reason: default package */
/* compiled from: BookingSuccessActivity */
public class nc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSuccessActivity f;

    public nc0(BookingSuccessActivity bookingSuccessActivity) {
        this.f = bookingSuccessActivity;
    }

    public void onClick(View view) {
        BookingSuccessActivity bookingSuccessActivity = this.f;
        int i = BookingSuccessActivity.t;
        bookingSuccessActivity.k0("pass summary details screen opened");
        if (this.f.getIntent().getParcelableExtra("extraMTicket") != null) {
            BookingSuccessActivity bookingSuccessActivity2 = this.f;
            MTicketBookingSummary.i0(bookingSuccessActivity2, (MTicket) bookingSuccessActivity2.getIntent().getParcelableExtra("extraMTicket"), BookingSuccessActivity.class.getSimpleName());
        } else if (this.f.getIntent().getParcelableExtra("magic_pass_info") != null) {
            BookingSummaryMagicPassActivity.p = BookingSuccessActivity.class.getSimpleName();
            Intent intent = new Intent(this.f, BookingSummaryMagicPassActivity.class);
            intent.putExtra("magic_pass_info", (MPass) this.f.getIntent().getParcelableExtra("magic_pass_info"));
            this.f.startActivity(intent);
        } else if (this.f.getIntent().getParcelableExtra("scanPayInfo") != null) {
            BookingSuccessActivity bookingSuccessActivity3 = this.f;
            ScanPayBookingSummary.h0(bookingSuccessActivity3, (ScanPayTicket) bookingSuccessActivity3.getIntent().getParcelableExtra("scanPayInfo"), BookingSuccessActivity.class.getSimpleName());
        }
    }
}
