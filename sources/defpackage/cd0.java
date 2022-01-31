package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.CabBookingActivity;
import app.zophop.ui.activities.PickLocationActivity;

/* renamed from: cd0  reason: default package */
/* compiled from: CabBookingActivity */
public class cd0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ CabBookingActivity g;

    public cd0(CabBookingActivity cabBookingActivity, int i) {
        this.g = cabBookingActivity;
        this.f = i;
    }

    public void onClick(View view) {
        String str;
        CabBookingActivity cabBookingActivity = this.g;
        int i = this.f;
        int i2 = CabBookingActivity.K;
        if (i == 1) {
            str = cabBookingActivity.getString(R.string.origin);
        } else {
            str = cabBookingActivity.getString(R.string.destination);
        }
        Intent intent = new Intent(cabBookingActivity, PickLocationActivity.class);
        intent.putExtra("extra:search_copy", str);
        intent.putExtra("extra:show_extra_locations", "true");
        intent.putExtra("extra:source", "cabBooking");
        cabBookingActivity.startActivityForResult(intent, i);
    }
}
