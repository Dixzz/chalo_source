package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import app.zophop.ui.activities.MTicketBookingSummary;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: ph0  reason: default package */
/* compiled from: ValidationScreen */
public class ph0 implements View.OnClickListener {
    public final /* synthetic */ ValidationScreen f;

    public ph0(ValidationScreen validationScreen) {
        this.f = validationScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog view summary clicked", Long.MIN_VALUE));
        ValidationScreen validationScreen = this.f;
        if (validationScreen.q != null) {
            Intent intent = new Intent(this.f, BookingSummaryMagicPassActivity.class);
            intent.putExtra("magic_pass_info", this.f.q);
            this.f.startActivity(intent);
            this.f.finish();
            return;
        }
        MTicket mTicket = validationScreen.p;
        if (mTicket != null) {
            MTicketBookingSummary.i0(validationScreen, mTicket, "Validation Screen");
            this.f.finish();
        }
    }
}
