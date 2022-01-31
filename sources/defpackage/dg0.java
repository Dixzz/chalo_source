package defpackage;

import android.location.Location;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.TripPlanningActivity;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;

/* renamed from: dg0  reason: default package */
/* compiled from: TripPlanningActivity */
public class dg0 implements g34 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripPlanningActivity f831a;

    public dg0(TripPlanningActivity tripPlanningActivity) {
        this.f831a = tripPlanningActivity;
    }

    @Override // defpackage.g34
    public void a(Location location) {
        if (location != null) {
            TripPlanningActivity tripPlanningActivity = this.f831a;
            if (tripPlanningActivity.z.isVisible()) {
                tripPlanningActivity.z.dismiss();
            }
            xt.t1 t1Var = xt.f3961a;
            t1Var.B().d(this);
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (t1Var.k().d().containsLocation(latLng)) {
                TripPlanningActivity tripPlanningActivity2 = this.f831a;
                tripPlanningActivity2.k = new mf1(latLng, tripPlanningActivity2.getString(R.string.my_location));
                if (this.f831a.k0()) {
                    this.f831a.j0(false);
                    return;
                }
                return;
            }
            TripPlanningActivity tripPlanningActivity3 = this.f831a;
            Toast.makeText(tripPlanningActivity3, tripPlanningActivity3.getString(R.string.location_outside_city_toast), 0).show();
        }
    }
}
