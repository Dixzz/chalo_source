package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.MTicketTripInfoActivity;
import app.zophop.ui.activities.PickRouteLocationActivity;

/* renamed from: oe0  reason: default package */
/* compiled from: MTicketTripInfoActivity */
public class oe0 implements View.OnClickListener {
    public final /* synthetic */ MTicketTripInfoActivity f;

    public oe0(MTicketTripInfoActivity mTicketTripInfoActivity) {
        this.f = mTicketTripInfoActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f, PickRouteLocationActivity.class);
        intent.putExtra("is_for_result", String.valueOf(true));
        intent.putExtra("is_for_mticket", String.valueOf(true));
        intent.putExtra("src", "mticket booking screen");
        this.f.startActivityForResult(intent, 103);
    }
}
