package defpackage;

import defpackage.yj1;
import org.json.JSONObject;

/* renamed from: s10  reason: default package */
/* compiled from: FirebasePollingRequestHandler */
public class s10 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3166a;
    public final /* synthetic */ t10 b;

    public s10(t10 t10, String str) {
        this.b = t10;
        this.f3166a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            String str = this.b.e;
            jSONObject2.toString();
            t10 t10 = this.b;
            t10.a(t10, ad1.SUCCESS, t10.e, this.f3166a);
            if (this.b.e.equalsIgnoreCase("route")) {
                t10.b(this.b, jSONObject2);
            } else if (this.b.e.equalsIgnoreCase("eta")) {
                t10.c(this.b, jSONObject2);
            }
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
