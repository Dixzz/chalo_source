package defpackage;

import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.FerryTripEvent;
import app.zophop.pubsub.eventbus.events.MetroTripEvent;
import com.google.firebase.database.DataSnapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: q40  reason: default package */
/* compiled from: RouteFeature */
public class q40 implements Runnable {
    public final /* synthetic */ TransitMode f;
    public final /* synthetic */ List g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ v40 i;

    public q40(v40 v40, TransitMode transitMode, List list, ArrayList arrayList) {
        this.i = v40;
        this.f = transitMode;
        this.g = list;
        this.h = arrayList;
    }

    public void run() {
        if (ui1.W()) {
            HashMap hashMap = new HashMap();
            i30 A = xt.f3961a.A();
            TransitMode transitMode = this.f;
            HashMap hashMap2 = new HashMap();
            Map<TransitMode, HashMap<String, JSONObject>> map = A.d;
            if (map != null) {
                hashMap2.putAll(map.get(transitMode));
            }
            for (RouteInfo routeInfo : this.g) {
                if (hashMap2.containsKey(routeInfo.getRouteId())) {
                    hashMap.put(routeInfo, (JSONObject) hashMap2.get(routeInfo.getRouteId()));
                }
                this.h.add(this.i.g(routeInfo, (JSONObject) hashMap.get(routeInfo), this.f));
            }
        } else {
            HashMap hashMap3 = new HashMap();
            i30 A2 = xt.f3961a.A();
            TransitMode transitMode2 = this.f;
            HashMap hashMap4 = new HashMap();
            hashMap4.putAll(A2.e.get(transitMode2));
            for (RouteInfo routeInfo2 : this.g) {
                if (hashMap4.containsKey(routeInfo2.getRouteId())) {
                    hashMap3.put(routeInfo2, (DataSnapshot) hashMap4.get(routeInfo2.getRouteId()));
                }
                v40 v40 = this.i;
                TransitMode transitMode3 = this.f;
                Objects.requireNonNull(v40);
                transitMode3.toString().toLowerCase();
                ArrayList<Stop> o = v40.o(routeInfo2.getStopSeq(), transitMode3, routeInfo2);
                List<Route.RouteTiming> m = v40.m((DataSnapshot) hashMap3.get(routeInfo2));
                Collections.sort(m, new m40());
                this.h.add(new Route(routeInfo2, o, o.get(o.size() - 1), m));
            }
        }
        TransitMode transitMode4 = this.f;
        if (transitMode4 == TransitMode.metro) {
            jz5.b().g(new MetroTripEvent(this.h));
        } else if (transitMode4 == TransitMode.ferry) {
            jz5.b().g(new FerryTripEvent(this.h));
        }
    }
}
