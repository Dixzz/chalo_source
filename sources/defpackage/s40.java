package defpackage;

import app.zophop.models.Route;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsListEvent;
import defpackage.n00;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* renamed from: s40  reason: default package */
/* compiled from: RouteFeature */
public class s40 implements yj1.b<JSONArray> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3181a;
    public final /* synthetic */ n00.z0 b;
    public final /* synthetic */ v40 c;

    public s40(v40 v40, String str, n00.z0 z0Var) {
        this.c = v40;
        this.f3181a = str;
        this.b = z0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONArray jSONArray) {
        JSONArray jSONArray2 = jSONArray;
        try {
            ArrayList arrayList = new ArrayList();
            if (jSONArray2 != null) {
                for (int i = 0; i < jSONArray2.length(); i++) {
                    arrayList.add(this.c.c.b(jSONArray2.getJSONObject(i)));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Route route = (Route) it.next();
                    if (v40.a(this.c, route)) {
                        route.setLive(false);
                    }
                }
            }
            jz5.b().i(new LiveRouteDetailsListEvent(this.f3181a, ad1.SUCCESS, arrayList));
        } catch (Exception e) {
            e.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            this.b.a(new dk1("malformed json"));
        }
    }
}
