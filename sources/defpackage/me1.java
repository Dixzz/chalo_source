package defpackage;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: me1  reason: default package */
/* compiled from: LocationsProvider */
public class me1 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2363a;
    public final /* synthetic */ String b;
    public final /* synthetic */ le1 c;

    public me1(le1 le1, String str, String str2) {
        this.c = le1;
        this.f2363a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject(FirebaseAnalytics.Param.LOCATION);
            LatLng latLng = new LatLng(jSONObject3.getDouble("lat"), jSONObject3.getDouble("lng"));
            latLng.toString();
            this.c.k(this.f2363a, latLng, ad1.SUCCESS, true, this.b);
        } catch (JSONException e) {
            e.toString();
            jSONObject2.toString();
            this.c.k(this.f2363a, null, ad1.FAILED, true, this.b);
        }
    }
}
