package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;

/* renamed from: xw0  reason: default package */
/* compiled from: TripMapFragment */
public class xw0 extends ev0 {
    public Trip w;
    public final HashMap<Marker, View> x = new HashMap<>();

    @Override // defpackage.e44.e
    public void a(Marker marker) {
    }

    @Override // defpackage.e44.b
    public View b(Marker marker) {
        if (l(marker) == -1) {
            return null;
        }
        if (!this.x.containsKey(marker)) {
            Stop m = m(this.i.get(marker).intValue());
            Activity activity = getActivity();
            Trip trip = this.w;
            this.x.put(marker, new bc1(activity, m, trip, ui1.G(trip, "", ""), marker));
        }
        return (bc1) this.x.get(marker);
    }

    @Override // defpackage.e44.f
    public void c(Marker marker) {
    }

    @Override // defpackage.e44.b
    public View d(Marker marker) {
        return null;
    }

    @Override // defpackage.ev0
    public int h() {
        return this.w.getTripLegs().size();
    }

    @Override // defpackage.ev0
    public TransitMode j() {
        return this.w.getTransitMode();
    }

    @Override // defpackage.ev0
    public String k() {
        return "";
    }

    @Override // defpackage.ev0
    public Stop m(int i) {
        return this.w.getTripLegs().get(i).getStop();
    }

    @Override // defpackage.ev0
    public Stop n(String str) {
        for (int i = 0; i < this.w.getTripLegs().size(); i++) {
            if (this.w.getTripLegs().get(i).getStop().getId().equalsIgnoreCase(str)) {
                return this.w.getTripLegs().get(i).getStop();
            }
        }
        return null;
    }

    @Override // defpackage.ev0
    public void o(Bundle bundle) {
        LayoutInflater.from(getActivity());
        if (bundle != null && bundle.containsKey("extra:trip")) {
            Trip trip = (Trip) hj1.s(bundle.getString("extra:trip"), Trip.class);
            this.w = trip;
            this.m = trip.get_routeId();
        }
    }
}
