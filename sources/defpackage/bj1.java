package defpackage;

import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import java.util.Iterator;

/* renamed from: bj1  reason: default package */
/* compiled from: ZophopETACalculatorUtilities */
public class bj1 {

    /* renamed from: a  reason: collision with root package name */
    public final RouteWithoutTimings f439a;
    public final Stop b;
    public Stop c;

    public bj1(RouteWithoutTimings routeWithoutTimings, Stop stop) {
        this.f439a = routeWithoutTimings;
        this.b = stop;
    }

    public double a(LatLng latLng, LatLng latLng2) {
        Stop stop;
        Iterator<Stop> it = this.f439a.getStopSequence().iterator();
        while (true) {
            if (!it.hasNext()) {
                stop = null;
                break;
            }
            stop = it.next();
            if (stop.getLatLong().latitude == latLng2.latitude && stop.getLatLong().longitude == latLng2.longitude) {
                break;
            }
        }
        int s = vn.s(this.f439a.getStopSequence(), this.c);
        int s2 = vn.s(this.f439a.getStopSequence(), stop);
        Stop stop2 = this.c;
        if (stop2 == null || s == -1 || s2 == -1 || s > s2) {
            return -1.0d;
        }
        double m = ui1.m(latLng, stop2.getLatLong());
        while (s < s2) {
            s++;
            m += ui1.m(this.f439a.getStopSequence().get(s).getLatLong(), this.f439a.getStopSequence().get(s).getLatLong());
        }
        return m;
    }

    public double b() {
        return this.f439a.getMode().equals(TransitMode.bus) ? 5.6d : 8.0d;
    }
}
