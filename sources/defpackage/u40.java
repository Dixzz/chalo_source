package defpackage;

import app.zophop.models.Route;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import defpackage.n00;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: u40  reason: default package */
/* compiled from: RouteFeature */
public class u40 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3449a;
    public final /* synthetic */ n00.z0 b;
    public final /* synthetic */ v40 c;

    public u40(v40 v40, String str, n00.z0 z0Var) {
        this.c = v40;
        this.f3449a = str;
        this.b = z0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        try {
            Route b2 = this.c.c.b(jSONObject);
            if (v40.a(this.c, b2)) {
                b2.setLive(false);
            }
            jz5.b().i(new LiveRouteDetailsEvent(ad1.SUCCESS, this.f3449a, b2));
        } catch (JSONException unused) {
            this.b.a(new dk1("malformed json"));
        }
    }
}
