package defpackage;

import android.os.Handler;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import com.google.firebase.database.DataSnapshot;
import defpackage.xt;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: l40  reason: default package */
/* compiled from: RouteFeature */
public class l40 implements Runnable {
    public final /* synthetic */ TransitMode f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Handler h;
    public final /* synthetic */ v40 i;

    public l40(v40 v40, TransitMode transitMode, String str, Handler handler) {
        this.i = v40;
        this.f = transitMode;
        this.g = str;
        this.h = handler;
    }

    public void run() {
        JSONObject jSONObject;
        Route route;
        if (ui1.W()) {
            xt.t1 t1Var = xt.f3961a;
            List<RouteInfo> list = t1Var.A().f;
            List<RouteInfo> list2 = t1Var.A().g;
            if (list == null) {
                route = null;
                jSONObject = null;
            } else if (this.f.name().equals("bus")) {
                route = null;
                jSONObject = null;
                for (RouteInfo routeInfo : list) {
                    if (routeInfo != null && routeInfo.getRouteId().equals(this.g) && routeInfo.getTransitMode().equals(this.f) && (jSONObject = this.i.q(this.g, this.f)) != null) {
                        route = this.i.g(routeInfo, jSONObject, this.f);
                    }
                }
            } else {
                route = null;
                jSONObject = null;
                for (RouteInfo routeInfo2 : list2) {
                    if (routeInfo2 != null && routeInfo2.getRouteId().equals(this.g) && routeInfo2.getTransitMode().equals(this.f) && (jSONObject = this.i.q(this.g, this.f)) != null) {
                        route = this.i.g(routeInfo2, jSONObject, this.f);
                    }
                }
            }
            if (jSONObject == null || route == null) {
                v40 v40 = this.i;
                String str = this.g;
                Objects.requireNonNull(v40);
                jz5.b().i(new RouteDetailsEvent(ad1.FAILED, str, null));
                this.h.getLooper().quit();
                return;
            }
            if (!v40.a(this.i, route)) {
                route.setLive(false);
            }
            jz5.b().i(new RouteDetailsEvent(ad1.SUCCESS, this.g, route));
            this.h.getLooper().quit();
            return;
        }
        v40 v402 = this.i;
        String str2 = this.g;
        TransitMode transitMode = this.f;
        Objects.requireNonNull(v402);
        DataSnapshot b = ai1.b(xt.f3961a.A().i().child(transitMode.toString().toUpperCase()).child(str2));
        DataSnapshot j = this.i.j(this.g, this.f);
        if (!ai1.a(j, b)) {
            v40 v403 = this.i;
            String str3 = this.g;
            Objects.requireNonNull(v403);
            jz5.b().i(new RouteDetailsEvent(ad1.FAILED, str3, null));
            this.h.getLooper().quit();
            return;
        }
        Route h2 = this.i.h(j, b, this.f);
        if (v40.a(this.i, h2)) {
            h2.setLive(false);
        }
        jz5.b().i(new RouteDetailsEvent(ad1.SUCCESS, this.g, h2));
        this.h.getLooper().quit();
    }
}
