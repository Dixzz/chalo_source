package defpackage;

import defpackage.yj1;
import org.json.JSONObject;

/* renamed from: n40  reason: default package */
/* compiled from: RouteFeature */
public class n40 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2512a;
    public final /* synthetic */ v40 b;

    public n40(v40 v40, String str) {
        this.b = v40;
        this.f2512a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        v40.b(this.b, this.f2512a, jSONObject);
    }
}
