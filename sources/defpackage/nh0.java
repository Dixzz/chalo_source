package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.ui.activities.MTicketTripReceiptActivity;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: nh0  reason: default package */
/* compiled from: ValidationScreen */
public class nh0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ ValidationScreen h;

    public nh0(ValidationScreen validationScreen, du0 du0, Context context) {
        this.h = validationScreen;
        this.f = du0;
        this.g = context;
    }

    public void onClick(View view) {
        this.f.dismiss();
        MTicket mTicket = this.h.p;
        if (mTicket != null) {
            MTicketTripReceiptActivity.t0("validation screen", mTicket, this.g);
            this.h.finish();
        }
    }
}
