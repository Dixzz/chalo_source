package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.models.autoCabBooking.BookingVehicleInfo;
import app.zophop.ui.activities.CabBookingActivity;

/* renamed from: dd0  reason: default package */
/* compiled from: CabBookingActivity */
public class dd0 implements View.OnClickListener {
    public final /* synthetic */ BookingVehicleInfo f;
    public final /* synthetic */ CabBookingActivity g;

    public dd0(CabBookingActivity cabBookingActivity, BookingVehicleInfo bookingVehicleInfo) {
        this.g = cabBookingActivity;
        this.f = bookingVehicleInfo;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setFlags(268435456);
        StringBuilder i0 = hj1.i0("tel:");
        i0.append(this.f.getDriverNumber());
        intent.setData(Uri.parse(i0.toString()));
        this.g.startActivity(intent);
    }
}
