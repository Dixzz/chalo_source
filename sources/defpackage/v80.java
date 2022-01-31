package defpackage;

import android.content.Context;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import server.zophop.models.Point;

/* renamed from: v80  reason: default package */
/* compiled from: CheckinValidator */
public class v80 {

    /* renamed from: a  reason: collision with root package name */
    public int f3615a;
    public int b;
    public final RouteWithoutTimings c;
    public LatLng d;
    public final boolean e;
    public Stop f;
    public Stop g;
    public Stop h;
    public Stop i;
    public double j = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public int k;
    public final List<Point> l;
    public final z30 m;

    /* renamed from: v80$a */
    /* compiled from: CheckinValidator */
    public enum a {
        WAITING_START_STOP,
        WAITING_MOVE_AWAY,
        START,
        NEAR,
        STOP
    }

    public v80(Context context, RouteWithoutTimings routeWithoutTimings, Stop stop, boolean z) {
        this.c = routeWithoutTimings;
        this.g = stop;
        this.l = new ArrayList();
        this.m = xt.f3961a.N();
        this.f3615a = 0;
        this.b = 0;
        a aVar = a.WAITING_START_STOP;
        this.e = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03f7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03f8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a() {
        /*
        // Method dump skipped, instructions count: 1017
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v80.a():int");
    }

    public long b() {
        if (this.l.size() < 2) {
            return 0;
        }
        return ((Point) hj1.t(this.l, -1)).getTime() - this.l.get(0).getTime();
    }

    public final void c(Stop stop) {
        this.f = stop;
        this.h = stop;
        int indexOf = this.c.getStopSequence().indexOf(this.f) + 1;
        this.k = indexOf;
        if (indexOf != this.c.getStopSequence().size()) {
            this.i = this.c.getStopSequence().get(this.k);
        } else {
            this.i = this.f;
        }
    }
}
