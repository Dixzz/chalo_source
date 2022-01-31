package app.zophop.service;

import android.content.Intent;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class NearbyStopsGeofenceService extends a5 {
    @Override // defpackage.a5
    public void d(Intent intent) {
        HashMap<String, Stop> g;
        xt.t1 t1Var = xt.f3961a;
        a32 a2 = t1Var.B().a();
        if (a2 != null && a2.n() && t1Var.A().j() && ui1.T(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) && t1Var.w().a() == 0 && t1Var.t().b("isGeofenceFeatureEnabled")) {
            try {
                n20 w = t1Var.w();
                LatLng h = t1Var.B().h();
                if (!(h == null || (g = t1Var.A().g(TransitMode.bus)) == null)) {
                    ArrayList arrayList = new ArrayList(g.values());
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Stop stop = (Stop) it.next();
                        if (stop != null) {
                            arrayList2.add(stop);
                        }
                    }
                    Collections.sort(arrayList2, new y80(this, h));
                    int parseInt = Integer.parseInt(xt.f3961a.t().f("geofenceAutoSubscribeMaxStops"));
                    for (int i = 0; i < Math.min(parseInt, arrayList2.size()); i++) {
                        w.b((Stop) arrayList2.get(i), false);
                        f((Stop) arrayList2.get(i));
                        String str = ((Stop) arrayList2.get(i)).getName() + " " + ((Stop) arrayList2.get(i)).getLatLong();
                    }
                    xt.f3961a.w().c(System.currentTimeMillis());
                }
            } catch (Exception e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    public final void f(Stop stop) {
        if (stop != null) {
            ed1 ed1 = new ed1("geofence added", Long.MIN_VALUE);
            ed1.a("stopId", stop.getId());
            ed1.a("stopName", stop.getName());
            ed1.a("mode", stop.getMode().toString());
            jz5.b().g(ed1);
        }
    }
}
